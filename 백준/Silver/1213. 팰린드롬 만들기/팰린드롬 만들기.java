import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        String s = br.readLine();
        int[] eng = new int[26];

        for (int i = 0; i < s.length(); i++) {
            eng[s.charAt(i) - 'A']++;
        }

        int odd = 0;
        int location = 0;
        for (int i = 0; i < eng.length; i++) {
            if(eng[i] % 2 == 1){
                odd++;
                location = i;
            }
        }

        if(odd >= 2){
            System.out.println("I'm Sorry Hansoo");
            System.exit(0);
        }
        
        for (int i = 0; i < eng.length; i++) {
            for (int j = 0; j < eng[i]/2; j++) {
                sb.append((char)(i + 'A'));
            }
        }
        String string = sb.toString();

        if(odd == 1){
            sb.append((char)(location + 'A'));
        }

        for (int i = 0; i < string.length(); i++) {
            sb.append(string.charAt(string.length()-1-i));
        }

        System.out.println(sb);



    }

}