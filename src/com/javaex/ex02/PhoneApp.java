package com.javaex.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	private static List<Person> pList;
	
	public static void main(String[] args) throws IOException{
		/*
		 메소드로 기능 분리
		 - 시작시 파일을 읽어 리스트에 추가하기: 가독성
		 - 리스트 화면에 출력 가능 메소드로 분리 (1.리스트 4.검색) static으로 while-switch문 밑에 배치
		 - 리스트의 모든 값을 파일에 저장한다. (2.등록 3.삭제) static으로 while-switch문 밑에 배치
		 */
		
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		//파일 읽어 리스트에 담기
		loadList();
		
		//시작화면
		System.out.println("********************************************");
		System.out.println("*          전화번호 관리 프로그램          *");
		System.out.println("********************************************");
		
		//while-switch
		boolean run = true;
		while(run) {
			//메뉴
			System.out.println("");
			System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
			System.out.println("--------------------------------------------");
			System.out.print(">메뉴번호: ");
			
			int menu = sc.nextInt();
			sc.nextLine(); //입력오류 방지
			
			switch(menu) {
				//1.리스트
				case 1:
					System.out.println("<1.리스트>");
			
					showList();
					break;
			
					//2.등록
				case 2:
					System.out.println("<2.등록>");
					
					System.out.print(">이름: ");
					String name = sc.nextLine();
					
					System.out.print(">휴대전화: ");
					String hp = sc.nextLine();
					
					System.out.print(">회사전화: ");
					String company = sc.nextLine();
					
					Person person = new Person();
					person.setName(name);
					person.setHp(hp);
					person.setCompany(company);
					
					//리스트에 추가
					pList.add(person);
					
					//파일에 저장
					saveList();
					System.out.println("[등록되었습니다.]");
					break;
			
					//3.삭제
				case 3:
					System.out.println("<3.삭제>");
					
					System.out.print(">번호 : ");
					int num = sc.nextInt();
					
					//리스트에서 삭제
					pList.remove(num-1);
					
					//파일에 저장
					saveList();
					System.out.println("[삭제되었습니다.]");
					break;
			
					//4.검색
				case 4:
					System.out.println("<4.검색>");
					
					System.out.print(">이름: ");
					String key = sc.nextLine();
					
					showList(key);
					break;
			
					//5.종료
				case 5:
					run = false;
					break;
			
					//예외
				default:
					System.out.println("[다시 입력해 주세요.]");
					break;
			
			}
			
		}
		
		//종료화면
		System.out.println("");
		System.out.println("********************************************");
		System.out.println("*                감사합니다                *");
		System.out.println("********************************************");
			
		sc.close();
	}	
	
	
	// 파일을 읽어 리스트에 담기
	public static void loadList() throws IOException{
		Reader fr = new FileReader("C:\\javastudy\\미니프로젝트\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		pList = new ArrayList<Person>();
		
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			
			String[] data = line.split(",");
			String name = data[0];
			String hp = data[1];
			String company = data[2];
			
			Person pData = new Person(name, hp, company);
			
			pList.add(pData);
					
		}
		
		br.close();
		
	}
		
	// 모든 리스트 출력 *아래 메소드와 이름 같음(메소드 오버로딩)
	public static void showList() {
		showList("");
	}
		
	// 이름으로 검색된 리스트의 정보를 출력한다. * 위 메소드와 이름 같음(메소드 오버로딩)
	public static void showList(String key) {
		for(int i=0; i<pList.size(); i++) { //pList static으로 main 위에 선언
			String serch = pList.get(i).getName();
			if(serch.contains(key)) { // contains() 함수는 대상 문자열에 특정 문자열이 포함되어 있는지 확인하는 함수이다. 대소문자 구분
				System.out.print(i + 1 + ".\t");
				System.out.print(pList.get(i).getName() + "\t");
				System.out.print(pList.get(i).getHp() + "\t");
				System.out.println(pList.get(i).getCompany());
			}
		}
	}
		
	// 리스트를 파라미터로 받아 파일에 저장한다.
	public static void saveList() throws IOException{
		Writer fw = new FileWriter("C:\\javastudy\\미니프로젝트\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(int i=0; i<pList.size(); i++) {
			String str = pList.get(i).getName() + ","
					   + pList.get(i).getHp() + ","
					   + pList.get(i).getCompany();
			bw.write(str);
			bw.newLine();
		}
		
		/*
		for(Person p : pList) {
			String str = p.getName() + "," + p.getHp() + "," + p.getCompany();
			bw.write(str);
			bw.newLine();
		}
		*/
		
		bw.flush();
		bw.close();
	}

	

}
