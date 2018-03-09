package it.coluccia.codechallenge.meetingRooms;

import java.util.Date;

public class Interval {
	
	private Date timeStart;
	private Date timeEnd;
	
	public Interval()
	{
		
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

}
