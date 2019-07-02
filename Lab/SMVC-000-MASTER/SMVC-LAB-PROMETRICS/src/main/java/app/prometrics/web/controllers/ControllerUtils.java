package app.prometrics.web.controllers;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ControllerUtils {

	
	public static Set<String> tokenizeParam(String fields){
		StringTokenizer st = new StringTokenizer(fields, ",");
		Set<String> filterProperties = new HashSet<String>();
	    while (st.hasMoreTokens()) {
	        filterProperties.add(st.nextToken());
	    }
	    return filterProperties;
	}
	
}
	

