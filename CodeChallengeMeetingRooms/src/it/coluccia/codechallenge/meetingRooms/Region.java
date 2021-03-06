package it.coluccia.codechallenge.meetingRooms;

import java.util.Map;

public class Region {
	
	
	private String regionName;
	
	private double packageUnitCost;
	
	private Map<String, Integer> packages;
	
	private Map<String, Long> latencies;

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public double getPackageUnitCost() {
		return packageUnitCost;
	}

	public void setPackageUnitCost(double packageUnitCost) {
		this.packageUnitCost = packageUnitCost;
	}

	public Map<String, Integer> getPackages() {
		return packages;
	}

	public void setPackages(Map<String, Integer> packages) {
		this.packages = packages;
	}

	public Map<String, Long> getLatencies() {
		return latencies;
	}

	public void setLatencies(Map<String, Long> latencies) {
		this.latencies = latencies;
	}
	
	
}
