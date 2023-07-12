import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine();
            int[] alpha = new int[26];

            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    alpha[s.charAt(i) - 'a']++;
                }
            }

            int max = 0;
            for (int i = 0; i < alpha.length; i++) {
                max = Math.max(max , alpha[i]);
            }

            int check = 0;
            int answer = 0;

            for (int i = 0; i < alpha.length; i++) {
                if(max == alpha[i]){
                    check++;
                    answer = i;
                }
            }

            if(check == 1){
                System.out.println((char)(answer +'a'));
            }
            else{
                System.out.println("?");
            }

        }

    }


}
