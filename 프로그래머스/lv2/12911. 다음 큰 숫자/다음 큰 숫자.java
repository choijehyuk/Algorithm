class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int one = 0;
        int num = n+1;
        
        while(n > 1){
            if(n % 2 == 1){
                one++;
            }
            n /= 2;
        }
        
        while(true){
            int temp = num;
            int check = 0;
            
            while(temp > 1){
                if(temp % 2 == 1){
                    check++;
                }
                temp /= 2;
            }
            
            if(check == one){
                answer = num;
                break;
            }
            num++;
            
        }
        
        
        
        
        
        
        return answer;
    }
}