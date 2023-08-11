import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        String s = br.readLine();

        System.out.println(":fan::fan::fan:\n" +
                ":fan::" + s + "::fan:\n" +
                ":fan::fan::fan:");
    }
}