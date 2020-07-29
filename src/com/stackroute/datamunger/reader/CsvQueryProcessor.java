package com.stackroute.datamunger.reader;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;

import org.hamcrest.core.IsInstanceOf;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	String fileName;
	BufferedReader br;
	String Headerlines;
	String[] fields;

	// Parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		br = new BufferedReader(new FileReader(file));
	}

	/*
	 * Implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file. Note: Return type of the method will be
	 * Header
	 */

	@Override
	public Header getHeader() throws IOException {
		File file = new File("data/ipl.csv");
		br = new BufferedReader(new FileReader(file));
		Headerlines = br.readLine();
		fields = Headerlines.split(",");
		Header header = new Header(fields);
		return header;

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
		Object obj;
		String dtype = null;
		File file = new File("data/ipl.csv");
		br = new BufferedReader(new FileReader(file));
		Headerlines = br.readLine();
		String[] fields = Headerlines.split(",");
		System.out.println(fields.length);
		String firstLine = br.readLine();

		String[] datas = firstLine.split(",");
		System.out.println(datas.length);
		String[] dataTypes = new String[fields.length];
		if (datas != null) {
			for (int i = 0; i < datas.length; i++) {
				try {
					obj = Integer.parseInt(datas[i]);
					if (obj instanceof Integer)
						dtype = obj.getClass().getName();
					dataTypes[i] = dtype;

				} catch (NumberFormatException ex) {
					try

					{
						obj = Double.parseDouble(datas[i]);
						if (obj instanceof Double) {
							dtype = obj.getClass().getName();
							dataTypes[i] = dtype;
						}

					} catch (Exception ex2) {
						obj = datas[i];
						if (obj instanceof String)
							dtype = obj.getClass().getName();
						dataTypes[i] = dtype;
					}
				}

			}
		}
		br.close();
		if ((fields.length) > (datas.length)) {
			dataTypes[fields.length - 1] = "java.lang.String";
		}
		DataTypeDefinitions types = new DataTypeDefinitions(dataTypes);

		return types;
	}
}
