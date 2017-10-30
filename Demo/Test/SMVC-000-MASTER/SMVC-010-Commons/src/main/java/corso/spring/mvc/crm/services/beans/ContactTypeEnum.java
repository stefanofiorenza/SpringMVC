package corso.spring.mvc.crm.services.beans;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ContactTypeEnum {

	USER(Consts.ENUM_CTC_USER),
	TECHNICAL(Consts.ENUM_CTC_TECHNICAL), 
	BUSINESS(Consts.ENUM_CTC_BUSINESS);

	  private String text;

	  private ContactTypeEnum(String text) {
	    this.text = text;
	  }

	  @JsonValue
	  public String getText() {
	    return text;
	  }

	  public void setText(String text) {
	    this.text = text;
	  }

	  public static ContactTypeEnum fromText(String text) {
		  ContactTypeEnum resultIfAny = string2Enums.get(text);
	    if (resultIfAny == null) {	     
	      throw new IllegalStateException(text +" is not a valid ContactType");
	    }
	    return resultIfAny;
	  }

	  private static Map<String, ContactTypeEnum> string2Enums = initMap();

	  private static Map<String, ContactTypeEnum> initMap() {
	    Map<String, ContactTypeEnum> map = new HashMap<String, ContactTypeEnum>();
	    map.put(USER.getText(), USER);
	    map.put(TECHNICAL.getText(), TECHNICAL);
	    map.put(BUSINESS.getText(), BUSINESS);	  
	    return map;
	  }
}
