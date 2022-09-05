package com.alok.aut.project.Util;

import java.io.File;

public class CleanDir {

	public static void  cleanDirectory(String dirName) {
		String exportDir = System.getProperty("user.dir") + "\\"+dirName;
		File directory = new File(exportDir);

		// Get all files in directory

		File[] files = directory.listFiles();

		for (File file : files) {
			// Delete each file
			if (!file.delete()) {
				// Failed to delete file
				Log.error ("Failed to delete " + file);
			}
		}
	}
}
