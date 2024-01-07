import java.util.*;
public class _467D_Fedor_and_Essay_2 {
static int min,minl,k;
static TreeMap<String, Lista> Ensayo;
static LinkedList<String> Act,Vis;
public static void Actualiza(){
	while(!Act.isEmpty()){
		Lista A = Ensayo.get(Act.remove());
	    A.V=false;
	    A.nroL=minl;
	    A.nroR=min;
	}
	
}
public static void calcula(String x){
      Lista A= Ensayo.get(x);
      if(!visitados[A.n]){
      visitados[A.n]=true;
      if(A.nroR <min || A.nroR==min & A.nroL<minl){
		  min=A.nroR;
		  minl=A.nroL;
		 Act=(LinkedList<String>) Vis.clone();
	  }
      if(A.V){
      Vis.push(x);
      Nodo aux = A.ini;
      while(aux!=null){
    	  calcula(aux.cad);
    	  aux=aux.sig;
      }
      Vis.pop();
      }
      }
}
static boolean visitados[];
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
        Ensayo = new TreeMap<String,Lista>();
		String E []= new String[n];
		k=0;
		for (int i = 0; i < n; i++) {
			E[i] = leer.next().toLowerCase();
			int r = 0;
			for (int j = 0; j < E[i].length(); j++) {
				if(E[i].charAt(j)=='r')r++;
			}
			Lista A = new Lista(r,E[i].length());
		    Ensayo.put(E[i], A);
		}
		int m = leer.nextInt();		
		for (int i = 0; i < m; i++){
			String x = leer.next().toLowerCase();
			String y = leer.next().toLowerCase();
			
		    if(!Ensayo.containsKey(x)){
		    	int r = 0;
				for (int j = 0; j < x.length(); j++) {
					if(x.charAt(j)=='r')r++;
				}Lista A = new Lista(r,x.length());
				A.add(y);
				Ensayo.put(x, A);
		    }else Ensayo.get(x).add(y);
		    if(!Ensayo.containsKey(y)){
		    	int r=0;
		    	for (int j = 0; j < y.length(); j++) {
					if(y.charAt(j)=='r')r++;
				}
		    	Lista A = new Lista(r,y.length());
		    	Ensayo.put(y, A);
		    }
		}
		int resR=0,resL=0;
		for (int i = 0; i < E.length; i++) {
			visitados= new boolean[k];
		    Act= new LinkedList<String>();
		    Vis=new LinkedList<String>();
		    min=Integer.MAX_VALUE;
		    minl=Integer.MAX_VALUE;
		    calcula(E[i]);
		    Actualiza();
		    resL+=minl;
		    resR+=min;
		}
		System.out.println(resR+" "+resL);
	}
static class Nodo {
	String cad;
	Nodo sig;
	public Nodo(String c){
		cad=c;
		sig=null;
	}
}
	static class Lista{
		int n;
		Nodo ini;
		int nroR;
		int nroL;
		boolean V;
		public Lista(int y,int z){
			nroR=y;
			ini=null;
			n=k;k++;
			nroL=z;
			V=true;
		}
		public void add(String c){
			Nodo A = new Nodo(c);
			A.sig=ini;
			ini=A;
		}
	}
	
}
/*
3
AbRb r Zz
4
xR abRb
aA xr
zz Z
xr y 

2
RuruRu fedya
1
ruruRU fedor

*/
