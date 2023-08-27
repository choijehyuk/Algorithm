import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] card;
    static int[] findCard;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        card = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < card.length; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        findCard = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < findCard.length; i++) {
            findCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        for (int i = 0; i < findCard.length; i++) {
            flag = false;
            find(findCard[i]);
            if (flag) sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        System.out.println(sb);

    }

    private static void find(int cardNum) {
        int left = 0;
        int right = card.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (card[mid] < cardNum) {
                left = mid + 1;
            } else if (card[mid] > cardNum) {
                right = mid - 1;
            } else {
                flag = true;
                break;
            }
        }
    }

}