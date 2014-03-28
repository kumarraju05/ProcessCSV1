package com.csv.model;

public class CSVFileProcessFactory {
	public static CSVFileProcess processCSVFile(){
		CSVFileProcess csvFileProcess = new CSVFileProcessImpl();
		return csvFileProcess;
	}
}
