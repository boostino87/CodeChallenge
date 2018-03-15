package it.coluccia.codechallenge2018.boh;

import java.util.Comparator;

public class RegionsComparator implements Comparator<Region> {
	
	String country;
	RegionsComparator(String country){
		this.country = country;
	}

	public int compare(Region reg1, Region reg2) {
		
		return reg1.getLatencies().get(country).compareTo(reg2.getLatencies().get(country));
	}



}
