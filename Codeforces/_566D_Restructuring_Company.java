import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class _566D_Restructuring_Company {
	static boolean SG[];
	static int dsu[],r[],LS,LI;
	public static int f(int a){
		LinkedList<Integer> A= new LinkedList<Integer>();
		while(true){A.add(a);if(dsu[a]!=a)a=dsu[a];else break;}
		while(!A.isEmpty())dsu[A.remove()]=a;
		return a;
	}
	public static boolean sameSet(int a, int b){return f(a)==f(b);}
	public static void union(int a,int b){
		if(!sameSet(a, b)){
			if(r[dsu[a]]<=r[dsu[b]]){
				if(r[dsu[a]]==r[dsu[b]])r[dsu[b]]++;
				dsu[dsu[a]]=b;
			}else dsu[dsu[b]]=a;
		}
	}
	public static void query(int li, int ls, int x,boolean q){
		if(q)SG[x]=true;
		if(ls<LI||li>LS)return;
		int m=(li+ls)>>1,mx=x<<1;
		if(LI<=li && ls<=LS){
			if(!SG[x]){SG[x]=true;
				for (int i = li; i <=ls; i++)union(LI, i);
			}else union(LI,m);
		}else{
			query(li, m, mx+1,SG[x]);query(m+1, ls, mx+2,SG[x]);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(tk.nextToken());
		double l=Math.log(n)/Math.log(2)+1;
		if((int)l<l)l++;
		dsu= new int[n+1];SG=new boolean[1<<(int)l];r= new int[n+1];
		for (int i = 1; i <=n; i++)dsu[i]=i;
		for (int q = Integer.parseInt(tk.nextToken()),c;q>0;q--){
			tk = new StringTokenizer(br.readLine());
			c=Integer.parseInt(tk.nextToken());LI=Integer.parseInt(tk.nextToken());LS=Integer.parseInt(tk.nextToken());
			if(c==1)union(LI,LS);
			if(c==2)query(1, n, 0, SG[0]);
			if(c==3){
				if(sameSet(LI, LS))pw.println("YES");else pw.println("NO");
			}
		}
		pw.close();
	}
}
/*
8 6
3 2 5
1 5 2
3 2 5
2 4 7
2 1 2
3 7 1

*/