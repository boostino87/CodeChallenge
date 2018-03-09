package it.coluccia.codechallenge.meetingRooms;

import java.util.ArrayList;
import java.util.List;

public class InputStructure {
	private List<Event> eventListInput;
	private List<Room> roomListInput;
	
	public InputStructure(){
		eventListInput = new ArrayList<>();
		roomListInput = new ArrayList<>();
	}
	
	
	public List<Event> getEventListInput() {
		return eventListInput;
	}
	public void setEventListInput(List<Event> eventListInput) {
		this.eventListInput = eventListInput;
	}
	public List<Room> getRoomListInput() {
		return roomListInput;
	}
	public void setRoomListInput(List<Room> roomListInput) {
		this.roomListInput = roomListInput;
	}
	
	
	
	
}
