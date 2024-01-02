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

        String input = br.readLine();
        boolean str = Pattern.matches("(100+1+|01)+", input);

        if (str) System.out.println("SUBMARINE");
        else System.out.println("NOISE");
    }
}
