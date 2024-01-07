import java.util.*;
public class _427C_Checkposts{
	static Lista A [];
    static boolean P[],V[],c;
    static int B[],L[];
    static long min,r;
    static long mini,cont;
    static Puntero Pp;
    public static void Checkposts(int i){
    	if(!P[i]){
    		if(!V[i]){
    		V[i]=true;
    	    Nodo aux = A[i].ini;
    	    boolean a=false;
    	    while(aux!=null){c=false;
    	    Checkposts(aux.n);
    	    a=a||c;
    	    }
    	    if(a){
    	    	if(A[i].p<=min){
    	    		if(A[i].p<min){min=A[i].p;r=1;}
    	    		else r++;
    	    	}
    	    	if(i==Pp.n){mini+=min;cont=cont*r;min=Long.MAX_VALUE;}
    	    }else{
    	    	mini+=min;cont=cont*r;
    	    	min=Long.MAX_VALUE;
    	    }
    		V[i]=false;
    		P[i]=true;
    	}else{
    		 
    	  }
        }else{
    		if(V[A[i].P.n]){
    			c=true;
    			if(A[i].P.n<=min){
    				if(A[i].P.n<min){min=A[i].P.n;r=1;}
    				else r++;
    			}
    		}
    	}
    }
    
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
	    int n = leer.nextInt();
	    A = new Lista[n+1];
	    for (int i = 1; i <=n; i++) 
			A[i]= new Lista(leer.nextLong());
		int m = leer.nextInt();
		for (int i = 0; i < m; i++) 
			A[leer.nextInt()].add(leer.nextInt());
		P= new boolean[n+1];
		mini=0;cont=1;
		for (int i = 1; i <=n; i++){
			if(!P[i]){
				V= new boolean[n+1];
				B= new int[n+1];
				c=false;
				min=Long.MAX_VALUE;
				Checkposts(i);
			}
		}
		System.out.println(mini +" "+ cont);
	}
	public static class Nodo{
		int n;
		Nodo sig;
		public Nodo(int x){
			n=x;
			sig=null;
		}
	}
	public static class Puntero{
		int n,min;
		public Puntero(int x,int y){
			n=x;min=y;
		}
	}
	public static class Lista{
		Nodo ini;
		long p;
		Puntero P;
        public Lista(long x){
        	ini=null;p=x;P=null;
        }
        public void add (int x){
        	Nodo aux = new Nodo(x);
        	aux.sig=ini;
        	ini = aux;
        }
	}
}
