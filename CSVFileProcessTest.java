package com.csv.model;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class CSVFileProcessTest {
	
	/* possible values for below final variables
	 * 
	 * keep left hand side as a COMPANY_NAME and right hand side as a COMPANY_DETAILS
	 * 
	 * Company C=Company C|1990|Feb|20, Company D=Company D|2013|Sep|500, Company B=Company B|1990|Feb|15, Company A=Company A|2013|Sep|50
	 * 
	 */
	private static final String COMPANY_NAME = "Company A";
	private static final String COMPANY_DETAILS = "Company A|2013|Sep|50";
	@Test
	public void testHighestSharePriceCompanyDetails(){
		CSVFileProcess csvFileProcess = CSVFileProcessFactory.processCSVFile();
		HashMap<String, String> highestSharePriceMap = csvFileProcess.processCSVFile();
		assertEquals("The highest shareprice company year and month detials",highestSharePriceMap.get(COMPANY_NAME), COMPANY_DETAILS);
	}
}
