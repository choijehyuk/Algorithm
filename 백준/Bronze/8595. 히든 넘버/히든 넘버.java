import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String temp = "";
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') temp += s.charAt(i);
            else {
                if (!temp.isEmpty()) {
                    sum += Long.parseLong(temp);
                    temp = "";
                }
            }
        }

        if (!temp.isEmpty()) {
            sum += Long.parseLong(temp);
        }

        System.out.println(sum);
    }
}