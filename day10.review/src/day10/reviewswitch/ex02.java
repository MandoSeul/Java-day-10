package day10.reviewswitch;

public class ex02 {
	public static void main(String[] args) {
		int [] arr = new int [10];
		int total=0;
		for(int i=0; i<10; i++){
			arr[i] = (int)(Math.random()*100+1);
			System.out.print(arr[i]+"\t");
			total+=arr[i];
		}
		System.out.println();
		System.out.println("ÃÑÇÕÀº : " + total);
		
	}
}
