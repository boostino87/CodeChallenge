package it.coluccia.codechallenge.meetingRooms;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class InputParser {
	
	public static InputStructure parseInputFile(String fileFullPath) throws IOException, ParseException{
		
		InputStructure inputStructure = new InputStructure();
		
        File f = new File(fileFullPath);

        List<String> lines = FileUtils.readLines(f, "UTF-8");
        
        int numberEvents = extractEventsNumber(lines.get(0));
        int numberRooms = extractRoomsNumber(lines.get(0));
        
        lines.remove(0);

        for (String line : lines) {
        	if(numberEvents != 0){
        		parseEvent(line,inputStructure);
        		numberEvents--;
        	}
        	else{
        		if(numberRooms != 0){
        			parseRoom(line,inputStructure);
        			numberRooms--;
        		}
        	}
        }
        
        if(numberEvents != 0 || numberRooms != 0 ){
        	throw new RuntimeException("NON SONO STATE PARSIFICATI TUTTI GLI EVENTI E/O LE STANZE!");
        }

        return inputStructure;

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
