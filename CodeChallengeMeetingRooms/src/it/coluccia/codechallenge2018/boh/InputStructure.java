package it.coluccia.codechallenge2018.boh;

import java.util.List;
import java.util.Map;

public class InputStructure {
	
	private long nProviders;
	private long nServices;
	private long nCountries;
	private long nProjects;
	
	private List<String> serviceNames;
	
	private List<String> countryNames;
	
	private Map<String, Provider> providers;
	
	private List< Project> projects;
	
	public long getnProviders() {
		return nProviders;
	}

	public void setnProviders(long nProviders) {
		this.nProviders = nProviders;
	}

	public long getnServices() {
		return nServices;
	}

	public void setnServices(long nServices) {
		this.nServices = nServices;
	}

	public long getnCountries() {
		return nCountries;
	}

	public void setnCountries(long nCountries) {
		this.nCountries = nCountries;
	}

	public long getnProjects() {
		return nProjects;
	}

	public void setnProjects(long nProjects) {
		this.nProjects = nProjects;
	}

	public List<String> getServiceNames() {
		return serviceNames;
	}

	public void setServiceNames(List<String> serviceNames) {
		this.serviceNames = serviceNames;
	}

	public List<String> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(List<String> countryNames) {
		this.countryNames = countryNames;
	}

	public Map<String, Provider> getProviders() {
		return providers;
	}

	public void setProviders(Map<String, Provider> providers) {
		this.providers = providers;
	}

	public List< Project> getProjects() {
		return projects;
	}

	public void setProjects(List< Project> projects) {
		this.projects = projects;
	}

	
	
	
	/*private List<Event> eventListInput;
	private List<Room> roomListInput;
	
	public InputStructure(){
		eventListInput = new ArrayList<>();
		roomListInput = new ArrayList<>();
	}
	
	
	public List<Event> getEventListInput() {
		return eventListInput;
	}
	public void setEventListInput(List<Event> eventListInput) {
		this.eventListInput = eventListInput;
	}
	public List<Room> getRoomListInput() {
		return roomListInput;
	}
	public void setRoomListInput(List<Room> roomListInput) {
		this.roomListInput = roomListInput;
	}*/
	
 
	
	
}
