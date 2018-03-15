package it.coluccia.codechallenge.meetingRooms;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException, ParseException{
		InputStructure input = InputParser.parseInputFile("../CodeChallengeMeetingRooms/InputFiles/data_50000_100.in");
		System.out.println("###################################INPUT PARSED");
		List<Room> roomList = new ArrayList<Room>();
		
		roomList = executeGreedyAlgorithm(input);
		System.out.println("###################################ALGORITHM EXECUTED");
		
		OutputGenerator outGen = new OutputGenerator();
		outGen.generateOutput(roomList);
	}
	
	/**
	 * Esegue algoritmo greedy.
	 * @param input
	 * @return
	 */
	private static List<Room> executeGreedyAlgorithm(InputStructure input){
		List<Event> events = new ArrayList<>(null);
		List<Room> rooms = new ArrayList<>(null);
		Collections.sort(rooms, new RoomComparator());
		//Collections.reverse(rooms);
		
		for(Room room : rooms){
			boolean notExit = true;
			while(notExit){
				Event eventChoice = findBestEventForRoom(room,events);
				if(eventChoice == null){
					System.out.println("Nessun evento scelto per stanza "+room.getName());
					notExit = false;
				}
				else{
					System.out.println("Scelto evento "+eventChoice.getTopic()+" per stanza "+room.getName());
					room.getEventList().add(eventChoice);
					events.remove(eventChoice);
				}
			}
		}
		System.out.println("#########------EVENTI NON ASSEGNATI: "+events.size());
		return rooms;

	}
	
	private static Event findBestEventForRoom(Room room, List<Event> events){
		Event bestEvent = null;
		long bestEventPeople = Integer.MIN_VALUE;
		List<Event> cleanEvents = removeBadEvents(events,room);
		Collections.sort(cleanEvents, new EventComparatorScore());
		//Collections.reverse(cleanEvents);
		for(Event event : cleanEvents){
			if(event.getnParticipants() <= room.getCapacity() && !overlapRoomEvents(room.getEventList(),event)){
				if((event.getnParticipants()*(event.getTimeEnd().getTime() - event.getTimeStart().getTime()))>bestEventPeople){
					bestEventPeople = event.getnParticipants()*(event.getTimeEnd().getTime() - event.getTimeStart().getTime());
					bestEvent = event;
				}
			}
		}
		return bestEvent;
	}
	
	private static List<Event> removeBadEvents(List<Event> events, Room room){
		List<Event> eventsClean = new ArrayList<>();
		for(Event ev : events){
			if(ev.getnParticipants() <= room.getCapacity()){
				eventsClean.add(ev);
			}
		}
		return eventsClean;
	}
	
	private static boolean overlapRoomEvents(List<Event> events, Event event){
		for(Event eventToNotOverlap : events){
			if(event.getTimeStart().after(eventToNotOverlap.getTimeStart())){
				if(event.getTimeStart().before(eventToNotOverlap.getTimeEnd())){
					return true;
				}
			}
			else if(event.getTimeStart().before(eventToNotOverlap.getTimeStart())){
				if(event.getTimeEnd().after(eventToNotOverlap.getTimeStart())){
					return true;
				}
			}
			else{
				//iniziano allo stesso momento
				return true;
			}
		}
		return false;
	}
	
	private static int calculateScore(List<Room> rooms){
		//TODO
		return 0;
		
	}
}
