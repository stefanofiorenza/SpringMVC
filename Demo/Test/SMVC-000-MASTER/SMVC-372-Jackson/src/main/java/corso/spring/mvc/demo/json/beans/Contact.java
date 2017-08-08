package corso.spring.mvc.demo.json.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import corso.spring.mvc.demo.json.config.Consts;
import corso.spring.mvc.demo.json.serializers.DateCustomSerializer;



@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "type")
@JsonSubTypes({ 
  @Type(value = BusinessContact.class, name = Consts.ENUM_CTC_BUSINESS), 
  @Type(value = TechnicalContact.class, name = Consts.ENUM_CTC_TECHNICAL) 
})
//@JsonFilter("FilterNameInBean")
//@JsonInclude(Include.NON_NULL)  
//@JsonIgnoreProperties({"name","telephone","joinDate"})
public abstract class Contact {

	protected Contact(String type){
		setType(ContactTypeEnum.fromText(type));
	}
	
	@JsonView(JsonViews.EntityData.class)
	@Getter
	@Setter
	private Long id;
	
	@JsonView(JsonViews.EntityData.class)
	@Getter
	@Setter
	//@JsonProperty("NOME")
	private String name;
	
	//@JsonView(JsonViews.EntityData.class)
	@Getter
	@Setter
	@JsonIgnore
	private String telephone;
	
	@JsonView(JsonViews.ContactDetails.class)
	@Getter
	//private List<Group> groups= new ArrayList<Group>();
	private Set<Group> groups= new HashSet<Group>();
	

	@JsonView(JsonViews.EntityData.class)
	@Getter
	@Setter
	private Customer customer;
	
	@Getter
	@Setter
	@JsonView(JsonViews.EntityData.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	//@JsonSerialize(using = DateCustomSerializer.class) 
	private Date joinDate;
	
	@JsonView(JsonViews.EntityData.class)
	@Getter
	@Setter
	private String pictureAsUrl;
	
	@JsonView(JsonViews.EntityData.class)
	@Getter
	@Setter
	@JsonIgnore
	private byte[] pictureAsBytes;
	
	@JsonView(JsonViews.EntityData.class)
	@Getter
	@Setter
	private ContactTypeEnum type=ContactTypeEnum.USER;

	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", telephone="
				+ telephone + ", groups=" + groups + ", customer=" + customer
				+ ", joinDate=" + joinDate + ", pictureAsUrl=" + pictureAsUrl
				+ ", pictureAsBytes=" + Arrays.toString(pictureAsBytes)
				+ ", type=" + type + "]";
	} //default value
	
	
	

}
