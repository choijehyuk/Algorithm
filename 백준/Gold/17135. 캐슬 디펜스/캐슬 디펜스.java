import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static int N,M,D,Ans = Integer.MIN_VALUE;
	static class Enemy{
		int r,c;
		Enemy(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
	static ArrayList<Enemy> enemys;
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("캐슬디팬스.txt"));
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		D=sc.nextInt();
		enemys = new ArrayList<Enemy>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(sc.nextInt()==1) {
					enemys.add(new Enemy(r, c));
				}
			}
		}
		//System.out.println(enemys.size());
		// mC3
		combination(0,0,new int[3]);
		System.out.println(Ans);
	}
	private static void combination(int idx, int k, int[] sel) {
		// basis part
		if(k==sel.length) {
			//System.out.println(Arrays.toString(sel));
			// 궁수 배치 하고 적을 잡는다
			ArrayList<Enemy> tmp = new ArrayList<Enemy>();
			// 깊은복사
			for (int i = 0; i < enemys.size(); i++) {
				Enemy e = enemys.get(i);
				tmp.add(new Enemy(e.r, e.c));
			}
			// 죽는 병사수
			int cnt = 0;
			// 모든적을 죽여라
			while(tmp.size()>0) {
				ArrayList<Enemy> death = new ArrayList<Enemy>();
				// 궁수들이 적을 죽입니다
				for (int i = 0; i < 3; i++) {
					// i : 궁수
					int minD = Integer.MAX_VALUE;
					int minIdx = -1;
					int minC = M;
					for (int j = 0; j < tmp.size(); j++) {
						// j : 적군
						Enemy en = tmp.get(j);
						//  |r1-r2| + |c1-c2|
						int dist = Math.abs(N - en.r)+Math.abs(sel[i]-en.c);
						// 사정거리 안에 있고
						if(dist<=D) {
							// 가장 가까운놈
							if(minD>dist) {
								minD = dist;
								minIdx = j;
								minC = en.c;
							}else if(minD==dist) {
								// 거리가 같다면 왼쪽에 있는 놈
								if(en.c < minC) {
									minD=dist;
									minIdx=j;
									minC = en.c;
								}
							}
						}
					}
					// 죽일적군이 선택됬어요
					if(minIdx != -1) {
						death.add(tmp.get(minIdx));
					}
				}// 다음궁수
				// death 에 있는 병사를 삭제한다
				//System.out.println(death.size());
				
				for (int i = 0; i < death.size(); i++) {
					for (int j = 0; j < tmp.size(); j++) {
						if(death.get(i)==tmp.get(j)) {
							tmp.remove(j--);
							cnt++;
						}
					}
				}
//				// 적군이 1보 전진
				
				
				//System.out.println(cnt);
				
				for (int i = 0; i < tmp.size(); i++) {
					tmp.get(i).r++;
					if(tmp.get(i).r==N) {
						tmp.remove(i--);
					}
				}
				
			}
			Ans = Math.max(Ans, cnt);
			return;
		}
		if(idx==M) {
			return;
		}
		
		// mC3
		sel[k]=idx;
		combination(idx+1, k+1, sel);
		combination(idx+1, k, sel);
	}

}






