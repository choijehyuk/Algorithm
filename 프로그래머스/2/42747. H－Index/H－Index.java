import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0 ; i < citations.length; i++) {
            // 0 1 4 5 6
            // 3편이 3번이상
            // 2편이 2번
            
            int len = citations.length;
            
            if(i + 1 <= citations[len - i - 1]) answer = i + 1;
        }
        
        
        return answer;
    }
}