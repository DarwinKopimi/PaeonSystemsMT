package com.aws.codestar.projecttemplates.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Basic Spring MVC controller that handles all GET requests.
 */
@RestController
@RequestMapping("/")
public class HelloWorldController {

    private final String siteName;

    public HelloWorldController(final String siteName) {
        this.siteName = siteName;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("siteName", this.siteName);
        return mav;
    }
    
	 @RequestMapping(value="/hello", method = RequestMethod.GET)
	 public String helloWorld2() {
	 	  return  "Hello World";
	 }
	 
//	 PatientDataMapper dp = new PatientDataMapper();
	 
//		@SuppressWarnings("unchecked")
//		@RequestMapping(value="/users",method = RequestMethod.GET)
//		    public List<Patient> allPatient() {
//		     List<Patient> patients = null;
//			try {
//				patients = dp.mappedPatientInformation();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		     if(patients ==null || patients.isEmpty()) {
//		    	 System.out.println(HttpStatus.BAD_REQUEST + "Hit Endpoint"); ;
//		     }
//			 return (List<Patient>) new ResponseEntity (patients, HttpStatus.OK);
//		    }

}
