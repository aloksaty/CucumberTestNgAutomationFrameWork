package com.alok.aut.project.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVManager {
	public static ArrayList<String[]> csvRead(String csv) {

		String csvFile = System.getProperty("user.dir") +csv;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String[]> arlString = new ArrayList<String[]>();
		String[] usersData = {};
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				// use comma as separator
				usersData = line.split(cvsSplitBy);
				arlString.add(usersData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arlString;
	}
	public static void CSVWrite(String fileName ,String str) {
		FileWriter writer = null;
		String csvFile = fileName;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String[]> arlString = new ArrayList<String[]>();
		String[] usersData = {};
		StringBuffer sb = new StringBuffer();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			while ((line = br.readLine()) != null) {
				// use comma as separator
				usersData = line.split(cvsSplitBy);
				arlString.add(usersData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writer = new FileWriter(fileName);
			writer.append(str);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
