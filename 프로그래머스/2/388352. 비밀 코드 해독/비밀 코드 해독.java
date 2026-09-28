import java.util.*;
import java.io.*;

class Solution {
    static int n;
    static boolean[] visited;
    static int[] arr;
    static int[][] q;
    static int[] ans;
    static int[] sel;
    static int answer;

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        answer = 0;

        visited = new boolean[n];
        arr = new int[n];
        sel = new int[5];

        for (int i = 0; i < n; i++) arr[i] = i + 1;

        combination(arr, visited, 0, 5);
        return answer;
    }

    public static void combination(int[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            fillSel(arr, visited);
            if (check(sel)) answer++;
            return;
        }
        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }

    public static void fillSel(int[] arr, boolean[] visited) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                sel[idx++] = arr[i];
            }
        }
    }

    public static boolean check(int[] sel) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < sel.length; k++) {
                    if (q[i][j] == sel[k]) cnt++;
                }
            }
            if (cnt != ans[i]) return false;
        }
        return true;
    }
}