package org.modelrefactoring.guery.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.AfterClass;

public class AbstractPersistCSVFileTest {

	public static final String CSV_FILE_OPTION_PREFIX	= "csv:file:prefix:";
	public static final String CSV_FILE_OPTION_HEADER	= "csv:file:header:";

	private static CSVPrinter csvPrinter;
	private static File csvFile;
	private static String csvFilePrefix;
	private static String[] csvFileHeader;
	
	public static CSVPrinter getCSVPrinter() {
		return csvPrinter;
	}

	public static File getCSVFile() {
		return csvFile;
	}

	public static String getCSVFilePrefix() {
		return csvFilePrefix;
	}

	public static String[] getCSVFileHeader() {
		return csvFileHeader;
	}

	public static void initCSVPrinter(String[] header, String csvFilePrefix) {
		String[] trimmedHeader = new String[header.length];
		for (int i = 0; i < header.length; i++) {
			String columnName = header[i];
			trimmedHeader[i] = columnName.trim();
		}
		CSVFormat csvFormat = CSVFormat.EXCEL.withHeader(trimmedHeader).withDelimiter(';');
		String statisticsFilePath = csvFilePrefix + System.currentTimeMillis() + ".csv";
		csvFile = new File(statisticsFilePath);
		if(csvFile.exists()){
			csvFile.delete();
		}
		FileWriter writer;
		csvPrinter = null;
		try {
			writer = new FileWriter(csvFile);
			csvPrinter = csvFormat.print(writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void finishTest(){
		if(csvPrinter != null){
			try {
				csvPrinter.close();
				System.out.println("statistics saved at");
				System.out.println("[[ATTACHMENT|" + csvFile.getAbsoluteFile().getPath() + "]]");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String doubleToString(double value){
		String valueString = String.valueOf(value);
		valueString = valueString.replace(".", ",");
		return valueString;
	}
}
