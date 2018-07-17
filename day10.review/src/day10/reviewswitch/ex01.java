package day10.reviewswitch;

import java.util.Scanner;

public class ex01 
{ 
	public static void main(String[] args) {
		ex01 re = new ex01();
		Scanner sc= new Scanner(System.in);
		int num=0,total=0;
		num = sc.nextInt();
		re.recursion(num, total);
		re.cal(num);
	}
	
	public void recursion(int j,int total){
		
		for(int i=1; i<j+1; i++){
			total+=(i);		
		}
		System.out.println(total);
		if(j-->1)
			recursion(j,total);
	}

	public void cal(int num){
		int total = 0;
		while(num>0){
			for(int i=1; i<num+1; i++){
				total += i;
			}
			num--;
		}
		System.out.println(total);
	}
}
