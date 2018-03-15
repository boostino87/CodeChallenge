package it.coluccia.codechallenge2018.boh;



import java.util.Comparator;

public class ProjectComparator implements Comparator<OutputProject> {

	public int compare(OutputProject outProj1, OutputProject outProj2) {
		
		return outProj1.getOrderIndex()-outProj2.getOrderIndex();
	}

}
