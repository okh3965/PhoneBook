package com.java.phone;

import java.util.Scanner;

public class PhoneControl {

	public void mainControl() {
		Scanner sc = new Scanner(System.in);
		PhoneView pv = new PhoneView();

		pv.startView();
		while(true) {
			pv.selectView();
			int menu = sc.nextInt();
			switch(menu){
			case 1:
				pv.listView();
				break;
			case 2:
				pv.registerView(sc);
				break;
			case 3:
				pv.deleteView(sc);
				break;
			case 4:
				pv.searchView(sc);
				break;
			case 5:
				pv.quitView();
				break;
			default:
				System.out.println("[다시입력해주세요]");
			}
			if(menu==5) {
				sc.close();				
				break;
				}
			else;
		}
		
	}

}

//2021.03.12
