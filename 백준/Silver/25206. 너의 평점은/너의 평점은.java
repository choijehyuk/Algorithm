import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        double sum = 0;
        double creditSum = 0;
        double answer = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            double credit = Double.parseDouble(st.nextToken());
            creditSum += credit;
            String grade = st.nextToken();

            if (grade.equals("P")) {
                creditSum -= credit;
                continue;
            }
            double gradeScore = 0;
            if (grade.equals("A+")) {
                gradeScore = 4.5;
            } else if (grade.equals("A0")) {
                gradeScore = 4.0;
            } else if (grade.equals("B+")) {
                gradeScore = 3.5;
            } else if (grade.equals("B0")) {
                gradeScore = 3.0;
            } else if (grade.equals("C+")) {
                gradeScore = 2.5;
            } else if (grade.equals("C0")) {
                gradeScore = 2.0;
            } else if (grade.equals("D+")) {
                gradeScore = 1.5;
            } else if (grade.equals("D0")) {
                gradeScore = 1.0;
            } else if (grade.equals("F")) {
                gradeScore = 0;
            }
            sum += credit * gradeScore;
        }

        answer = sum / creditSum;
        System.out.println(answer);
    }

}