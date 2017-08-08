package corso.spring.mvc.demo.json.beans;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Getter;
import lombok.Setter;

public class ContactCustomFields {

	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String name;
	
	private Map<String, String> properties= new HashMap<String, String>();
	
	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}
	
	@JsonAnySetter
	public void add(String key, String value) {
		properties.put(key, value);
	}

	@Override
	public String toString() {
		return "ContactCustomFields [id=" + id + ", name=" + name
				+ ", properties=["+ propsAsString() + "]]";
	}
	
	
	private String propsAsString(){
		StringBuffer sb = new StringBuffer();
		if(!properties.isEmpty()){
			properties.forEach((k,value) -> sb.append(k+": "+value+",\n"));
		}		
		sb.delete(sb.length()-2, sb.length()-1);
		return sb.toString();
	}
}
