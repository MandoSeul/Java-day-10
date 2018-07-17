package ex02.project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;


public class Parking {
	ArrayList carlist = new ArrayList();
	ArrayList userlist = new ArrayList();
	ArrayList timelist = new ArrayList();
	ArrayList timelist2 = new ArrayList();
	
	Scanner sc = new Scanner(System.in);
	
	public Parking() {
		int num=0;
		do{
		System.out.println();
		System.out.println("원하는 메뉴를 선택하세요");
		System.out.println("1.차량 정보 추가  2. 차량 정보 출력 3. 차량 정보 검색  4. 차량 정보 수정  5.차량 정보 삭제  6. 차량 요금 정산 7.프로그램 종료");
		num=sc.nextInt();
		switch(num){
		case 1: carinput(); break;
		case 2: disp(); break;
		case 3: searchmanual(); break;
		case 4: modi(); break;
		case 5: remove(); break;
		case 6: cash(); break;
		case 7: System.out.println("프로그램을 종료합니다"); System.exit(0); break;
		}
		
	}while(true);
	}// 생성자 end
	
	public void carinput(){
		Date today = new Date();
		SimpleDateFormat sdf4;
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//	System.out.println(sdf4.format(today));
		long now =  System.currentTimeMillis();
		int num=0;
		String str=" ";
		System.out.println("추가할 차량이 몇개입니까? ");
		num = sc.nextInt();
		sc.nextLine();
		//char[] arr = new char[num];
		for(int i =0; i<num; i++){
			System.out.println((i+1)+"번째 차량의 차량종류 차량주인정보 를 입력해주세요 : 출입시간은 현재입니다 ");
			carlist.add(sc.next());
			userlist.add(sc.next());
//			str = sc.next();
//			char ch = str.charAt(0);
			timelist.add(sdf4.format(today));
			timelist2.add(now);
//			if((ch=='n')|(ch=='N')){

				//}
//			else{
//				timelist.add(str);
//	
//				timelist2.add("n");
//			}
		}//for end
	}//video input end
	public void disp(){
		
		System.out.println();
		System.out.println("차량의 목록입니다(알파벳 순)");
		Collections.sort(carlist);
		for(int i=0; i<timelist.size(); i++){
			System.out.print(carlist.get(i)+"\t");
			System.out.print(userlist.get(i)+"\t");
			System.out.println(timelist.get(i));
			
		}

		
	} // disp end
	
	public void searchmanual(){
		char ch =' ';
		String str="";
		int num=0;
		System.out.println();
		System.out.println("차량정보검색을 원하세요? (y/n)");
		str=sc.next();
		ch=str.charAt(0);
		
		if((ch=='y')|(ch=='Y')){
			System.out.println();
			System.out.println("검색할 방법을 선택하세요 : 1.차량 종류  2. 차 주인  3. 출입 시간");
			num = sc.nextInt();
			switch(num){
				case 1 : {
					System.out.println("차량종류가 무엇입니까?");
					str=sc.next();
					search(str,1);
					break;
				}
				case 2 :{
					System.out.println("차 주인의 이름은 무엇입니까?");
					str=sc.next();
					search(str,2);
					break;
				}
				case 3 :{
					System.out.println("출입시간은 언제 입니까? ( 시간만 입력 )");
					str=sc.next();
					search(str,3);
					break;
				}
			} // switch end		
		}//if end
		else if((ch=='n')|(ch=='N'))
			System.out.println("메뉴로 돌아갑니다");
		else System.out.println("error");
		
	
	}
	
	public void search(String name, int num){
		int  temp =0;
		if(num==1) temp = carlist.indexOf(name);
		else if(num==2) temp = userlist.indexOf(name);
		else if(num ==3)temp = timelist.indexOf(name);
		
		if(temp==-1) System.out.println("찾을 수 없습니다. 메뉴로 돌아갑니다");
		else{
		System.out.println();
		System.out.println(name+"에 관한 정보를 찾았습니다.");
		System.out.print(carlist.get(temp)+"\t");
		System.out.print(userlist.get(temp)+"\t");
		System.out.println(timelist.get(temp));
		}
	} // search end
	public void modi(){
		String name=" ",str = " ";
		int  temp =0, num=0;
		System.out.println("수정하고 싶은 차 주인의 이름을 입력하세요");
		sc.nextLine();
		name = sc.nextLine();
		temp = userlist.indexOf(name);
		if(temp==-1) System.out.println("찾을 수 없습니다. 메뉴로 돌아갑니다.");
		else{
		System.out.println("변경하고 싶은 부분은 어디입니까? 1.차종류  2.차 주인 ");
		num=sc.nextInt();
		sc.nextLine();
		switch(num){
		case 1: {
			System.out.println("변경하고 싶은 차종류를 작성하세요");
			str = sc.nextLine();
			carlist.set(temp, str);
			System.out.println("변경되었습니다.");
			break;
		}
		case 2: {
			System.out.println("변경하고 싶은 이름을 작성하세요");
			str = sc.nextLine();
			userlist.set(temp, str);
			System.out.println("변경되었습니다.");
			break;
		}
	
	
		} //switch end
		
		System.out.print(carlist.get(temp)+"\t");
		System.out.print(userlist.get(temp)+"\t");
		System.out.println(timelist.get(temp));
		}
	}// modi end
	
	public void remove(){
		String name=" ",str = " ";
		int temp =0, num=0;
		System.out.println("삭제하고 싶은 차주인의 이름을 입력하세요");
		
		sc.nextLine();
		name = sc.nextLine();
		temp = userlist.indexOf(name);
		if(temp==-1) System.out.println("찾을 수 없습니다. 메뉴로 돌아갑니다.");
		else{
		carlist.remove(temp);
		userlist.remove(temp);
		timelist.remove(temp);
		
		System.out.println("삭제되었습니다. 확인하시겠습니까? (y/n)");
		str = sc.next();
		char ch = str.charAt(0);
		
		if((ch=='y')|(ch=='Y')){
			for(int i=0; i<carlist.size(); i++){
				System.out.print(carlist.get(i)+"\t");
				System.out.print(userlist.get(i)+"\t");
				System.out.println(timelist.get(i));
			}// for end
			
		}// if end
		else if((ch=='n')|(ch=='N'))
			System.out.println("메뉴로 돌아갑니다");
		else System.out.println("error");
		}
		
	} // remove end
	
	public void cash(){
		String name;
		int temp;
		long end = System.currentTimeMillis(); 
		System.out.println("계산하실 차량의 owner는 누구입니까?");
		sc.nextLine();
		name = sc.nextLine();
		temp = userlist.indexOf(name);
		if(temp==-1) System.out.println("찾을 수 없습니다. 메뉴로 돌아갑니다.");
		else{
//			if(timelist2.get(temp)!="n"){
		System.out.println("현재 시각으로 계산된 내역입니다.");
		long cash = (end - (long)timelist2.get(temp));
		System.out.println("총 금액 입니다. " + (cash / 10) + "원 입니다.");
//		}
//			else if(timelist2.get(temp)=="n"){
//				char[] ch = timelist.get(temp)
//			}
	}
} //cash end
}



