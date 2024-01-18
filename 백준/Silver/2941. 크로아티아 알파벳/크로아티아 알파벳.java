import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String s = br.readLine();

        for (int i = 0; i < str.length; i++) {
            if(s.contains(str[i])){
                s = s.replace(str[i], "1");
            }
        }
        
        System.out.println(s.length());

    }
}