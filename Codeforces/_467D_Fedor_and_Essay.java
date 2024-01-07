import java.util.*;
public class _467D_Fedor_and_Essay {
static Ensayo E ;
static Lista A;
static int min,minl,resm,resl,k;
static LinkedList<String> Vis , Rea;

static boolean Visitados[];
public static void acomoda(){
	while(!Rea.isEmpty()){
		String cad = Rea.remove();
		NodoL aux = Ensayo.I;
		while(aux!=null){
			if(aux.A.C.equals(cad))break;
			else aux=aux.sig;
		}
		aux.A.nroL=minl;
		aux.A.nroR=min;
	}
	
}
public static void Calcula(String x){
	NodoL aux=Ensayo.I;
	while(aux!=null){
		if(aux.A.C.equals(x)){
			break;
		}else aux=aux.sig;
	}
	Lista aux1= aux.A;
	if(!Visitados[aux1.r]){
		Visitados[aux1.r]=true;
		if(aux.A.nroL==-1){
			if(aux1.nroR<min || aux1.nroR==min && aux1.C.length()<minl){
			  	min= aux1.nroR;
			  	minl=aux1.C.length();
			  	Rea=(LinkedList<String>)Vis.clone();
			}
			Vis.add(x);
	    Nodo aux2 = aux1.ini;
		while(aux2!=null){
			Calcula(aux2.cad);			
			aux2=aux2.sig;
		}
		Vis.remove();
		}
		else{
			if(aux1.nroR<min || aux1.nroR==min && aux1.nroL<minl){
			  	min= aux1.nroR;
			  	minl=aux1.nroL;
			  	Rea=(LinkedList<String>)Vis.clone();
			}
		}
		}
	}

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		k=-1;
		A = new Lista("");
        E= new Ensayo();
		for (int i = 0; i < n; i++){
		String c=leer.next().toLowerCase();
			A.add(c);
			E.adi(c,"");
        }
        int m = leer.nextInt();
        for (int i = 0; i < m; i++) {
			String c = leer.next().toLowerCase();
			String h = leer.next().toLowerCase();
			E.adi(c,h);
			E.adi(h,"");
		}
        resm=0;resl=0;
        Nodo aux=A.ini;
        while(aux!=null){
        	min=Integer.MAX_VALUE;minl=Integer.MAX_VALUE;
        	Visitados= new boolean[k];
            Rea= new LinkedList<String>();
            Vis= new LinkedList<String>();  
        	Calcula(aux.cad);
        	acomoda();
            aux=aux.sig;
            resm+=min;
            resl+=minl;
        }
        System.out.println(resm+" "+resl);
	}
   static class Nodo {
		String cad;
		Nodo sig;
		public Nodo(String x){
			cad=x;
			sig=null;
		}
	}
	static class Lista{
		Nodo ini;
		String C;
		int nroR;
		int r=0;
		int nroL;
		public Lista(String x){
			ini=null;
			C=x;r=k;k++;
			nroR=0;
			for (int i = 0; i < C.length(); i++) {
				if(C.charAt(i)=='r')nroR++;
			}
			nroL=-1;
		}
		public void add(String x){
			Nodo A = new Nodo(x);
			A.sig=ini;
			ini=A;
		}
	}
	static class NodoL{
		Lista A;
		NodoL sig;
		public NodoL(Lista x){
			A=x;
			sig=null;
		}
	}
	static class Ensayo{
		static NodoL I;
		public Ensayo(){
			I=null;
		}
		public void adi(String x,String h){
			NodoL aux = I;
			boolean q = true;
			while(aux!=null&&q){
				if(aux.A.C.equals(x))q=false;
				else aux=aux.sig;
			}
			if(q){
				Lista A = new Lista(x);
			    NodoL B = new NodoL(A);
			    B.sig=I;
			    I=B;
			    aux=I;
			}
			if(h.length()>0)aux.A.add(h);
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
