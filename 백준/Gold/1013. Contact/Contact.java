import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            boolean check = true;

            while (s.length() > 0) {
                if (s.startsWith("01")) {
                    s = s.substring(2);

                } else if (s.startsWith("100")) {
                    s = s.substring(3);

                    while (s.length() > 0 && s.charAt(0) == '0') {
                        s = s.substring(1);
                    }
                    //System.out.println("0까지 제거 " + s);
                    if (s.length() == 0) {
                        sb.append("NO\n");
                        check = false;
                        break;
                    } else {
                        s = s.substring(1);
                    }

                    while (s.length() > 0 && s.charAt(0) == '1') {
                        if (s.length() >= 3) {
                            if (s.charAt(1) == '0' && s.charAt(2) == '0') {
                                break;
                            }
                        }
                        s = s.substring(1);
                    }

                    //System.out.println("1도 제거 " + s);
                }

                else {
                    sb.append("NO\n");
                    check = false;
                    break;
                }


            }

            if (s.length() == 0 && check) {
                sb.append("YES\n");
            }

        }

        System.out.println(sb);

    }
}