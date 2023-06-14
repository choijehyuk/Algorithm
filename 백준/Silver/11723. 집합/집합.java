import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			int num = 0;
			if(order.equals("all") || order.equals("empty")) {					

			}
			else {
				num = Integer.parseInt(st.nextToken());				
			}
			//System.out.println(order + " "  + num);
			boolean check = false;
			boolean toggle = false;
			boolean remove = false;
			if(order.equals("add")) {
				list.add(num);
			}
			else if(order.equals("remove")) {
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j) == num) {
						remove = true;
						break;
					}
				}
				if(remove) {					
					list.remove(new Integer(num));
				}
			}
			else if(order.equals("check")) {
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j) == num) {
						check = true;
						break;
					}
				}
				if(check) {
					sb.append(1 + "\n");
				}
				else {
					sb.append(0 + "\n");
				}
			}
			else if(order.equals("toggle")) {
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j) == num) {
						toggle = true;
						break;
					}
				}
				if(toggle) {
					list.remove(new Integer(num));
				}
				else {
					list.add(num);
				}
			}
			else if(order.equals("all")) {
				list = new ArrayList<>();
				for (int j = 1; j <= 20; j++) {
					list.add(j);
				}
			}
			else if(order.equals("empty")) {
				list = new ArrayList<>();
			}
		}
		System.out.println(sb);
		
	}

}