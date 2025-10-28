import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] maxArr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            int max = Integer.MIN_VALUE;
            int div = 0;
            for (int j = 0; j < 3; j++) {
                sum = 0;
                for (int k = j + 1; k < 4; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        sum = arr[j] + arr[k] + arr[l];
                        div = sum % 10;
                        max = Math.max(max, div);
                    }
                }
            }

            maxArr[i] = max;
        }

        int ans = 0;
        int maxAns = Integer.MIN_VALUE;

        for (int i = 0; i < maxArr.length; i++) {
            if (maxArr[i] >= maxAns) {
                maxAns = maxArr[i];
                ans = i + 1;
            }
        }

        System.out.println(ans);
    }
}