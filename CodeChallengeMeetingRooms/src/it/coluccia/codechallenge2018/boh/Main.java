package it.coluccia.codechallenge2018.boh;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;



public class Main {
	
	public static void main(String[] args) throws IOException, ParseException{
		InputStructure input = InputParser.parseInputFile("InputFiles/2018/first_Adventure.in");
		System.out.println("###################################INPUT PARSED");
		List<OutputProject> roomList = new ArrayList<OutputProject>();
		
		//roomList = executeGreedyAlgorithm(input);
		System.out.println("###################################ALGORITHM EXECUTED");
		
		OutputGenerator outGen = new OutputGenerator();
		outGen.generateOutput(roomList);
	}
	
	
	/*private static List<OutputProject> executeGreedyAlgorithm(InputStructure input){
		input.getProjects();
	}*/

}
