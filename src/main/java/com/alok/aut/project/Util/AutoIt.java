package com.alok.aut.project.Util;

public class AutoIt{

	public static void ExecAutoIt(String[] args) {
		String cmd ="echo";
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			Log.error ("AutoIt sleep Fail");
		}
		try {
			Process result =Runtime.getRuntime().exec(cmd);
			result.waitFor();   
			if (result.exitValue()==1)
			    Log.info ("AutoIt Successfully Downloaded");
			else
			    Log.error ("AutoIt Fail to Download ");
			
		} catch (Exception e) {

		}

	}

}
