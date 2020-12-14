package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		Reader fr = new FileReader("C:\\javastudy\\미니프로젝트\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		List<Person> pList = new ArrayList<Person>();
		
		System.out.println("********************************************");
		System.out.println("*          전화번호 관리 프로그램          *");
		System.out.println("********************************************");
		
		while(true) {
			System.out.println("");
			System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
			System.out.println("--------------------------------------------");
			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();
			
			String str = br.readLine();
			if(str == null) {
				break;
			}

			switch(num) {
				case 1:
					System.out.println("<1.리스트>");
					
					//for(int i=0; i<pList.size(); i++) {
						String[] data = str.split(",");
						Person person = new Person(data[0], data[1], data[2]);	
						pList.add(person);
						
						//pList.get(i).showInfo();
						System.out.println(pList.toString());
					//}
					break;
					
				case 2:
					System.out.println("<2.등록>");
					break;
					
				case 3:
					System.out.println("<3.삭제>");
					break;
					
				case 4:
					System.out.println("<4.검색>");
					break;
					
				case 5:
					System.out.println("<5.종료>");
					break;
					
				default:
					System.out.println("없는 메뉴입니다.");
			} 
			

		}	
		
		
			
		
		
		
		br.close();

		
		
		sc.close();

	}

}
