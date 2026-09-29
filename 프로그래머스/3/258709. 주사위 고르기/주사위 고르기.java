import java.util.*;

class Solution {
    static int[][] dice;
    static int n;
    static int maxWin;
    static int[] answer;

    public int[] solution(int[][] dice) {
        Solution.dice = dice;
        n = dice.length;
        maxWin = -1;
        answer = new int[n / 2];

        combination(new boolean[n], 0, 0);
        return answer;
    }

    static void combination(boolean[] v, int start, int depth) {
        if (depth == n / 2) {
            calWinRate(v);
            return;
        }
        for (int i = start; i < n; i++) {
            v[i] = true;
            combination(v, i + 1, depth + 1);  
            v[i] = false;
        }
    }

    static void calWinRate(boolean[] v) {
        int[] a = new int[n / 2];
        int[] b = new int[n / 2];
        int ai = 0, bi = 0;
        for (int i = 0; i < n; i++) {
            if (v[i]) a[ai++] = i;
            else      b[bi++] = i;
        }

        List<Integer> sumA = new ArrayList<>();
        List<Integer> sumB = new ArrayList<>();
        makeSums(a, 0, 0, sumA);
        makeSums(b, 0, 0, sumB);
        Collections.sort(sumB);

        int win = 0;
        for (int s : sumA) {
            win += countLess(sumB, s);   
        }

        if (win > maxWin) {
            maxWin = win;
            for (int i = 0; i < a.length; i++) answer[i] = a[i] + 1; 
        }
    }

    static void makeSums(int[] sel, int depth, int sum, List<Integer> out) {
        if (depth == sel.length) {
            out.add(sum);
            return;
        }
        for (int f = 0; f < 6; f++) {
            makeSums(sel, depth + 1, sum + dice[sel[depth]][f], out);
        }
    }

    static int countLess(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}