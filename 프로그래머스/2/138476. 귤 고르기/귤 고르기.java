import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int[] arr = new int[10000001];
        
        for(int i = 0; i < tangerine.length; i++){
            arr[tangerine[i]]++;
        }
        
        Arrays.sort(arr);
        int sum = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            sum += arr[i];
            answer++;
            if(sum >= k){
                break;
            }
        }
        
        return answer;
    }
}