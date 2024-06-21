import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> paper = new ArrayList<>();
        String s[];
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("\\D");
            for (int j = 0; j < s.length; j++)
                if (!s[j].equals("")) paper.add(new BigInteger(s[j]));
        }

        paper.sort(null);

        int size = paper.size();

        for (int i = 0; i < size; i++) {
            sb.append(paper.get(i) + "\n");
        }

        System.out.println(sb);
    }
}