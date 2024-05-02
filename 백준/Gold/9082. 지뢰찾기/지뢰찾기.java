import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            char[] bomb = new char[N];

            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i) - '0';
            }

            s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                bomb[i] = s.charAt(i);
            }

            int answer = 0;
            for (int i = 0; i < s.length(); i++) {
                if (bomb[i] == '*') {
                    for (int j = -1; j <= 1; j++) {
                        int num = i + j;

                        if (isRange(num, N)) arr[num]--;

                    }
                    answer++;
                }
            }


            for (int i = 0; i < s.length(); i++) {
                if (bomb[i] == '#') {
                    boolean flag = true;
                    for (int j = -1; j <= 1; j++) {
                        int num = i + j;

                        if (isRange(num, N)) {
                            if (arr[num] == 0) {
                                flag = false;
                                break;
                            }
                        }
                    }

                    if (flag) {
                        for (int j = -1; j <= 1; j++) {
                            int num = i + j;

                            if (isRange(num, N)) arr[num]--;
                        }
                        answer++;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isRange(int num, int N) {
        if (num >= 0 && num < N) return true;
        return false;
    }
}