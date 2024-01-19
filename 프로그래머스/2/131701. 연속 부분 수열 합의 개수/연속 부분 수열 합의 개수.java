import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[elements.length * 2];
        
        for(int i = 0; i < elements.length; i++){
            arr[i] = elements[i];
            arr[i + elements.length] = elements[i];
        }
        
        int left = 0;
        int right = 1;
        
        while(left < elements.length){
            int sum = 0;
            
            for(int i = left; i < right; i++){
                if(right > elements.length + left){
                    break;
                }
                sum += arr[i];
                set.add(sum);
                right++;
            }
            left ++;
            right = left + 1;
            
        }
        
        //System.out.println(set);
        //System.out.println(set.size());
        answer = set.size();
        
        return answer;
    }
}