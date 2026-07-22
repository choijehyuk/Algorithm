import java.util.*;
import java.io.*;

class Solution {
    static boolean[] v;
    static ArrayList<String> list = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        v = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        
        String[] answer = new String[tickets.length + 1];
        Collections.sort(list);

        return list.get(0).split(" ");
    }
    
    public static void dfs(int depth, String now, String tempAns
                          , String[][] tickets) {
        if(depth == tickets.length) {
            list.add(tempAns);
            return;
        }
        
        for(int i = 0; i < tickets.length; i ++) {
            if(!v[i] && now.equals(tickets[i][0])) {
                v[i] = true;
                dfs(depth + 1, tickets[i][1], tempAns + " " + tickets[i][1]
                    , tickets);
                v[i] = false;
            }
        }
        
    }
}