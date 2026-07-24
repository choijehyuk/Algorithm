import java.util.*;
import java.io.*;

class Solution {
    static long right = 1_000_000_000L * 1_000_000_000L;
    static long left = 0;
    public long solution(int n, int[] times) {
        long answer = 0;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0 ;            
            
            for(int t: times) {
                cnt += mid / t;
            }
            
            if(cnt >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}