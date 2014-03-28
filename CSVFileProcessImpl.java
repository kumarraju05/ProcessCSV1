package com.csv.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CSVFileProcessImpl implements CSVFileProcess{

	@Override
	public HashMap<String, String> processCSVFile() {
		HashMap<String, String> highestSharePriceCompany = new HashMap<String, String>();
		try {
			final String FILE_NAME = "masterdata.csv";
			File file = new File(FILE_NAME);
			FileReader fileReader= new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			boolean isheaderRead = false;
			String keyNames[] = null;
			final String delimeter = "|";
			while(true){
				String currentLine = bufferedReader.readLine();
				if(currentLine != null && !isheaderRead){
					isheaderRead = true;
					keyNames = currentLine.split(",");
					if(keyNames != null && keyNames.length > 0){
						for(int i  = 2;i < keyNames.length; i++){
							highestSharePriceCompany.put(keyNames[i], null);
						}
						continue;
					}
					
				}
				if(currentLine != null && isheaderRead){
					String cellData[] = currentLine.split(",");
					for(int i = 0; i < cellData.length; i++){
						
						for(int j=2;j<keyNames.length;j++){
							
							String sharePriceValue = highestSharePriceCompany.get(keyNames[j]);
							String priceValue = null;
							
							if(sharePriceValue != null){
								priceValue = sharePriceValue.substring(sharePriceValue.lastIndexOf(delimeter)+1,sharePriceValue.length());
							}
							if(sharePriceValue == null || (priceValue != null && Integer.parseInt(cellData[j]) >= Integer.parseInt(priceValue))){
								highestSharePriceCompany.put(keyNames[j], keyNames[j]+delimeter+cellData[0]+delimeter+cellData[1]+delimeter+cellData[j]);
							}
							
						}
						
					}
					
				}
				if(currentLine == null)
					break;
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return highestSharePriceCompany;
	}

}
