class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        boolean[] v = new boolean[26];
        
        for(int i = 0; i < skip.length(); i++){
            char c = skip.charAt(i);
            v[c - 'a'] = true;
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int plus = c - 'a';
            
            int add = 0;
            int cnt = 1;
            
            while(true){
                //System.out.println((plus + cnt) % 26 );
                if(!v[(plus + cnt) % 26]){
                  add++;  
                } 
                cnt++;
                if(add == index) break;
            }
            
            int sum = plus + cnt - 1;
            if(sum >= 26){
                 sum %= 26;
            }
            
            char change = (char)((char)sum + 'a');
            answer += change;
        }
        
        
        
        return answer;
    }
}