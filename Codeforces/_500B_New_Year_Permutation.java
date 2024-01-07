import java.io.*;
import java.util.StringTokenizer;
public class _500B_New_Year_Permutation {
	public static void main(String[] args) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(br.readLine());
		int P[]= new int[n];
		StringTokenizer tk =new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)P[i]=Integer.parseInt(tk.nextToken());
		char A[][]=new char[n][n];
		
		
		pw.close();
	}
}
