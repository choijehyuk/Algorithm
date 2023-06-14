import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String script = br.readLine();
		String find = br.readLine();

		int scriptsize = script.length();
		int findsize = find.length();

		script = script.replace(find, "");
		System.out.println((scriptsize - script.length()) / findsize);
	}

}
