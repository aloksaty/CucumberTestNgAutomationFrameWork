package com.alok.aut.project.Util;

import java.io.*;
import java.util.*;

public class ReadTxtFiles {
    LinkedList<String > inputUrl ;
    LinkedList<LinkedList<String>> inputsUrl=new LinkedList<>();
   public LinkedList<String>  readFile(String fileName){
       inputUrl=new LinkedList<>();
       BufferedReader br = null;
       FileReader fr = null;

       try {
           fr = new FileReader(fileName);
           br = new BufferedReader(fr);

           // read line by line
           String line;
           while ((line = br.readLine()) != null) {
               inputUrl.add(line);
           }
       } catch (IOException e) {
           Log.error ("IOException: %s%n"+ e);
       } finally {
           try {
               if (br != null)
                   br.close();

               if (fr != null)
                   fr.close();
           } catch (IOException ex) {
               Log.error ("IOException: %s%n"+ ex);
           }
       }
       return inputUrl;
   }
   public  LinkedList<LinkedList<String>> readInputFiles(String file1,String file2){

        inputsUrl.add(readFile(file1));
        inputsUrl.add(readFile(file2));
       return inputsUrl;
   }

}

