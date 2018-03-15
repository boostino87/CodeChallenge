package it.coluccia.codechallenge2018.boh;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class OutputGenerator {
	
	private SimpleDateFormat dateFormat;
	
	public OutputGenerator()
	{
		dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
	}
	
	public void generateOutput(List<OutputProject> projectList) {
		
		PrintWriter outPrintWriter = null;
		String now = dateFormat.format(new Date());
		File outFile = new File(String.format("OutputFiles\\2018out_%s.txt", now));
		
		try {
			
			if(projectList != null) {
				
				Collections.sort(projectList, new ProjectComparator());
				
				outPrintWriter = new PrintWriter(outFile);
				
				
				for(OutputProject project : projectList){
					boolean first = true;
					for(Assegnamento assegnamento : project.getAssegnamenti()){
						String assegnamentiOut = "";
						if (first) {
							first = false;
						} else {
							assegnamentiOut = " ";
						}
						assegnamentiOut += assegnamento.getIndiceProvider()+" "+assegnamento.getIndiceRegionProvider()+" "+assegnamento.getNumPacchetti();
						outPrintWriter.print(assegnamentiOut);
					}
					outPrintWriter.println();
					
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(outPrintWriter != null) {
				outPrintWriter.flush();
				outPrintWriter.close();
				
			}
		}
			
	}

}
