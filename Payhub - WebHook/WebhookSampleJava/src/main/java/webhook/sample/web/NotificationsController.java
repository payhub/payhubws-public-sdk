package webhook.sample.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import webhook.sample.domain.Notifications;

@RequestMapping("/notifications/**")
@Controller
@RooWebScaffold(path = "notifications", formBackingObject = Notifications.class)
public class NotificationsController {
	
	@RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
        return "notifications/index";
    }
    
	@RequestMapping(method = RequestMethod.POST,value="notifications/addNotification/", headers = "Accept=application/json")
	public ResponseEntity<String> notifications(@RequestBody String json) {
		   HttpHeaders headers = new HttpHeaders();
	       headers.add("Content-Type", "application/json");	 
	       
	       System.out.println("Received request. The data is: "+json);
	       Notifications n = new Notifications();
	       n.setNotification(json);
	       n.persist();
	       try {
	    		return new ResponseEntity<String>(headers, HttpStatus.ACCEPTED);
	    	} catch (Exception e1) {
	    			 return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
	    	}
	       
	        
	    }
}
