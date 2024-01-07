import java.util.*;
public class _320B_Ping_Pong {
static long a,b;
static int n;
static boolean T [],r;
static Lista A[];
static LinkedList<Integer> H = new LinkedList<Integer>();
public static void Calcula(int i){
	if(!T[i]){
		T[i]=true;
		r=A[i].V[(int)b];
		if(!r){
			Nodo aux = A[i].ini;
			while(aux!=null&&!r){
				Calcula(aux.n);
				aux=aux.sig;
			}
		}
	}
		
}

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		n = leer.nextInt();
		A = new Lista[n+1];
	    LinkedList<Long> xs = new LinkedList<Long>();
	    LinkedList<Long> ys = new LinkedList<Long>();
		for (int i = 0,k=1; i < n; i++) {
			int t = leer.nextInt();
			a= leer.nextLong();b=leer.nextLong();
			if(t==2){
				while(!xs.isEmpty()){
					A[k]= new Lista(xs.remove(), ys.remove());
					for (int j = 1; j<k; j++){
						if(A[j].a<A[k].a&&A[k].a<A[j].b || A[j].a<A[k].b&&A[k].b<A[j].b)A[k].add(j);
						if(A[k].a<A[j].a&&A[j].a<A[k].b || A[k].a<A[j].b&&A[j].b<A[k].b)A[j].add(k);
					}
					k++;
				}
				T= new boolean[n+1];
				Calcula((int)a);
				if(r)System.out.println("YES");
				else System.out.println("NO");
			}
			else{
				xs.add(a);ys.add(b);
			}
		}

	}
    public static class Nodo{
	 int n;
	 Nodo sig;
	 public Nodo (int x){
		 n=x;sig=null;
	 }
    }
    public static class Lista{
	Nodo ini;
	boolean V[]= new boolean [n+1];
	long a, b;
	public Lista(long x, long y){
		a=x;b=y;ini=null;
	}
	 public void add(int x){
		 Nodo aux= new Nodo(x);
		 aux.sig=ini;
		 ini=aux;
		 V[x]=true;
	 }
    }
}
/*
13
1 1 5
1 5 11
2 1 2
1 2 9
2 1 2
1 5 130000000
2 2 4
2 4 2
1 -754634345  -474443
2 1 5
2 5 1
1 -666666666 4 
2 1 5


*/