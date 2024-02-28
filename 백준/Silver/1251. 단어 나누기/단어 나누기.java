import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String A = s.substring(0, i);
                String B = s.substring(i, j);
                String C = s.substring(j, s.length());

                String sum = "";
                for (int k = 0; k < A.length(); k++) {
                    sum += A.charAt(A.length() - k - 1);
                }

                for (int k = 0; k < B.length(); k++) {
                    sum += B.charAt(B.length() - k - 1);
                }

                for (int k = 0; k < C.length(); k++) {
                    sum += C.charAt(C.length() - k - 1);
                }

                list.add(sum);

            }
        }
        Collections.sort(list);

        System.out.println(list.get(0));
    }
}