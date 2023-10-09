package np.edu.nast.bloodlink.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	 @RequestMapping("/test")
	    public String test() {
	        this.logger.warn("This is working message");
	        return "Testing message";
	    }
}
