import java.io.*;
import java.util.StringTokenizer;
public class _197D_D_Xenia_and_Bit_Operations {
	static boolean q;
	static int p,b,A[];
	public static void Q(int li,int ls,int x){
		if(li==ls){A[x]=b;return;}
		int m=(li+ls)>>1;q=!q;
		if(p<=m)Q(li,m,(x<<1)+1);
		else Q(m+1,ls,(x<<1)+2);
		q=!q;
		if(q)A[x]=~A[(x<<1)+1]&A[(x<<1)+2] | A[(x<<1)+1]&~A[(x<<1)+2];
		else A[x]=A[(x<<1)+1]|A[(x<<1)+2];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tk.nextToken()),m= Integer.parseInt(tk.nextToken()),l=1<<n;
		A= new int[l<<1];
		tk= new StringTokenizer(br.readLine());
		q=n%2==0;
		for (int i = 1; i <=l; i++){
			p=i;b=Integer.parseInt(tk.nextToken());
			Q(1,l,0);
		}
		for (int i = 0; i < m; i++){
			tk= new StringTokenizer(br.readLine());
			p=Integer.parseInt(tk.nextToken());b=Integer.parseInt(tk.nextToken());
			Q(1,l,0);
			pw.println(A[0]);
		}
		pw.close();
	}
}
/*
2 4
1 6 3 5
1 4
3 4
1 2
1 2
*/