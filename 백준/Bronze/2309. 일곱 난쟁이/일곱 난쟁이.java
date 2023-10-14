import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int[] height = new int[9];
        int sum = 0;
        int[] answer = new int[7];

        for (int i = 0; i < height.length; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < height.length; i++) {
            sum += height[i];
        }

        int idx = 0;

        L:
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (sum - 100 == height[i] + height[j]) {
                    for (int k = 0; k < height.length; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        answer[idx] = height[k];
                        idx++;
                    }
                    break L;
                }
            }
        }

        Arrays.sort(answer);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

}