import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] rank = new int[k];
        boolean flag = false;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k; i ++){
            if(i >= score.length){
                flag = true;
                break;
            }
            rank[i] = score[i];
            min = Math.min(min, rank[i]);
            answer[i] = min;
        }
        Arrays.sort(rank);
        
        if(!flag){
            for(int i = k; i < score.length; i++){
                if(k >= score.length){
                    flag = true;
                    break;
                }
                if(score[i] > rank[0]){
                    rank[0] = score[i];
                }
                Arrays.sort(rank);
                answer[i] = rank[0];
            }
        }
        
        return answer;
    }
}