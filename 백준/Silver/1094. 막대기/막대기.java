import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int count = 1;
		int num;
		
		while(x >1) {
			if(x % 2 != 0) {
				count++;
			}
			x = x / 2;
		}
		System.out.println(count);

	}

}
