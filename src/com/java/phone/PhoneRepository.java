package com.java.phone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PhoneRepository {
	//field
	private static String rootPath = System.getProperty("user.dir");
	private static String phoneDB = rootPath + "\\PhoneDB.txt";

	// constructor
	public PhoneRepository() {
		
	}
	
	//methods
	public void phoneList() {
		Reader reader = null;
		BufferedReader br= null;
		try {
			reader = new FileReader(phoneDB);
			br = new BufferedReader(reader);
			
			String line = null;
			 
			int i = 1;	//번호매길 변수
			while((line = br.readLine()) != null) {
				String[] parse = line.split(",");
				System.out.println(i + ". " + parse[0] + " " 
								+ parse[1] + " "
								+ parse[2]);
				i++;
			}
		} catch(FileNotFoundException e) {
			System.err.println("file does not found");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void phoneListFilter(String find) {		
		Reader reader = null;
		BufferedReader br= null;
		
		try {
			reader = new FileReader(phoneDB);		
			br = new BufferedReader(reader);
			
			String line = null;
			int i = 1;
			while((line = br.readLine()) != null) {
				if(line.contains(find)) {
					String[] parse = line.split(",");
					System.out.println(i + ". " + parse[0] + " " 
									+ parse[1] + " "
									+ parse[2]);
					i++;			
				}
			}
		} catch(FileNotFoundException e) {
			System.err.println("file does not found");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch(Exception e) {
				
			}
		}
	}
	
}

//2021.03.12


