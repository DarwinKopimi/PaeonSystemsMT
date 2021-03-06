package com.ps.webservice.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import com.ps.webservice.data.DataRetrievalPerRequest;
import com.ps.webservice.data.Patient;

public class PatientDataMapper {

	//@Autowired
	//DataRetrievalPerRequest data = new DataRetrievalPerRequest();
	String data = null;
	public List<Patient> mappedPatientInformation() throws SQLException {
		ResultSet retrievedDataFromDatabase;
		List<Patient> listOfPatients = new ArrayList<>();
		if (data != null) {
			retrievedDataFromDatabase = null;
			while (retrievedDataFromDatabase.next()) {
				Patient patient = new Patient();
				String pid = retrievedDataFromDatabase.getString("PID");
				String firstName = retrievedDataFromDatabase.getString("FIRST_NAME");
				String lastName = retrievedDataFromDatabase.getString("LAST_NAME");
				int age = retrievedDataFromDatabase.getInt("AGE");
				createMappedObject(pid, firstName, lastName, age, patient);
				listOfPatients.add(patient);
				
			}
			
		}
		if (listOfPatients.isEmpty()) {
			testClient(listOfPatients);
		}
		return listOfPatients;
	}

	public Patient retrievePatientRecord(String requestInfo, String requestUserId) throws SQLException {
		ResultSet retrievedDataFromDatabase;
		Patient patient = new Patient();
		retrievedDataFromDatabase = null;
		while (retrievedDataFromDatabase.next()) {
			String pid = retrievedDataFromDatabase.getString("PID");
			String firstName = retrievedDataFromDatabase.getString("FIRST_NAME");
			String lastName = retrievedDataFromDatabase.getString("LAST_NAME");
			int age = retrievedDataFromDatabase.getInt("AGE");

			createMappedObject(pid, firstName, lastName, age, patient);
		}

		return patient;
	}

	private void testClient(List<Patient> listOfPatients) {
		Patient patient = new Patient();
		patient.setAge(45);
		patient.setFirstName("Bob");
		patient.setLastName("Morgy");
		listOfPatients.add(patient);
	}

	private void createMappedObject(String pid, String firstName, String lastName, int age, Patient patient) {
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setAge(age);
	}

}
