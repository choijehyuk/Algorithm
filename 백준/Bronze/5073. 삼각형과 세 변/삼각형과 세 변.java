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

        while (true) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];

            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                System.exit(0);
            }

            Arrays.sort(arr);
            if (arr[0] + arr[1] <= arr[2]) {
                System.out.println("Invalid");
                continue;
            }

            int cnt = 0;
            if (arr[0] == arr[1]) {
                cnt++;
            }
            if (arr[0] == arr[2]) {
                cnt++;
            }
            if (arr[1] == arr[2]) {
                cnt++;
            }

            switch (cnt) {
                case 0:
                    System.out.println("Scalene");
                    break;
                case 1:
                    System.out.println("Isosceles");
                    break;
                case 3:
                    System.out.println("Equilateral");
                    break;
            }
        }
    }
}
