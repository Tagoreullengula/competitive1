import java.io.*;
import java.util.StringTokenizer;
public class _052C_Circular_RMQ {
	static long RMQ[], V[],A[],v,min;
	static int L,R;
	public static void llenado(int li, int ls, int x){
		if(li==ls){RMQ[x]=A[li];return;}
		int m=(li+ls)>>1,nx=x<<1;
		llenado(li,m,nx);llenado(m+1,ls,nx+1);
		RMQ[x]=Math.min(RMQ[nx],RMQ[nx+1]);
	}
	public static void inc(int li, int ls, int x){
		RMQ[x]+=V[x];int nx=x<<1,m;
		if(nx<V.length)V[nx]+=V[x];
		if(nx+1<V.length)V[nx+1]+=V[x];V[x]=0;
		if(L<=ls && li<=R){
			if(L<=li && ls<=R){RMQ[x]+=v;
				if(nx<V.length)V[nx]+=v;
				if(nx+1<V.length)V[nx+1]+=v;
			}else{
				m=(li+ls)>>1;inc(li,m,nx);inc(m+1,ls,nx+1);
				RMQ[x]=Math.min(RMQ[nx],RMQ[nx+1]);
			}
		}
	}
	public static void rmq(int li, int ls, int x){
		RMQ[x]+=V[x];int nx=x<<1,m;
		if(nx<V.length)V[nx]+=V[x];
		if(nx+1<V.length)V[nx+1]+=V[x];V[x]=0;
		if(L<=ls && li<=R){
			if(L<=li && ls<=R){min=Math.min(min,RMQ[x]);return;}
			m=(li+ls)>>1;rmq(li,m,nx);rmq(m+1,ls,nx+1);
			RMQ[x]=Math.min(RMQ[nx],RMQ[nx+1]);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n= Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());A=new long [n+1];
		for (int i = 0; i <n; i++)A[i]=Integer.parseInt(tk.nextToken());
		double l=Math.log(n)/Math.log(2)+1;
		if((int)l<l)l++;
		RMQ= new long[(1<<(int)l)+1];V= new long[(1<<(int)l)+1];
		llenado(0,n-1,1);
		for (int q = Integer.parseInt(br.readLine());q>0;q--){
			tk= new StringTokenizer(br.readLine());
			L=Integer.parseInt(tk.nextToken());R=Integer.parseInt(tk.nextToken());
			if(tk.hasMoreTokens()){
				v=Integer.parseInt(tk.nextToken());
				if(L>R){int aux=R;R=n-1;inc(0,n-1,1);L=0;R=aux;inc(0,n-1,1);
				}else inc(0,n-1,1);
			}else{min=Long.MAX_VALUE;
				if(L>R){int aux=R;R=n-1;rmq(0,n-1,1);L=0;R=aux;rmq(0,n-1,1);
				}else rmq(0,n-1,1);
				pw.println(min);
			}
		}
		pw.close();
	}
}
/*
4
1 2 3 4
4
3 0
3 0 -1
0 1
2 1

*/