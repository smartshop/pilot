package com.smartshop.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Id;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.smartshop.catalog.Address;

public class CatalogGenerator {

	private String addressList;
	private String productCategoryList;
	private String productList;
	private String supplierList;

	private static String addressFileLocation = "/Users/sarat/src2/pilot/src/test/resources/address.csv";
	private static String productFileLocation = "test/resources/product.csv";
	private static String supplierFileLocation = "test/resources/supplier.csv";
	private static String productCategoryFileLocation = "test/resources/supplier.csv";

	private  boolean isId(Annotation[] annotations) {
		
		for(Annotation annotation: annotations){
			if (annotation instanceof Id){
				return true;
			}
		}
		return false;
	}

	public  List loadAddresses(File file, Class<?> clazz) {

		List addressList = null;
		
		try {
			
			FileReader fileReader = new FileReader(file);
			addressList= generateJavaObject(new CSVReader(fileReader),clazz);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return addressList;
	}


	private List generateJavaObject(CSVReader csvReader, Class<?> clazz) {


		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(clazz);
		Field[] fields = clazz.getDeclaredFields();
		List<String> columns = new ArrayList<String>();
		for(Field field:fields){
			if (!Modifier.isStatic(field.getModifiers()) && !isId(field.getAnnotations())) {
				columns.add(field.getName());
				
			}
		}
		strat.setColumnMapping(columns.toArray(new String[columns.size()]));

		CsvToBean csv = new CsvToBean();
		return csv.parse(strat, csvReader);


	}


	private List<String[]> returnFileContents(File fileName) {
		List<String[]> fileContents =  new ArrayList<String[]>();



		try {
			BufferedReader	stream = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName)));
			String line=null;
			while ((line = stream.readLine()) != null) {

				String[] values = line.split(",");
				fileContents.add(values);
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileContents;
	}


}
