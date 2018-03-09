package it.coluccia.codechallenge.meetingRooms;


import java.util.Date;

public class Event {
	
	private String topic;
	private Date timeStart;
	private Date timeEnd;
	private int nParticipants;
	private Room room;
	
	public Event()
	{
	}
	
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Date getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}
	public Date getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
	public int getnParticipants() {
		return nParticipants;
	}
	public void setnParticipants(int nParticipants) {
		this.nParticipants = nParticipants;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	@Override
	public boolean equals(Object other){
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Event))return false;
	    Event otherObj = (Event)other;
	    return otherObj.topic.equalsIgnoreCase(topic);
	}

}
