package com.java.phone;

import java.util.Scanner;

public class PhoneView {

	// field
	PhoneRepository pr = new PhoneRepository();
	DBModify dm =new DBModify();
	
	// constructor
	public PhoneView(){}
	
	//methods
	public void startView() {
		System.out.println("*******************************");
		System.out.println("        전화번호 관리 프로그램        ");
		System.out.println("*******************************");
	}
	
	public void selectView() {
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("-------------------------------");
		System.out.print(">메뉴번호:");
	}
	
	public void listView() {
		System.out.println("<1.리스트>");
		pr.phoneList();
	}
	
	public void registerView(Scanner sc) {
		System.out.println("<2.등록>");
		System.out.print(">이름");
		String name = sc.next();
		System.out.print(">휴대전화:");
		String mPhoneNum = sc.next();
		System.out.print(">집전화:");
		String PhoneNum = sc.next();
		System.out.println();
		dm.dbInsert(name, mPhoneNum, PhoneNum);
	}
	
	public void deleteView(Scanner sc) {
		System.out.println("<3.삭제>");
		System.out.print(">번호:");
		int num = sc.nextInt();
		System.out.println();
		dm.dbDelete(num);
	}
	
	public void searchView(Scanner sc) {				
		System.out.println("<4.검색>");
		System.out.print(">이름:");
		String find = sc.next();
		pr.phoneListFilter(find);
	}
	
	public void quitView() {
		System.out.println("<5.종료>");
		System.out.println("*****************************");
		System.out.println("           감사합니다           ");
		System.out.println("*****************************");
	}

}

//2021.03.12


