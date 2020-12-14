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
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		//파일 읽기
		Reader fr = new FileReader("C:\\javastudy\\미니프로젝트\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		//리스트 준비
		List<Person> pList = new ArrayList<Person>();
		
		System.out.println("********************************************");
		System.out.println("*          전화번호 관리 프로그램          *");
		System.out.println("********************************************");
		
		//List에 데이터 add
		while(true) {
			String str = br.readLine();
			
			if(str == null) {
				break;
			}
			String[] data = str.split(",");
			Person person = new Person(data[0], data[1], data[2]);
			pList.add(person);
		}
		
		br.close();
		
		//System.out.println(pList.toString()); 데이터 등록 테스트
		
		boolean Exit = true; //탈출문
		while(Exit) {
			System.out.println("");
			System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
			System.out.println("--------------------------------------------");
			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();
			
			
			switch (num) {
				case 1:
					System.out.println("<1.리스트>");
					
					for(int i=0; i<pList.size(); i++) {
						System.out.println((i+1) + ".\t" + pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t" + pList.get(i).getCompany());
					}
					break;
	
				case 2: //추가등록한 이름이 보이지않음 ?
					System.out.println("<2.등록>");
					
					System.out.print(">이름: ");
					String name = sc.nextLine();
					sc.nextLine();
					System.out.print(">휴대전화: ");
					String hp = sc.nextLine();
					System.out.print(">회사전화: ");
					String company = sc.nextLine();
					
					Person person = new Person(name, hp, company);
					pList.add(person);
					
					System.out.println("[등록되었습니다.]");
					break; 
	
				case 3:
					System.out.println("<3.삭제>");
					
					System.out.print(">번호: ");
					int no = sc.nextInt();
					pList.remove(no-1); //pList 0,1,2...
					
					System.out.println("[삭제되었습니다.]");
					break;
	
				case 4:
					System.out.println("<4.검색>");
					
					System.out.print(">이름: ");
					String keyW = sc.nextLine();
					
					//이름 검색 추가
					
					break;
	
				case 5:
					System.out.println("");
					System.out.println("********************************************");
					System.out.println("*                감사합니다                *");
					System.out.println("********************************************");
					Exit = false;  // 탈출문필요
					break; 
	
				default:
					System.out.println("[다시 선택해 주세요.]");
				}
			
			
			
		}
			//sc.close();

	}

}
