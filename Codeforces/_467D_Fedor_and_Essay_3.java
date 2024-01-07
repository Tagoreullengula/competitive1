import java.util.*;
public class _467D_Fedor_and_Essay_3 {
static TreeMap<String, Integer> redir;
static int k,min,minl,res,resl;
static Lista E[];
static boolean v[];
static LinkedList<Integer> rea,vis;
public static void actualiza(){
	while(!rea.isEmpty()){
		int i = rea.remove();
		E[i].v=false;
		E[i].nroR=min;
		E[i].nroL=minl;
	}
}
public static void calcula(int i){
	if(!v[i]){
		v[i]=true;
		vis.add(i);
		if(E[i].nroR<min || (E[i].nroR==min&&E[i].nroL<=minl)){
		  min=E[i].nroR;
		  minl=E[i].nroL;
		  if(E[i].nroR==min && E[i].nroL==minl)
			  rea.addAll(vis);
		  else
		      rea=(LinkedList<Integer>) vis.clone();
		}
		if(E[i].v){
			Nodo aux = E[i].ini;
			while(aux!=null){
				calcula(aux.n);
			    aux=aux.sig;
			}
		}
		vis.remove();
	}
}
public static void main(String[] args){
      Scanner leer = new Scanner(System.in);
      int n = leer.nextInt();
      k=0;
      E= new Lista[300000];
      redir=new TreeMap<String, Integer>();
      LinkedList<Integer> T = new LinkedList<Integer>();
      for (int i = 0; i < n; i++){
		String x= leer.next().toLowerCase();
		if(!redir.containsKey(x)){redir.put(x,k);
		int r=0;
		for (int j = 0; j < x.length(); j++){
			if(x.charAt(j)=='r')r++;
		}
		E[k]=new Lista(r,x.length());k++;}
		T.add(redir.get(x));
	  }
      int m = leer.nextInt();
      for (int i = 0; i < m; i++) {
		String x = leer.next().toLowerCase();
		String y = leer.next().toLowerCase();
		if(!redir.containsKey(x)){
			redir.put(x, k);
			int r =0;
			for (int j = 0; j < x.length(); j++) {
				if(x.charAt(j)=='r')r++;
			}
			E[k]=new Lista(r,x.length());k++;
		}
		if(!redir.containsKey(y)){
			redir.put(y, k);
			int r =0;
			for (int j = 0; j < y.length(); j++) {
				if(y.charAt(j)=='r')r++;
			}
			E[k]= new Lista(r,y.length());k++;
		}
		E[redir.get(x)].add(redir.get(y));
	  }
      res=0;resl=0;
      while(!T.isEmpty()){
    	  v=new boolean [k];
    	  rea=new LinkedList<Integer>();
    	  vis=new LinkedList<Integer>();
    	  int i=T.remove();
    	  min=E[i].nroR;
    	  minl=E[i].nroL;
    	  calcula(i);
    	  actualiza();
          res+=min;
          resl+=minl;
      }
    System.out.println(res+" "+resl);  
	}
static class Nodo{
	Nodo sig;
	int n;
	public Nodo(int x){n=x;sig=null;}
}

static class Lista{
	int nroR,nroL;
	Nodo ini;
	boolean v;
	public Lista(int r,int l){
		nroR=r;
		nroL=l;
		ini=null;v=true;
	}
	public void add(int x){
		Nodo A = new Nodo(x);
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

4
fserk grr rrrr ñoskveer
10
grr rrrr
rrrr r
fserk kjl
pa rrrrrrrrrrr
kjl r
grr fserk
opa opo
ppepe ererere
kjl fserk
r grr

*/
