import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int X = Integer.parseInt(br.readLine());
        int n = 0;
        int top = 1;
        int bottom = 1;
        int cnt = 0;
        if (X == 1) {
            System.out.println("1/1");
        } else {
            while (cnt < X) {
                n++;
                cnt = n * (n + 1) / 2;
            }
            int num = X - (n - 1) * n / 2;
            if (n % 2 == 0) {
                top = num;
                bottom = n - num + 1;
            } else {
                top = n - num + 1;
                bottom = num;
            }
            System.out.println(top + "/" + bottom);
        }
    }

}