package com.java.phone;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneView {

	// field


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
		PhoneBookDao pbd = new PhoneBookDaoImpl();
		List<PhoneBookVo> list = pbd.getList();
		Iterator<PhoneBookVo> it = list.iterator();
		
		while(it.hasNext()) {
			PhoneBookVo vo = it.next();
			System.out.println(vo);
			
		}
		
	}
	
	public void registerView(Scanner sc) {
		System.out.println("<2.등록>");
		System.out.print(">이름");
		String name = sc.next();
		System.out.print(">휴대전화:");
		String hp = sc.next();
		System.out.print(">집전화:");
		String tel = sc.next();
		System.out.println();
		PhoneBookVo vo = new PhoneBookVo(name, hp, tel);
		PhoneBookDao pbd = new PhoneBookDaoImpl();
		pbd.insert(vo);
		
	}
	
	public void deleteView(Scanner sc) {
		System.out.println("<3.삭제>");
		System.out.print(">번호:");
		long id = sc.nextInt();
		System.out.println();
		PhoneBookDao pbd = new PhoneBookDaoImpl();
		pbd.delete(id);
		
	}
	
	public void searchView(Scanner sc) {		
		System.out.println("<4.검색>");
		System.out.print(">이름:");
		String keyword = sc.next();
		PhoneBookDao pbd = new PhoneBookDaoImpl();
		List<PhoneBookVo> list = pbd.search(keyword);
		
		Iterator<PhoneBookVo> it = list.iterator();
		while(it.hasNext()) {
			PhoneBookVo vo = it.next();
			System.out.println(vo);
		}
	}
	
	public void quitView() {
		System.out.println("<5.종료>");
		System.out.println("*****************************");
		System.out.println("           감사합니다           ");
		System.out.println("*****************************");
	}

}

//2021.03.12


