import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        // C++
        boolean isC = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '_') isC = true;
        }

        //에러체크
        boolean isError = false;
        // C++ 일때
        if (isC) {
            if (s.charAt(s.length() - 1) == '_' || s.charAt(0) == '_') isError = true;
            for (int i = 1; i < s.length() - 1; i++) {
                if (s.charAt(i) == '_' && s.charAt(i + 1) == '_') {
                    isError = true;
                    break;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
                    if (s.charAt(i) != '_') {
                        isError = true;
                        break;
                    }
                }
            }
        }

        // 자바일때
        if (!isC) {
            for (int i = 0; i < s.length(); i++) {
                isError = true;

                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    isError = false;
                    break;
                }
                if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                    isError = false;
                    break;
                }
            }
            if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') {
                isError = true;
            }
        }

        if (isError) {
            System.out.println("Error!");
            System.exit(0);
        }

        char c = 'a'; // 97
        char cc = 'A'; // 65

        if (isC) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '_') continue;
                if (i != 0 && s.charAt(i - 1) == '_') {
                    sb.append((char) (s.charAt(i) - 32));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        } else if (!isC) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    sb.append("_").append((char) (s.charAt(i) + 32));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }

        System.out.println(sb);
    }

}