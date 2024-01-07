import java.io.*;
import java.util.StringTokenizer;
public class _356A_Knight_Tournament {
	static int ST[],N[],LI,LS,C;
	public static void SegmentTree(int li, int ls, int p){
		if(ls>=LI&&li<=LS){
			if(li==ls&&ST[p]==0)ST[p]=li;
			if(ST[p]==0){int m=(li+ls)>>1,p2=p<<1;
				SegmentTree(li, m, p2);SegmentTree(m+1, ls, p2+1);
				if(ST[p2]!=0&&ST[p2]!=0){
					if(ST[p2]!=-1||ST[p2+1]!=-1){
						if(ST[p2]==-1||ST[p2+1]==-1){
							if(ST[p2]!=-1)ST[p]=ST[p2];else ST[p]=ST[p2+1]; 
						}else ST[p]=0;
					}else ST[p]=-1;
				}else ST[p]=0;
			}else{
				if(ST[p]!=-1){
					if(LI<=ST[p]&&ST[p]<=LS&&ST[p]!=C){N[ST[p]]=C;ST[p]=-1;}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(tk.nextToken()),m= Integer.parseInt(tk.nextToken());
		double t=Math.log10(n)/Math.log10(2)+1;
		if((int)t<t)t++;
		ST= new int[1<<(int)t];N=new int [n+1];
		for (int i = 0; i < m; i++){
			tk = new StringTokenizer(br.readLine());
			LI=Integer.parseInt(tk.nextToken());LS=Integer.parseInt(tk.nextToken());C=Integer.parseInt(tk.nextToken());
			SegmentTree(1, n, 1);
		}
		for (int j = 1; j <=n; j++)pw.print(N[j]+" ");
		pw.println();
		pw.close();
	}
}
