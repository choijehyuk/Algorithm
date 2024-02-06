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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] HI = new int[N];
        int[] ARC = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < HI.length; i++) {
            HI[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ARC.length; i++) {
            ARC[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(HI);
        Arrays.sort(ARC);

        long win = 0L;
        long draw = 0L;
        long lose = 0L;
        long cnt = 0L;
        long idx = 0L;
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < HI.length; i++) {
            int num = HI[i];
            if(temp == num) {
                win += idx;
                draw += cnt;
                continue;
            }
            temp = num;
            idx = Arrays.binarySearch(ARC, num);
            for (int j = 0; j <= (int)idx; j++) {
                if (ARC[j] == ARC[(int) idx]){
                    idx = j;
                    break;
                }
            }
            if (idx < 0) idx = -(idx + 1);

            win += idx;
            cnt = 0L;
            for (long j = idx; j < ARC.length; j++) {
                if (HI[i] == ARC[(int) j]){
                    draw++;
                    cnt++;
                }
                else break;

            }
        }

        lose = (long)N * M - win - draw;
        System.out.println(win + " " + lose + " " + draw);
    }

}