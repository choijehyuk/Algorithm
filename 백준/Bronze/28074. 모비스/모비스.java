import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        String s = br.readLine();

        int M = 0;
        int O = 0;
        int B = 0;
        int I = 0;
        int S = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M')
                M++;
            else if (s.charAt(i) == 'O')
                O++;
            else if (s.charAt(i) == 'B')
                B++;
            else if (s.charAt(i) == 'I')
                I++;
            else if (s.charAt(i) == 'S')
                S++;
        }

        if (M != 0 && O != 0 && B != 0 && I != 0 && S != 0)
            System.out.println("YES");
        else System.out.println("NO");
    }
}