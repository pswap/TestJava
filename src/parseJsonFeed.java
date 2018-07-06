import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Info {
	String place;
	String date;
	double magd;
	long magl;
	
	Info(String place, String date, double magd) {
		this.place = place;
		this.date = date;
		this.magd = magd;
	}
	Info(String place, String date, long magl) {
		this.place = place;
		this.date = date;
		this.magl = magl;
	}
	
	public String toString() {
		String[] tmp = date.split(" ");
		String out = tmp[0]+"T"+tmp[1]+"|"+place+"|"+"Magnitude: " + ((Double)magd != null ? magd : magl);
		return out;
	}
}

class sortDateComp implements Comparator<Info> {

	public int compare(Info o1, Info o2) {
		return o1.date.compareTo(o2.date);
	}	
}

public class parseJsonFeed {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Info> list = new ArrayList<>();
        Object obj = null;
		try {
			obj = new JSONParser().parse(new FileReader("/Users/siva/git/TestJava/src/all_week.geojson"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
         
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
         
        String type = (String) jo.get("type");
        JSONArray features = (JSONArray) jo.get("features");
        Iterator itr2 = features.iterator();
        while (itr2.hasNext()) 
        {
        		Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();
        		while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                if(pair.getKey().equals("properties")) {
                		Map propMap = ((Map)pair.getValue());
                		String place = (String) propMap.get("place");
                		// we are interested only in CA location
                		if(place.contains("CA")) {
                    		//System.out.println(propMap.get("place") + ","+propMap.get("time")+","+propMap.get("mag"));
                    		
                    		long time = (long) propMap.get("time");
                    		Timestamp timestamp = new Timestamp(time);
                    		Date date = new Date(timestamp.getTime());   
                    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss+00:00");
                    		
                    		Info info = null;
                    		if(propMap.get("mag") != null) {
	                    		try {
	                    			double mag = (double) propMap.get("mag");
	                        		 info = new Info(place, sdf.format(date), mag);
	                    		} catch (Exception e) {
	                    			long magl = (long)propMap.get("mag");
	                        		 info = new Info(place, sdf.format(date), magl);
	                    		}
	                    		
	                    		list.add(info);
                    		}
                    	}
                }
             }
        }
        // sort based on the timestamp
        Collections.sort(list, new sortDateComp());
        
        for(int i=0;i<list.size();i++) {
        		System.out.println(list.get(i).toString());
        }                 
	}
}
