package corso.spring.mvc.demo.json.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import corso.spring.mvc.demo.json.beans.Contact;
import corso.spring.mvc.demo.json.beans.Group;
import corso.spring.mvc.demo.json.beans.JsonViews;


@RestController
@RequestMapping(value = "/demo/api/v4")
@Slf4j
public class DemoControllerV4 extends AbstractCrmController{

		
	
	@JsonView(JsonViews.GroupDetails.class)
	@CrossOrigin(origins = "http://test.domain", maxAge = 3600)
	@RequestMapping(value = "/contacts/{cid}/groups/{gid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Group> getContactGroupById(@PathVariable long cid,@PathVariable long gid) {
		Group group=super.getContactGroupById(gid);		
		Resource<Group> groupAsResource = new Resource<Group>(group);
		groupAsResource.add(linkTo(methodOn(DemoControllerV4.class).groupDetails(gid)).withSelfRel());
		return groupAsResource;
	}
	
	
	
	@RequestMapping(value = "/contacts/{cid}")
	public Contact getContactDetails(@PathVariable long cid) {
		return super.getContactDetails(cid);
	}
	
	@RequestMapping(value = "/groups/search")
	public List<Group> searchGroups(@RequestParam("name")String name) {
		return super.searchGroups(name);
	}
	
	@RequestMapping(value = "/groups/{gid}")
	public Group groupDetails(@PathVariable long gid) {
		return super.groupDetails(gid);
	}
		
	
}
