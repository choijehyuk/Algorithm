import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int answer = 0;
		int[][] stu = new int[2][6];

		for (int i = 0; i < n; i++) {
			int gen = sc.nextInt();
			int grade = sc.nextInt();

			stu[gen][grade-1]++;
			//학년 -1
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if (stu[i][j] % 2 != 0) {
					answer += stu[i][j] / 2 + 1;
				} else {
					answer += stu[i][j] / 2;
				}
			}
		}
		System.out.println(answer);

	}

}
