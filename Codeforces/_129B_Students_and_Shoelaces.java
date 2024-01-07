import java.util.*;
public class _129B_Students_and_Shoelaces {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		while(true){
			int n= leer.nextInt();
			int m= leer.nextInt();
			Lista A []= new Lista[n+1];
			int N [] = new int [n+1];
			for (int i = 1; i <=n; i++) 
				A[i]=new Lista();
			for (int i = 0; i < m; i++) {
				int x = leer.nextInt();
				int y = leer.nextInt(); 
				A[x].add(y);
				A[y].add(x);
				N[x]++;N[y]++;
			}
			Lista P;
			int h=0;
			boolean Visitados[]= new boolean [n+1];
			while(true){P=new Lista();
				for (int i = 1; i <=n; i++) {
					if(N[i]==1 && !Visitados[i]){P.add(i);Visitados[i]=true;}
				}
				Nodo C = P.ini;
				if(P.n>0){
				while(C!=null){
				      Nodo T = A[C.n].ini;
				      while(T!=null){
				    	  N[T.n]--;
				    	  T=T.sig;
				      }
				      C=C.sig;
				}
				}else break;
				h++;
			}
			System.out.println(h);
		}
	}
	
	static class Nodo{
		int n;
		Nodo sig;
		public Nodo(int x){
			n=x;
			sig=null;
		}
	}
	
	static class Lista{
		Nodo ini;
		int n;
		public Lista(){
			ini=null;n=0;
		}
		public void add(int x){
			Nodo A = new Nodo(x);
			A.sig=ini;
			ini=A;
			n++;
		}
	}

}
/*
6 5
1 4
2 4
3 4
5 4
6 4 

6 3
1 2
2 3
3 4 
 
3 3
1 2
2 3
3 1 
 
5 4
3 1
1 5
5 2
2 4

5 4
3 5
5 1
1 2
2 4

6 6
2 3
1 3
4 3
5 4
6 3
6 2

6 5
2 3
1 3
4 3
4 5
6 3

5 4
2 1
1 3
3 4
1 5

5 4
1 2
3 2
5 2
3 4
*/
