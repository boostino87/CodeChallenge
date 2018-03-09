package it.coluccia.codechallenge.meetingRooms;



import java.util.Comparator;

public class EventComparatorScore implements Comparator<Event> {

	public int compare(Event event1, Event event2) {
		long millis1 = event1.getTimeEnd().getTime() - event1.getTimeStart().getTime();
		long millis2 = event2.getTimeEnd().getTime() - event2.getTimeStart().getTime();
		
		if(millis1*event1.getnParticipants() > millis2*event2.getnParticipants()){
			return 1;
		}
		else if(millis1*event1.getnParticipants() < millis2*event2.getnParticipants()){
			return -1;
		}
		else{
			return 0;
		}
	}

}
