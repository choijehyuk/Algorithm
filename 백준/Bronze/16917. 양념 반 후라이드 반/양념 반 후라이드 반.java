import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        long answer = 0;
        int min = Math.min(X, Y);

        if (A + B > C * 2) {
            answer = 2 * C * min;
        } else {
            answer = (A + B) * min;
        }

        if (min == X) {
            min = Y - min;
            answer += Math.min(min * B, 2 * C * min);
        } else {
            min = X - min;
            answer += Math.min(min * A, 2 * C * min);
        }
        System.out.println(answer);
    }

}
