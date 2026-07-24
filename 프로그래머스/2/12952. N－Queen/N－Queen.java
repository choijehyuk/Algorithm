import java.util.*;
import java.io.*;

class Solution {
    static int[] col;
    static int n;
    static int cnt;
    public int solution(int n) {
        int answer = 0;
        
        this.n = n;
        
        col = new int[n];
        
        dfs(0);
        
        answer = cnt;
        
        return answer;
    }
    
    public static void dfs(int row) {
        if(row == n) {
            cnt++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            col[row] = i;
            if(isQueen(row, i)) dfs(row + 1);
        }
    }
    
    public static boolean isQueen(int row, int c) {
        for(int i = 0; i < row; i++) {
            if(col[i] == c) return false;
            if(Math.abs(row - i) == Math.abs(col[i] - c)) return false;
        }
        return true;
    }
}