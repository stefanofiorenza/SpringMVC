package corso.spring.mvc.demo.json.serializers;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateCustomSerializer extends StdSerializer<Date>{

	private static final String[] months={
		"Jan",
		"Feb",
		"Mar",
		"Apr",
		"May",
		"Jun",
		"Jul",
		"Aug",
		"Sep",
		"Oct",
		"Nov",
		"Dec"
	};
	
	private static final String[] dayPostfix={
		"st",
		"nd",
		"rd",
		"th"
	};
	
	public DateCustomSerializer() {
	   super(Date.class);
	}	
	 
	@SuppressWarnings("deprecation")
	@Override
	public void serialize(Date value, JsonGenerator gen,
			SerializerProvider provider) throws IOException {
		
		
		String dayAsString="";
		
		switch (value.getDate()){
			case 1:
				dayAsString=value.getDate()+"st";
				break;
			case 2:
				dayAsString=value.getDate()+"nd";
				break;
			case 3:
				dayAsString=value.getDate()+"rd";
				break;
			default:
				dayAsString=value.getDate()+"th";
				break;
		}
						
		String monthAsString=months[value.getMonth()+1];
		int year=value.getYear()+1900;
		gen.writeString(dayAsString+" "+monthAsString+" "+year);
	}

}
