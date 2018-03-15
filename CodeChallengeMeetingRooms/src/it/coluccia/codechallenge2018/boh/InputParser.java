package it.coluccia.codechallenge2018.boh;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

public class InputParser {

	public static InputStructure parseInputFile(String fileFullPath) throws IOException, ParseException {

		InputStructure inputStructure = new InputStructure();

		File f = new File(fileFullPath);

		List<String> lines = FileUtils.readLines(f, "UTF-8");

		long[] numbers = extractNumbers(lines.get(0));
		long nProvider = numbers[0];
		long nService = numbers[1];
		long nCountry = numbers[2];
		long nProject = numbers[3];

		inputStructure.setnProviders(nProvider);
		inputStructure.setnServices(nService);
		inputStructure.setnCountries(nCountry);
		inputStructure.setnProjects(nProject);

		List<String> serviceNames = extractListNames(lines.get(1));
		inputStructure.setServiceNames(serviceNames);

		List<String> countryNames = extractListNames(lines.get(2));
		inputStructure.setCountryNames(countryNames);
		inputStructure.setProviders(new TreeMap<String, Provider>());

		int nLines = 3;
		for (long i = 0; i < nProvider; i++) {
			String[] arr = lines.get(nLines++).split(" ");
			Provider provider = new Provider();

			provider.setProviderName(arr[0]);
			int nRegion = Integer.parseInt(arr[1]);
			provider.setnRegion(nRegion);
			inputStructure.getProviders().put(provider.getProviderName(), provider);
			provider.setRegions(new TreeMap<String, Region>());
			for (int j = 0; j < nRegion; j++) {
				Region region = new Region();
				region.setRegionName(lines.get(nLines++));
				String[] packages = lines.get(nLines++).split(" ");
				region.setnPackages(Long.parseLong(packages[0]));
				region.setPackageUnitCost(Double.parseDouble(packages[1]));
				region.setPackages(new TreeMap<String, Integer>());
				int count = 2;
				for (String service : serviceNames) {
					region.getPackages().put(service, Integer.parseInt(packages[count++]));
				}

				region.setLatencies(extractLatencies(lines.get(nLines++), countryNames));
				provider.getRegions().put(region.getRegionName(), region);

			}
		}

		inputStructure.setProjects(new ArrayList<Project>());
		for (long i = 0; i < nProject; i++) {
			String[] arr = lines.get(nLines++).split(" ");
			Project project = new Project();

			project.setPenalty(Integer.parseInt(arr[0]));
			project.setCountry(arr[1]);
			project.setPackages(new TreeMap<String, Integer>());

			int count = 2;
			for (String service : serviceNames) {
				project.getPackages().put(service, Integer.parseInt(arr[count++]));
			}

			inputStructure.getProjects().add(project);
		}

		return inputStructure;

	}

	private static Map<String, Long> extractLatencies(String string, List<String> countryNames) {
		String[] sssss = string.split(" ");
		Map<String, Long> res = new TreeMap<String, Long>();
		int count = 0;
		for (String country : countryNames) {
			res.put(country, Long.parseLong(sssss[count++]));
		}

		return res;
	}

	private static List<String> extractListNames(String string) {
		String[] s = string.split(" ");
		List<String> res = new ArrayList<>();
		for (String a : s) {
			res.add(a);
		}
		return res;
	}

	private static long[] extractNumbers(String line) {
		String[] s = line.split(" ");
		long[] num = new long[s.length];
		int i = 0;
		for (String a : s) {
			num[i++] = Long.parseLong(a);
		}
		return num;
	}

	
}
