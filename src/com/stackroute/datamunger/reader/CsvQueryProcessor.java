package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	// Parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {

		File f1 = new File(fileName);
		FileReader reader = new FileReader(f1);
		BufferedReader breader = new BufferedReader(reader);
		System.out.println(fileName);
	}

	/*
	 * Implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file. Note: Return type of the method will be
	 * Header
	 */

	@Override
	public Header getHeader() throws IOException {
		
		// declaring string
		String header = null;
		String[] splittedarray = null;
		
		// file location
		File f2 = new File("/home/ubuntu/Desktop/java/ECLIPSE PROGRAMS/DataMungerStep3_Boilerplate/data/ipl.csv");
		FileReader reader2 = new FileReader(f2);
		BufferedReader breader2 = new BufferedReader(reader2);
		
		// read the first line
		header = breader2.readLine();
		
		breader2.close();
		reader2.close();
		
        // split read line
		splittedarray = header.split(",");

		// populate the header object with the String array containing the header names
        Header obj1 = new Header(splittedarray);
		return obj1;
	}

	/**
	 * getDataRow() method will be used in the upcoming assignments
	 */

	@Override
	public void getDataRow() {

	}

	/*
	 * Implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. If a
	 * specific field value can be converted to Integer, the data type of that field
	 * will contain "java.lang.Integer", otherwise if it can be converted to Double,
	 * then the data type of that field will contain "java.lang.Double", otherwise,
	 * the field is to be treated as String. Note: Return Type of the method will be
	 * DataTypeDefinitions
	 */

	@Override
	public DataTypeDefinitions getColumnType() throws IOException {

		return null;
	}
}
