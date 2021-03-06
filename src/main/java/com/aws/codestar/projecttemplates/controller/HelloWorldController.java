package com.aws.codestar.projecttemplates.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ps.webservice.data.Patient;
import com.ps.webservice.data.mapper.PatientDataMapper;

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
	 
	 PatientDataMapper dp = new PatientDataMapper();
	 
		@SuppressWarnings("unchecked")
		@ResponseBody
		@RequestMapping(value="/users",method = RequestMethod.GET)
		    public List<Patient> allPatient() {
		     List<Patient> patients = null;
			try {
				patients = dp.mappedPatientInformation();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		     if(patients ==null || patients.isEmpty()) {
		    	 System.out.println(HttpStatus.BAD_REQUEST + "Hit Endpoint"); ;
		     }
			 return patients;
		    }

}
