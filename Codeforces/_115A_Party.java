import java.util.*;
public class _115A_Party {
	static boolean Visitados[];
	static int v[],n,res;
	static Lista E [];
	public static void Grupos(int i){
		Visitados[i]=true;
	    Nodo A = E[i].ini;
	    while(A!=null){
	    	if(!Visitados[A.n]){
	    	Grupos(A.n);
	    	}
	    	if(v[A.n]>v[i])
	    	v[i]=v[A.n];
	    	A=A.sig;
	    }
	    v[i]++;
	    if(v[i]>res)res=v[i];
	}
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		while(leer.hasNext()){
			 n = leer.nextInt();
		     Visitados = new boolean[n+1];
		     v = new int[n+1];
		     E = new Lista[n+1];
		     for (int i = 1; i <=n; i++) 
				E[i]=new Lista ();
			  for(int i = 1; i <=n; i++) {
				 int y = leer.nextInt();
				 if(y!=-1)
				 E[y].add(i); 
			  }
              res=0;
              for (int i = 1; i <=n; i++) {
            	  if(!Visitados[i])
					Grupos(i); 
			}
              System.out.println(res);
			  
		}
	}
   static class Nodo{
	   int n;
	   Nodo sig;
	   public Nodo(int x ){
		   n=x;sig=null;
	   }
   }
   static class Lista{
		Nodo ini;
		public Lista (){
			ini= null;
		}
		public void add (int x){
			Nodo A = new Nodo(x);
	        A.sig=ini;
	        ini=A;
		}
		
	} 
}

/*
5
-1
1
2
1
-1

10
5
-1
7
-1
2
3
2
1
1
8
 */
