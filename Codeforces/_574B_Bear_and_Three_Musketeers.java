import java.util.*;
public class _574B_Bear_and_Three_Musketeers{
	static boolean P[];
	static Lista A[];
	static int M[][];
	static long min;
	public static void Calcula(int a,int i){
		Nodo aux = A[i].ini;
		while(aux!=null){
				if(aux.n!=a&&M[aux.n][a]!=0&&A[aux.n].c+A[i].c+A[a].c-6<min)
					min=A[aux.n].c+A[i].c+A[a].c-6;
				if(M[i][aux.n]==1){
					M[i][aux.n]=-1;
					M[aux.n][i]=-1;
					Calcula(i,aux.n);
				}
			aux=aux.sig;
		}
		P[i]=true;
	}
	public static void main(String[] args){
		Scanner leer = new Scanner(System.in);
		int n=leer.nextInt();
		int m=leer.nextInt();
		M= new int[n+1][n+1];
		A= new Lista[n+1];
		P=new boolean[n+1];
		for (int i = 1; i <=n; i++)
			A[i]= new Lista();
		for (int i = 0; i < m; i++){
			int x = leer.nextInt();
			int y = leer.nextInt();
			A[x].add(y);
			A[y].add(x);
			M[x][y]=1;
			M[y][x]=1;
		}
		min=Long.MAX_VALUE;
		for (int i=1;i<=n;i++){
			if(!P[i])
			   Calcula(0,i);
		}
		if(min!=Long.MAX_VALUE)
			System.out.println(min);
		else System.out.println(-1);
	}
	public static class Nodo{
		int n;
		Nodo sig;
		public Nodo(int x){
			n=x;sig=null;
		}
	}
	public static class Lista{
		int c;
		Nodo ini;
		public Lista(){
			ini=null;c=0;
		}
		public void add(int x){
			Nodo aux = new Nodo(x);
			aux.sig=ini;
			ini=aux;
		    c++;
		}
	}
}
