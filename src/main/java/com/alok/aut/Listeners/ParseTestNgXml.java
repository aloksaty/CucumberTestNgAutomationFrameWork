package com.alok.aut.Listeners;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

public class ParseTestNgXml {
	
	@BeforeSuite
	public static String getSuiteName(ITestContext context){
	    return context.getCurrentXmlTest().getSuite().getName();
	}
}
