package it.coluccia.codechallenge.meetingRooms;

import java.util.Comparator;

public class RoomComparator implements Comparator<Room> {
	
	public int compare(Room room1, Room room2) {
		
		if(room1.getCapacity()>room2.getCapacity()){
			return 1;
		}
		else if(room1.getCapacity() < room2.getCapacity()){
			return -1;
		}
		else{
			return 0;
		}
	}


}
