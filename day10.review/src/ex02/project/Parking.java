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
		System.out.println("���ϴ� �޴��� �����ϼ���");
		System.out.println("1.���� ���� �߰�  2. ���� ���� ��� 3. ���� ���� �˻�  4. ���� ���� ����  5.���� ���� ����  6. ���� ��� ���� 7.���α׷� ����");
		num=sc.nextInt();
		switch(num){
		case 1: carinput(); break;
		case 2: disp(); break;
		case 3: searchmanual(); break;
		case 4: modi(); break;
		case 5: remove(); break;
		case 6: cash(); break;
		case 7: System.out.println("���α׷��� �����մϴ�"); System.exit(0); break;
		}
		
	}while(true);
	}// ������ end
	
	public void carinput(){
		Date today = new Date();
		SimpleDateFormat sdf4;
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//	System.out.println(sdf4.format(today));
		long now =  System.currentTimeMillis();
		int num=0;
		String str=" ";
		System.out.println("�߰��� ������ ��Դϱ�? ");
		num = sc.nextInt();
		sc.nextLine();
		//char[] arr = new char[num];
		for(int i =0; i<num; i++){
			System.out.println((i+1)+"��° ������ �������� ������������ �� �Է����ּ��� : ���Խð��� �����Դϴ� ");
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
		System.out.println("������ ����Դϴ�(���ĺ� ��)");
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
		System.out.println("���������˻��� ���ϼ���? (y/n)");
		str=sc.next();
		ch=str.charAt(0);
		
		if((ch=='y')|(ch=='Y')){
			System.out.println();
			System.out.println("�˻��� ����� �����ϼ��� : 1.���� ����  2. �� ����  3. ���� �ð�");
			num = sc.nextInt();
			switch(num){
				case 1 : {
					System.out.println("���������� �����Դϱ�?");
					str=sc.next();
					search(str,1);
					break;
				}
				case 2 :{
					System.out.println("�� ������ �̸��� �����Դϱ�?");
					str=sc.next();
					search(str,2);
					break;
				}
				case 3 :{
					System.out.println("���Խð��� ���� �Դϱ�? ( �ð��� �Է� )");
					str=sc.next();
					search(str,3);
					break;
				}
			} // switch end		
		}//if end
		else if((ch=='n')|(ch=='N'))
			System.out.println("�޴��� ���ư��ϴ�");
		else System.out.println("error");
		
	
	}
	
	public void search(String name, int num){
		int  temp =0;
		if(num==1) temp = carlist.indexOf(name);
		else if(num==2) temp = userlist.indexOf(name);
		else if(num ==3)temp = timelist.indexOf(name);
		
		if(temp==-1) System.out.println("ã�� �� �����ϴ�. �޴��� ���ư��ϴ�");
		else{
		System.out.println();
		System.out.println(name+"�� ���� ������ ã�ҽ��ϴ�.");
		System.out.print(carlist.get(temp)+"\t");
		System.out.print(userlist.get(temp)+"\t");
		System.out.println(timelist.get(temp));
		}
	} // search end
	public void modi(){
		String name=" ",str = " ";
		int  temp =0, num=0;
		System.out.println("�����ϰ� ���� �� ������ �̸��� �Է��ϼ���");
		sc.nextLine();
		name = sc.nextLine();
		temp = userlist.indexOf(name);
		if(temp==-1) System.out.println("ã�� �� �����ϴ�. �޴��� ���ư��ϴ�.");
		else{
		System.out.println("�����ϰ� ���� �κ��� ����Դϱ�? 1.������  2.�� ���� ");
		num=sc.nextInt();
		sc.nextLine();
		switch(num){
		case 1: {
			System.out.println("�����ϰ� ���� �������� �ۼ��ϼ���");
			str = sc.nextLine();
			carlist.set(temp, str);
			System.out.println("����Ǿ����ϴ�.");
			break;
		}
		case 2: {
			System.out.println("�����ϰ� ���� �̸��� �ۼ��ϼ���");
			str = sc.nextLine();
			userlist.set(temp, str);
			System.out.println("����Ǿ����ϴ�.");
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
		System.out.println("�����ϰ� ���� �������� �̸��� �Է��ϼ���");
		
		sc.nextLine();
		name = sc.nextLine();
		temp = userlist.indexOf(name);
		if(temp==-1) System.out.println("ã�� �� �����ϴ�. �޴��� ���ư��ϴ�.");
		else{
		carlist.remove(temp);
		userlist.remove(temp);
		timelist.remove(temp);
		
		System.out.println("�����Ǿ����ϴ�. Ȯ���Ͻðڽ��ϱ�? (y/n)");
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
			System.out.println("�޴��� ���ư��ϴ�");
		else System.out.println("error");
		}
		
	} // remove end
	
	public void cash(){
		String name;
		int temp;
		long end = System.currentTimeMillis(); 
		System.out.println("����Ͻ� ������ owner�� �����Դϱ�?");
		sc.nextLine();
		name = sc.nextLine();
		temp = userlist.indexOf(name);
		if(temp==-1) System.out.println("ã�� �� �����ϴ�. �޴��� ���ư��ϴ�.");
		else{
//			if(timelist2.get(temp)!="n"){
		System.out.println("���� �ð����� ���� �����Դϴ�.");
		long cash = (end - (long)timelist2.get(temp));
		System.out.println("�� �ݾ� �Դϴ�. " + (cash / 10) + "�� �Դϴ�.");
//		}
//			else if(timelist2.get(temp)=="n"){
//				char[] ch = timelist.get(temp)
//			}
	}
} //cash end
}



