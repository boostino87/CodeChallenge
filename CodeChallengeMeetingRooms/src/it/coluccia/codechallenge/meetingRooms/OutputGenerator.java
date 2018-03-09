package it.coluccia.codechallenge.meetingRooms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class OutputGenerator {
	
	private SimpleDateFormat dateFormat;
	
	public OutputGenerator()
	{
		dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
	}
	
	public void generateOutput(List<Room> roomList) {
		
		PrintWriter outPrintWriter = null;
		String now = dateFormat.format(new Date());
		File outFile = new File(String.format("C:\\Workspaces\\workspaceCodeChallenge\\CodeChallengeMeetingRooms\\OutputFiles\\out_%s.txt", now));
		
		try {
			
			if(roomList != null) {
				
				outPrintWriter = new PrintWriter(outFile);
				
				for(Room room : roomList){
					//sort events
					Collections.sort(room.getEventList(), new EventComparator());
					String sortedEventListOutput = "";
					for(Event event : room.getEventList())
						sortedEventListOutput += String.format("%s ", event.getTopic());
					
					//print room with events
					String roomOutput = String.format("%s:%s", room.getName(), sortedEventListOutput.trim());
					outPrintWriter.println(roomOutput);
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(outPrintWriter != null) {
				outPrintWriter.flush();
				outPrintWriter.close();
				
			}
		}
			
	}

}
