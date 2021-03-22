package com.java.phone;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBModify {
	//field
	private static String rootPath = System.getProperty("user.dir");
	private static String phoneDB = rootPath + "\\PhoneDB.txt";
	public List<Person> lst = new ArrayList<>();
	//constructor
	public DBModify() {
		
	}
	
	//methods
	public void dbLoad() {
		lst.clear();
		Reader reader = null;
		BufferedReader br =null;
		
		try {
			reader = new FileReader(phoneDB);
			br = new BufferedReader(reader);
			
			String line = null;
			while((line = br.readLine()) != null) {
				String[] parse = line.split(",");
				Person nextPerson = new Person(parse[0],parse[1],parse[2]);
				lst.add(nextPerson);
			}
		} catch(FileNotFoundException e) {
			System.err.println("file does not found");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try{
				br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void dbUpdate() {
		Writer writer = null;
		BufferedWriter bw = null;
		
		Iterator<Person> i = lst.iterator();
		try {
			writer = new FileWriter(phoneDB, false);
			bw = new BufferedWriter(writer);

			while(i.hasNext()) {
				Person nextPerson = i.next();
				String form = nextPerson.name + ',' + 
						nextPerson.mobilePhoneNum +
						',' + nextPerson.PhoneNum;
				bw.write(form);
				bw.newLine();
//				System.out.println(i.next());
			}
			
		} catch(FileNotFoundException e) {
			System.err.println("file does not found");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void dbInsert(String name, String mPhone, String Phone) {	
		dbLoad();
		Person person = new Person(name, mPhone, Phone);
		lst.add(person);
		System.out.print(lst);
		System.out.println("[등록되었습니다.]");
		dbUpdate();
	}
	
	public void dbDelete(int num) {
		dbLoad();
		try {
			lst.remove(num-1);
		} catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		System.out.println(lst);		
		System.out.println("[삭제되었습니다.]");
		dbUpdate();
	}
	
}

//2021.03.12