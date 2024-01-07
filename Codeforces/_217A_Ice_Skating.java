import java.util.*;
public class _217A_Ice_Skating {
static int n;
static LinkedList<Punto> P;
static Lista X[],Y[];
public static void Recorrer(Punto A){
	X[A.x].V=true;
	Y[A.y].V=true;
	Nodo aux = X[A.x].ini;
	while(aux!=null){
		if(!Y[aux.n].V){Punto B = new Punto(A.x,aux.n);Recorrer(B);}
	aux=aux.sig;
	}
	aux=Y[A.y].ini;
	while(aux!=null){
		if(!X[aux.n].V){Punto B = new Punto(aux.n,A.y);Recorrer(B);}
	aux=aux.sig;
	}
}


	public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
    while(leer.hasNext()){
    int n = leer.nextInt();
       P= new LinkedList<Punto>();
       X= new Lista[1001];
       Y= new Lista[1001];
       for (int i = 0; i < n; i++) {
		int x = leer.nextInt(),y=leer.nextInt();
		if(X[x]==null)X[x]=new Lista();
		if(Y[y]==null)Y[y]=new Lista();
		if(X[y]==null)X[y]=new Lista();
		if(Y[x]==null)Y[x]=new Lista();
		X[x].add(y); 
	    Y[y].add(x);
	    Punto A = new Punto(x, y);
	    P.push(A);
       }
       int h=-1;
       while(!P.isEmpty()){
    	   Punto A = P.pop();
    	   if(!X[A.x].V && !Y[A.y].V){
    		   h++;
    		   Recorrer(A);
    	   }
       }
       System.out.println(h);
    }
	}
	static class Punto{
		int x,y;
		public Punto(int a,int b){
			x=a;y=b;
		}
	}
	static class Nodo {
		int n;
		Nodo sig;
	    public Nodo (int x){
	    	n=x;sig=null;
	    }
	}
	static class Lista{
		boolean V;
		Nodo ini;
		public Lista(){
			ini=null;V=false;
		}
		public void add(int x){
			Nodo A = new Nodo(x);
			A.sig=ini;
			ini=A;
		}
	}
}
/*
2
2 1
1 2

2
2 1
4 1

4
1 3
1 1
3 1
3 3

4
1 3
3 1
1 1
3 3

24
171 35
261 20
4 206
501 446
961 912
581 748
946 978
463 514
841 889
341 466
842 967
54 102
235 261
925 889
682 672
623 636
268 94
635 710
474 510
697 794
586 663
182 184
806 663
468 459

17
660 646
440 442
689 618
441 415
922 865
950 972
312 366
203 229
873 860
219 199
344 308
169 176
961 992
153 84
201 230
987 938
834 815

7
429 506
346 307
99 171
853 916
322 263
115 157
906 924

20
1 1
2 2
3 3
3 9
4 4
5 2
5 5
5 7
5 8
6 2
6 6
6 9
7 7
8 8
9 4
9 7
9 9
10 2
10 9
10 10

*/
