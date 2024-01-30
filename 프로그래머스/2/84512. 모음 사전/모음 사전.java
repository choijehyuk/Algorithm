import java.util.*;

class Solution {
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static ArrayList<String> list;
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        
        solve(0,"");
        Collections.sort(list);
        answer = list.indexOf(word) + 1;
        return answer;
    }
    
    private static void solve(int idx , String s){
        if(idx >= 5) return;
        
        for(int i = 0; i < alpha.length; i++){
            list.add(s + alpha[i]);
            solve(idx+1, s + alpha[i]);
        }
    }
}