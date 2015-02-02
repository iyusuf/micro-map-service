package com.sortedset.blog.micromapservice.spring;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestGisController {

	private static Logger LOGGER = Logger.getLogger(RestGisController.class);
   
    @RequestMapping(value= "/countries/border", method = RequestMethod.GET)
    public String countries(@RequestParam(value="Name", defaultValue="United States") String name) {
    	LOGGER.info("Request parameter : " + name);
		RestGisResource r =  new RestGisResource();
		try {
			String result = r.getCountryBorder(name);
			if(result.isEmpty()){
				return "{\"servermsg\" : \"Query for country = "+ name + " came out empty \"}" ;
			}else {
				LOGGER.info(result);
				return result;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "{\"servermsg\" : \"Server Error\"}";
		}
    }
}