package com.alok.aut.RestPageObject;
import com.alok.aut.pojoClass.TestClass;
import com.alok.aut.project.Util.ReadTxtFiles;

import java.io.File;
import java.util.LinkedList;

import static io.restassured.RestAssured.given;

public class GetUserActions {


	public Boolean ifFileExist(String fileName){
		String filePath= System.getProperty("user.dir") +"\\DataFiles\\"+fileName;

		File file= new File(filePath);


		if (file.exists())
			return true;
		else
			return false;
	}

	public void UserRestCallAndCompare(String file1 ,String file2){
		LinkedList<LinkedList<String>> inputsUrlFromFiles=new LinkedList<>();
		TestClass testOne = null;
		TestClass testTwo = null;
		String fileOnePath= System.getProperty("user.dir") +"\\DataFiles\\"+file1;
		String fileTwoPath = System.getProperty("user.dir") +"\\DataFiles\\"+file2;
		ReadTxtFiles readFiles= new ReadTxtFiles();
		inputsUrlFromFiles= readFiles.readInputFiles(fileOnePath,fileTwoPath);
		for(int i =0 ;i<inputsUrlFromFiles.get(0).size();i++){
			testOne =given().get(inputsUrlFromFiles.get(0).get(i)).as(TestClass.class);
			testTwo=given().get(inputsUrlFromFiles.get(1).get(i)).as(TestClass.class);
			if(testOne.toString().compareTo(testTwo.toString())==0){
				System.out.println(inputsUrlFromFiles.get(0).get(i)+" Equals " + inputsUrlFromFiles.get(1).get(i));
			}else{
				System.out.println(inputsUrlFromFiles.get(0).get(i)+" Not Equals " + inputsUrlFromFiles.get(1).get(i));
			}
		}

	}

}
