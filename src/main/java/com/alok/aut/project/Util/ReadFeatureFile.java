package com.alok.aut.project.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadFeatureFile {
	
	static HashMap<String, String> ParseMap = new HashMap<>();
	static HashMap<String, HashMap<String, String>> mainMap = new HashMap<>();
	public static HashMap<String, String> featureFileRead(String file) {
		HashMap<String, String> hm = new HashMap<>();
		String line = "";
		String lineAdd = "";
		String SplitBy = "Scenario Outline:";
		String Key = "";
		String priviousLine = "";
		ArrayList<String[]> arlString = new ArrayList<String[]>();
		ArrayList<String> lineString = new ArrayList<>();
		String[] usersData = {};
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				if (line.contains("Scenario Outline:")||line.contains("Scenario:")) {
					if (Key.equals("")) {
					} else {
						hm.put(Key.trim(), lineAdd);
					}
					Key = line;
					lineAdd = line;
				} else {
					lineAdd = lineAdd + "\n" + line;
				}
			}
			hm.put(Key.trim(), lineAdd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hm;
	}

	public static HashMap<String,ArrayList<String> > getTagsfromScenario(String file) {
		HashMap<String,ArrayList<String> > regrassionMap = new HashMap<>();
		String line = "";
		String lineAdd = "";
		String SplitBy = "Scenario Outline:";
		String Key = "";
		String priviousLine = "";
		ArrayList<String[]> arlString = new ArrayList<String[]>();
		ArrayList<String> lineString = new ArrayList<>();
		String[] usersData = {};
		String[] tagsArray = {};
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				if (line.contains("Scenario Outline:")||line.contains("Scenario:")) {
					tagsArray = priviousLine.trim().split("@");
					ArrayList<String> tags = new ArrayList<>();
					for (int i=1;i<	tagsArray.length;i++) {
						tags.add(tagsArray[i]);
					}
					regrassionMap.put(line.trim(),tags);
				}
				priviousLine = line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return regrassionMap;
	}
	public static HashMap<String,ArrayList<String> > getTagsFromFeature(String file) {
		HashMap<String,ArrayList<String> > regrassionMap = new HashMap<>();
		String line = "";
		String lineAdd = "";
		String SplitBy = "Feature:";
		String Key = "";
		String priviousLine = "";
		ArrayList<String[]> arlString = new ArrayList<String[]>();
		ArrayList<String> lineString = new ArrayList<>();
		String[] usersData = {};
		String[] tagsArray = {};
		File fileObject = new File(file);
		String fileName=fileObject.getName();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				if (line.contains("Feature:")) {
					tagsArray = priviousLine.trim().split("@");
					ArrayList<String> tags = new ArrayList<>();
					for (int i=1;i<	tagsArray.length;i++) {
						tags.add(tagsArray[i]);
					}
					regrassionMap.put(fileName,tags);
				}
				priviousLine = line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return regrassionMap;
	}

}
