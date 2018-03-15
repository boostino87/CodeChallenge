package it.coluccia.codechallenge2018.boh;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Main {
	
	public static void main(String[] args) throws IOException, ParseException{
		InputStructure input = InputParser.parseInputFile("../CodeChallengeMeetingRooms/InputFiles/2018/data_50000_100.in");
		System.out.println("###################################INPUT PARSED");
		List<OutputProject> roomList = new ArrayList<OutputProject>();
		
		roomList = executeGreedyAlgorithm(input);
		System.out.println("###################################ALGORITHM EXECUTED");
		
		OutputGenerator outGen = new OutputGenerator();
		outGen.generateOutput(roomList);
	}
	
	
	private static List<OutputProject> executeGreedyAlgorithm(InputStructure input){
		List<Project> projects = new ArrayList<Project>(input.getProjects().values());
		List<Provider> providers = new ArrayList<Provider>(input.getProviders().values());
		List<OutputProject> output = new ArrayList<>();
		for(Project project : projects){
			List<Object> packages = Arrays.asList(project.getPackages().keySet().toArray());
			for(Provider provider : providers ){
				List<Region> regions = new ArrayList<Region>(provider.getRegions().values());
				RegionsComparator regCompare = new RegionsComparator(project.getCountry());
				Collections.sort(regions, regCompare);
				for(Region region : regions){
					if(disponibile(region,project)){//se ha abbastanza pacchetti
						Assegnamento assegnamento = new Assegnamento();
						
					}
				}
			}
		}
	}
	
	
	private static boolean disponibile(Region region, Project project){
		for(String serviceName : project.getPackages().keySet()){
			if(region.getPackages().get(serviceName)*region.getnPackages() < project.getPackages().get(serviceName)){	
				return false;
			}
		}
		return true;
		
		
	}

}
