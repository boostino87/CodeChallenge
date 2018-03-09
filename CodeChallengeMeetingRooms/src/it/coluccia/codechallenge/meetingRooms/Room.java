package it.coluccia.codechallenge.meetingRooms;

import java.util.List;

public class Room {
	
	private String name;
	private int capacity;
	private List<Event> eventList;
	private List<Interval> intervalList;
	
	public Room()
	{
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public List<Event> getEventList() {
		return eventList;
	}
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
	public List<Interval> getIntervalList() {
		return intervalList;
	}
	public void setIntervalList(List<Interval> intervalList) {
		this.intervalList = intervalList;
	}

}
