package it.coluccia.codechallenge.meetingRooms;



import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

	public int compare(Event event1, Event event2) {
		
		return event1.getTimeStart().compareTo(event2.getTimeStart());
	}

}
