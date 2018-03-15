package it.coluccia.codechallenge2018.boh;

import java.util.Map;

public class Provider {
	private String providerName;
	
	private int nRegion;
	
	private Map<String, Region> regions;

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public int getnRegion() {
		return nRegion;
	}

	public void setnRegion(int nRegion) {
		this.nRegion = nRegion;
	}

	public Map<String, Region> getRegions() {
		return regions;
	}

	public void setRegions(Map<String, Region> regions) {
		this.regions = regions;
	}
	
	
}
