package it.coluccia.codechallenge2018.boh;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

public class InputParser {
	
	public static InputStructure parseInputFile(String fileFullPath) throws IOException, ParseException{
		
		InputStructure inputStructure = new InputStructure();
		
        File f = new File(fileFullPath);

        List<String> lines = FileUtils.readLines(f, "UTF-8");
        
        long[] numbers = extractNumbers(lines.get(0));
        long nProvider = numbers[0];
        long nService = numbers[1];
        long nCountry = numbers[2];
        long nProject = numbers[3];
        
        inputStructure.setnProviders(nProvider);
        inputStructure.setnServices(nService);
        inputStructure.setnCountries(nCountry);
        inputStructure.setnProjects(nProject);
        
        List<String> serviceNames = extractListNames(lines.get(1));
        inputStructure.setServiceNames(serviceNames);
        
        List<String> countryNames = extractListNames(lines.get(2));
        inputStructure.setCountryNames(countryNames);
        inputStructure.setProviders(new TreeMap<String, Provider>());
        inputStructure.setProjects(new TreeMap<String, Project>());
        int nLines = 3;
        for (long i=0; i<nProvider; i++) {
        	String[] arr = lines.get(nLines++).split(" ");
        	Provider provider = new Provider();
        	
        	provider.setProviderName(arr[0]);
        	int nRegion = Integer.parseInt(arr[1]);
        	provider.setnRegion(nRegion);
        	inputStructure.getProviders().put(provider.getProviderName(), provider);
        	provider.setRegions(new TreeMap<String, Region>());
        	 for (int j=0; j<nRegion; j++) {
        		 Region region = new Region();
        		 region.setRegionName(lines.get(nLines++));
        		 String[] packages = lines.get(nLines++).split(" ");
        		 region.setnPackages(Long.parseLong(packages[0]));
        		 region.setPackageUnitCost(Double.parseDouble(packages[1]));
        		 region.setPackages(new TreeMap<String,Integer>());
        		 int count = 2;
        		 for (String service: serviceNames) {
        			 region.getPackages().put(service, Integer.parseInt(packages[count++]));
        		 }
        		 
        		 region.setLatencies(extractLatencies(lines.get(nLines++), countryNames));
        		 provider.getRegions().put(region.getRegionName(), region);
        		 
        		 
        	 }
        }
        
        
        return inputStructure;

	}
	
	private static Map<String, Long> extractLatencies(String string, List<String> countryNames) {
		String[] sssss = string.split(" ");
		Map<String, Long> res = new TreeMap<String,Long>();
		 int count = 0;
		 for (String country: countryNames) {
			 res.put(country, Long.parseLong(sssss[count++]));
		 }
		
		
		return res;
	}


	private static List<String> extractListNames(String string) {
		String[] s = string.split(" ");
		List<String> res = new ArrayList<>();
		for (String a: s) {
			res.add(a);
		}
		return res;
	}

	private static long[] extractNumbers(String line) {
		String[] s = line.split(" ");
		long[] num = new long[s.length];
		int i=0;
		for (String a: s) {
			num[i++] = Long.parseLong(a);
		}
		return num;
	}
	
	private static int extractEventsNumber(String line){
		return Integer.parseInt(line.split(" ")[0]);
	}
	
	private static int extractRoomsNumber(String line){
		return Integer.parseInt(line.split(" ")[1]);
	}
	
	private static void parseEvent(String line, InputStructure inputStructureToEdit) throws ParseException{
		String eventName;
		Date startTime;
		Date endTime;
		int nParticipants;

		String[] splittedLine = line.split(" ");
		eventName = splittedLine[0];
		startTime = new Date(Long.parseLong(splittedLine[1]));
		endTime = new Date(Long.parseLong(splittedLine[2]));
		nParticipants = Integer.parseInt(splittedLine[3]);
		
		Event event = new Event();
		event.setnParticipants(nParticipants);
		event.setRoom(new Room());
		event.setTimeEnd(endTime);
		event.setTimeStart(startTime);
		event.setTopic(eventName);
		
		inputStructureToEdit.getEventListInput().add(event);
	}
	
	private static void parseRoom(String line, InputStructure inputStructureToEdit) throws ParseException{
		String roomName;
		int capacity;

		String[] splittedLine = line.split(" ");
		
		roomName = splittedLine[0];
		capacity = Integer.parseInt(splittedLine[1]);
		
		Room room = new Room();
		room.setCapacity(capacity);
		room.setEventList(new ArrayList<Event>());
		room.setIntervalList(new ArrayList<Interval>());
		room.setName(roomName);
		
		inputStructureToEdit.getRoomListInput().add(room);

	}

}
