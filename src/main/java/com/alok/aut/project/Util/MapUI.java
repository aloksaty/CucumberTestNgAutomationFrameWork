package com.alok.aut.project.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class MapUI {

	public static Properties prob;
	public static String BestExec = null;
	public static String BestExecFile = null;

    //--------------- mail configuration-------------------------------
    public static String smtpHost = null;
    public static String mailFrom = null;
    public static String smtp_enable = null;
    public static String smtp_port = null;
    public static String FromMailId = null;
    public static String ToMailId = null;
    public static String SubjectLine = null;

    //--------------JDBC---------------------
    public static String JDBCIP;
    public static String JDBCUserName;
    public static String JDBCPasword;

    public static void loadUIMapProp (String fileName) {
        String prop_path = System.getProperty ("src/main/resources/UImap.properties") +fileName;
        System.out.println (prop_path);
        //String prop_path = fileName;
        File file = new File (prop_path);
        FileInputStream fin = null;
        try {
            fin = new FileInputStream (file);
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
        prob = new Properties ();
        try {
            prob.load (fin);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
    public static void readProperties () {
        //----------Mail Configurations---------
        FromMailId = prob.getProperty ("FromMailId");
        ToMailId = prob.getProperty ("ToMailId");
        SubjectLine = prob.getProperty ("SubjectLine");
    }
    public static void userInfoLoad () throws Exception {
        BestExecFile = System.getProperty ("user.dir") + "\\DataFile\\" + BestExec;
        ExcelUtil.setExcelFile (BestExecFile, "BestExec");
    }

}
