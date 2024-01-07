import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class _893_Subtree_Minimum_Query{
	static LinkedList<Integer> T[];
	static int A[],R[],C[],NH[],P,pp,nh,M[][],RI,RS,CI,CS,min,F[];
	public static int DFS(int i, int p){
		pp++;Iterator<Integer> it= T[i].iterator();boolean q=true;F[i]=p;
		while(it.hasNext()){int r=it.next();if(r!=p){q=false;NH[i]+=DFS(r,i);}}
		if(q){P=Math.max(P, pp);NH[i]=1;}
		pp--;return NH[i];
	}
	public static nodo llena(int ri,int ci,int rs,int cs,nodo x){
		if(ri>rs || ci>cs)return x= new nodo (Integer.MAX_VALUE);
		int li=0,l=M[ri].length-1,ls=l,m,m1,m2;
		while(li<ls){
			m=(li+ls)>>1;
			if(C[M[ri][m]]<ci&&m<l&&C[M[ri][m+1]]<=ci)li=m+1;
			else ls=m;
		}m1=M[ri][li];li=0;ls=l;
		while(li<ls){
			m=(li+ls)>>1;
			if(C[M[ri][m]]<cs&&m<l&&C[M[ri][m+1]]<=cs)li=m+1;
			else ls=m;
		}m2=M[ri][li];
		if(C[m1]<=ci&&ci<C[m1]+NH[m1]||C[m2]<=cs&&cs<C[m2]+NH[m2]||ci<=C[m2]&&C[m2]<=cs){
			if(ri==rs && ci==cs){x= new nodo(A[m1]);return x;}
			int rm=(ri+rs)>>1,cm=(ci+cs)>>1;
			x=new nodo(Integer.MAX_VALUE);
			x.n1=llena(ri,ci,rm,cm,x.n1);
			x.n2=llena(ri,cm+1,rm,cs,x.n2);
			x.n3=llena(rm+1,cm+1,rs,cs,x.n3);
			x.n4=llena(rm+1,ci,rs,cm,x.n4);
			x.a=Math.min(Math.min(x.n1.a,x.n2.a),Math.min(x.n3.a,x.n4.a));
		}else x= new nodo (Integer.MAX_VALUE);
		return x;
	}
	public static void query(int ri,int ci,int rs,int cs,nodo x){
		if(x==null || ri>rs || ci>cs||rs<RI || cs<CI || ri>RS || ci>CS)return;
		if(RI<=ri && CI<=ci && rs<=RS && cs<=CS){
			if(x.a<Integer.MAX_VALUE)min=Math.min(min, x.a);return;
		}int rm=(ri+rs)>>1,cm=(ci+cs)>>1;
		query(ri,ci,rm,cm,x.n1); query(ri,cm+1,rm,cs,x.n2);
		query(rm+1,cm+1,rs,cs,x.n3);query(rm+1,ci,rs,cm,x.n4);
	}
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =  new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(tk.nextToken()),r=Integer.parseInt(tk.nextToken());A= new int[n+1];
		tk = new StringTokenizer(br.readLine());
		for (int i = 1; i <=n;i++)A[i]=Integer.parseInt(tk.nextToken());
		T= new LinkedList[n+1];T[1]=new LinkedList<Integer>();
		for (int i = 1,r1,r2; i < n; i++){
			tk = new StringTokenizer(br.readLine());
			r1=Integer.parseInt(tk.nextToken());r2= Integer.parseInt(tk.nextToken());
			if(T[r1]==null)T[r1]= new LinkedList<Integer>();
			if(T[r2]==null)T[r2]= new LinkedList<Integer>();
			T[r1].add(r2);T[r2].add(r1);
		}R= new int[n+1];C= new int[n+1];NH= new int[n+1];pp=0;P=0;F= new int[n+1];
		nh=DFS(r,0);M= new int[P][];int c=1;pp=0;
		LinkedList<Integer> BFS= new LinkedList<Integer>();BFS.add(r);
		boolean V[]= new boolean[n+1];
		while(pp<P){int nc=0,pa=0,pact=0;M[pp]=new int[c];
			for (int i = 0,rr; i < c; i++){rr=BFS.removeFirst();V[rr]=true;R[rr]=pp;M[pp][i]=rr;
				if(pa!=F[rr]){pact=C[F[rr]];pa=F[rr];}C[rr]=pact;pact+=NH[rr];
				while(!T[rr].isEmpty()){
					int nr=T[rr].removeFirst();
					if(!V[nr]){nc++;BFS.add(nr);}
				}
			}pp++;c=nc;
		}T=null;V=null;F=null;
		nodo X=null;
		X=llena(0,0,P-1,nh-1,X);
		int xi,ki;M=null;A=null;long ant=0;
		for (int m= Integer.parseInt(br.readLine()); m>0; m--){tk = new StringTokenizer(br.readLine());
			xi=(int)((Integer.parseInt(tk.nextToken())+ant)%n+1);ki=(int)((Integer.parseInt(tk.nextToken())+ant)%n);
			RI=R[xi];CI=C[xi];RS=Math.min(RI+ki,P-1);CS=CI+NH[xi]-1;min=Integer.MAX_VALUE;
			query(0,0, P-1, nh-1, X);
			pw.println(min);ant=min;
		}
		pw.close();
	}
	public static class nodo{
		int a;nodo  n1,n2,n3,n4;public nodo(int x){ a=x;n1=null;n2=null;n3=null;n4=null;}
	}
}

/*
5 2
1 3 2 3 5
2 3
5 1
3 4
4 1
2
1 2
2 3



7 1
1 2 3 4 5 6 7
1 2
1 3
2 4 
2 5
3 6
3 7
3
6 0
2 6
4 2

*/