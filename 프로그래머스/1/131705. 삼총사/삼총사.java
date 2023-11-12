class Solution {
    static int answer = 0;
    public int solution(int[] number) {
        
        recursive(number,new int[3],0,0);
        return answer;
    }
    
    public static void recursive(int[] number, int[] sel, int idx , int k){
        if(k == sel.length){
            int sum = 0;
            for(int i = 0; i< sel.length; i++){
                sum += sel[i];
            }
            if(sum == 0){
                answer++;
            }
            return;
        }
        
        for(int i=idx;i<number.length;i++){
			sel[k]=number[i];
			recursive(number,sel,i+1,k+1);
		}

    }
}