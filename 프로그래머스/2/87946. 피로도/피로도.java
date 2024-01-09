class Solution {
    
    static boolean[] v;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        v = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    
    public static void dfs(int depth, int tired, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            if(v[i] || dungeons[i][0] > tired) continue;
            
            v[i] = true;
            dfs(depth + 1, tired - dungeons[i][1], dungeons);
            v[i] = false;
        }
        answer = Math.max(answer, depth);
    }
}