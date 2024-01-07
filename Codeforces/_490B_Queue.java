import java.util.*;
public class _490B_Queue {
	static Nodo A[];
	public static void main(String[] args) {
     Scanner leer = new Scanner (System.in);
     int n = leer.nextInt();
     int D[] = new int[1000001];
     int C[] = new int[1000001];
     Lista c = new Lista();
     A= new Nodo[1000001];
     for (int i = 0; i < n; i++) {
		int a = leer.nextInt();
		int b = leer.nextInt();
		D[a]=b;
		C[a]++;C[b]++;
		if(C[a]==1)c.add(a);
		if(C[b]==2)c.remove(b);
	 }
     int b = D[0],a=c.ini.n;
     int r;
     for (int i = 0; i<n; i++){
		if((i&1)==0){r=a;a=D[r];}
		else {r=b;b=D[r];}
		System.out.print(r+" ");
	}
	}

	
public static class Nodo {
	int n; 
	Nodo sig;
	public Nodo(int x){
		n=x;
		sig=null;
	}
}
public static class Lista{
	Nodo ini;Nodo fin;
	public Lista(){
		ini=null;
		fin=null;
	}
	public void add(int x){
		Nodo aux = new Nodo(x);
		if(x==0)return;
		if (ini==null)
			ini=aux;
		else fin.sig=aux;
		A[x]=fin;
		fin=aux;
	}
	public void remove(int x){
		Nodo aux=A[x];
		if(x==0)return;
		if(aux!=null){
			aux=A[x];
			if(aux.sig==fin)fin=A[x];
			else{aux.sig=aux.sig.sig;
			     aux=aux.sig;
			     A[aux.n]=A[x];
			}
		}else{
			ini=ini.sig;
			aux=ini;A[aux.n]=A[x];
		}
		
	}
	
}

}
/*
4
101 0
0 102
102 100
103 101


4
92 31
0 7
31 0
7 141

2 
1 0
0 2


2
34545 0
0 123

2
0 123
34545 0

2 
123 0
0 34545


3
0 2
1 3
2 0

5
123 5000
5000 0
27 41
0 123
41 2

4
3 2
5 0
0 3
1 5

4
5 0
1 5
3 2
0 3

5
0 1
1 4
4 0
3 2
5 3
*/
