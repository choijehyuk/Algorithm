import java.util.*;

class Solution {
    static int[][] triangle;
    static int[][] sumArr;
    static int max = Integer.MIN_VALUE;
    
    public int solution(int[][] triangle) {
        this.triangle = triangle;
        
        int n = triangle.length;
        int[][] sumArr = new int[n][];
        for (int i = 0; i < n; i++) {
            sumArr[i] = new int[i + 1];
        }
        
        sumArr[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {                       
                    sumArr[i][j] = sumArr[i-1][j] + triangle[i][j];
                } else if (j == i) {                
                    sumArr[i][j] = sumArr[i-1][j-1] + triangle[i][j];
                } else {                            
                    sumArr[i][j] = Math.max(sumArr[i-1][j-1], sumArr[i-1][j]) + triangle[i][j];
                }
            }
        }

        int answer = 0;
        for (int v : sumArr[n-1]) {
            answer = Math.max(answer, v);
        }
        return answer;
    }
}