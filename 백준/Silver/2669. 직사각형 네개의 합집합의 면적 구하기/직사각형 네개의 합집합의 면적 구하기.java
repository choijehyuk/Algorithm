import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		int[][] arr = new int[101][101];
		
		int cnt = 0;
		for(int i = 0 ; i < 4; i ++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for (int j = y1; j < y2 ; j++) {
				for (int k = x1; k < x2; k++) {
					arr[j][k] = 1;
				}
			}
			cnt = 0 ;
			for(int j = 0 ; j < 101; j++) {
				for(int k = 0 ; k < 101; k ++) {
					if(arr[j][k] == 1) {
						cnt++;
					}
				}
			}
			
		}
		System.out.println(cnt);
	}

}
