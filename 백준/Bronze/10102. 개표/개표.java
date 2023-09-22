import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int V = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int A = 0;
        int B = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A'){
                A++;
            }
            else{
                B++;
            }
        }

        if(A > B){
            System.out.println("A");
        }
        else if(A < B){
            System.out.println("B");
        }
        else{
            System.out.println("Tie");
        }

    }

}