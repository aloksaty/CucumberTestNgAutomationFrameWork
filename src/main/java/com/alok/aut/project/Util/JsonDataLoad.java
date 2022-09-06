package com.alok.aut.project.Util;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class JsonDataLoad {
    static List<JSONObject> jsonObjectList = new LinkedList<> ();
    static HashMap<Object,List<JSONObject>> objectMap = new HashMap<> ();
    public static HashMap<Object,List<JSONObject>> LoadData (String file){
        JSONObject customerObj = null;
        try {
            customerObj = (JSONObject) new JSONParser ().parse
                    (new FileReader (file));
        } catch (IOException e) {
            throw new RuntimeException (e);
        } catch (ParseException e) {
            throw new RuntimeException (e);
        }
        for(Object key : customerObj.keySet ()){
            JSONArray customers = (JSONArray) customerObj.get (key) ;
            for (int i = 0; i < customers.size (); i++) {
                jsonObjectList.add ((JSONObject) customers.get (i));
            }
            objectMap.put (key,new LinkedList<> (jsonObjectList));
            jsonObjectList.clear ();
        }
        return objectMap;
    }
}
