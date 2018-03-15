package it.coluccia.codechallenge2018.boh;

import java.util.Map;

public class Project {
	
	private long indexProject;
	
	private String country;
	
	private int penalty;
	
	private Map<String, Integer> packages;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	public Map<String, Integer> getPackages() {
		return packages;
	}

	public void setPackages(Map<String, Integer> packages) {
		this.packages = packages;
	}

	public long getIndexProject() {
		return indexProject;
	}

	public void setIndexProject(long indexProject) {
		this.indexProject = indexProject;
	}
	

	
	
	
}
