import java.util.*;
public class _489D_Unbearable_Controversy_of_Being {
	static lista C[];
	static int n,res;
	static int Combi[],Rom[];
	static boolean K[];
	public static void DamnRhombi(int i){
		if(C[i].v){
			C[i].v=false;
			nodo aux = C[i].ini;
			Rom=new int[n+1];
			K=new boolean[n+1];
			LinkedList<Integer> A = new LinkedList<Integer> ();
			while(aux!=null){
				nodo aux1=C[aux.n].ini;
				while(aux1!=null){
					if(i!=aux1.n){
						Rom[aux1.n]++;
					    if(Rom[aux1.n]>1&&!K[aux1.n]){A.add(aux1.n);K[aux1.n]=true;}
					}
					aux1=aux1.sig;
				}
				aux=aux.sig;
			}
			while(!A.isEmpty()){
				int y=A.remove();
				if(Combi[Rom[y]]==0)Combi[Rom[y]]=(Rom[y]*(Rom[y]-1))/2;
			    res+=Combi[Rom[y]];
			}
			aux=C[i].ini;
			while(aux!=null){
				DamnRhombi(aux.n);
				aux=aux.sig;
			}
		}
	}
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in); 
		n = leer.nextInt();
		C= new lista[n+1];
        for (int i = 1; i <=n; i++) 
			C[i]= new lista();
	    int m = leer.nextInt();
	    for (int i = 0; i < m; i++) {
			int x = leer.nextInt();
			int y= leer.nextInt();
			C[x].add(y);
		}
	    res=0;
	    Combi= new int[n]; 
	    for (int i = 1; i <=n; i++) {
			DamnRhombi(i);
		}
	    System.out.println(res);
	}
static class nodo{
	int n ;
	nodo sig;
	public nodo(int x){
		n=x;
		sig=null;
	}
}
static class lista{
	nodo ini;
	boolean v;
	public lista(){
		ini=null;
		v=true;
	}
	public void add(int x){
		nodo a = new nodo(x);
		a.sig=ini;
		ini=a;
	}
}
}
/*
4 12
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3

5 4
1 2
2 3
1 4
4 3

8
10
3 4
3 5
3 6
3 7
3 8
4 1
5 1
6 2
7 2
8 2
*/