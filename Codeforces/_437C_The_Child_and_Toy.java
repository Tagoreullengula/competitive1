import java.util.*;
public class _437C_The_Child_and_Toy {
	static Lista P[];
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		int m = leer.nextInt();
        P= new Lista[n+1];
        for (int i = 1; i<=n; i++){
		    P[i]=new Lista(leer.nextInt());	
		 }
		for (int i = 0; i < m; i++) {
			int x = leer.nextInt(),y=leer.nextInt();
			P[x].add(y);
			P[y].add(x);
			P[x].c+=P[y].n;
			P[y].c+=P[x].n;
			P[x].a+=P[x].n;
			P[y].a+=P[y].n;
		}
		int s=0;
		for (int i = 1; i <n; i++){
		      int min=1;  
			for (int j = 1; j <=n; j++){
			   if(P[j].p){
			      if(P[j].a>=P[j].c){
			    	  if(P[j].d==-1)P[j].d=P[j].a-P[j].c;
			          if(P[j].d>P[min].d){
			        	  min=j;
			          }else {
			        	  if(P[j].d==P[min].d){
			        		  if(P[j].c<P[min].c)min=j;
			        	  }
			          } 
			      }
			   }
			}
			Nodo A = P[min].ini;
			while(A!=null){
				if(P[A.n].p){
					P[A.n].c-=P[min].n;
					P[A.n].a-=P[A.n].n;
					P[A.n].d=-1;
				}
				A=A.sig;
			}
			s=s+P[min].c;
			P[min].d=-1;
			P[min].p=false;
		}
		System.out.println(s);
	}
	static class Nodo {
		int  n;
		Nodo sig;
		public Nodo (int x){
			n=x;sig=null;
		}
	}
	static class Lista {
		Nodo ini;
		int n,c,a,d;
		boolean p;
		public Lista(int x){
			ini=null;
			n=x;c=0;a=0;d=-1;
			p=true;
		}
		public void add(int x){
			Nodo A = new Nodo(x);
	        A.sig=ini;
	        ini=A;
		}
	}
}

/*
4 4
100 100 100 100
1 2
2 3
2 4
3 4

4 3
10 20 30 40
1 4
1 2
2 3

7 10
40 10 20 10 20 80 40
1 5
4 7
4 5
5 2
5 7
6 4
1 6
1 3
4 3
1 4

1 0
23333

5 4
1 2 2 2 2
1 2
1 3
1 4
1 5

10 30
3 6 17 15 13 15 6 12 9 1
3 8
1 10
4 7
1 7
3 7
2 9
8 10
3 1
3 4
8 6
10 3
3 9
2 3
10 4
2 10
5 8
9 5
6 1
2 1
7 2
7 6
7 10
4 8
5 6
3 6
4 1
8 9
7 9
4 2
5 10

3 3
1 1 1
1 2
2 3
3 1


*/
