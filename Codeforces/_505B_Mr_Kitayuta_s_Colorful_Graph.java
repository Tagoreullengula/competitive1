import java.util.*;
public class _505B_Mr_Kitayuta_s_Colorful_Graph{
static Lista A[];
static int x,y,c;
static boolean Encon;
    public static void  calcula(int i){
    	A[i].M[x][c]= true;
    	if(i!=y){
    	if(!A[i].t){  
    	A[i].t=true;
             if(!A[i].M[y][c]){
            	for (int j = 0; j < A[i].colour[c].size() && !Encon; j++){
					int h = A[i].colour[c].remove();
					A[i].colour[c].add(h);
					
					calcula(h);
				}
            	if(Encon)A[i].M[y][c]= true;
             }else{
            	 Encon=true;
             }
             A[i].t=false;
    	  }
    	}else 
    	Encon= true;
    }
	public static void main(String[] args){
     Scanner leer = new Scanner(System.in);
     int n = leer.nextInt();
     int m = leer.nextInt();
     A = new Lista[n+1];
     for (int i = 1; i <=n; i++) 
		A[i]= new Lista(n,m);
     
     for (int i = 0; i < m; i++){
		 x = leer.nextInt();
		 y = leer.nextInt();
		 c = leer.nextInt();
		 A[x].add(y);
		 A[y].add(x);
	 }    
     int q = leer.nextInt();
     for (int i = 0; i < q; i++){
		x= leer.nextInt();
		y= leer.nextInt();
	    int h;
	    if(y<x){h=y;y=x;x=h;}
	    h=0;
	    for (int j = 0; j < A[x].C.size(); j++){
			c = A[x].C.remove();
			A[x].C.add(c);
			Encon=false;
			calcula(x);
			if(Encon)h++;
		}
	    System.out.println(h);
     }
	}
	static class Lista{
		LinkedList<Integer> colour[];
		LinkedList<Integer> C;
		boolean M[][];
		boolean t;
		public Lista(int n, int m){
			colour= new LinkedList[m+1];
			M= new boolean[n+1][m+1];
			C= new LinkedList<Integer>();
			t = false;
		}
		public void add(int h){
			if(colour[c]==null)
			{	colour[c]= new LinkedList<Integer>();
			    C.add(c);
			}
			colour[c].add(h);
			M[h][c]=true;
		}
	}
}



/*
4 5
1 2 1
1 2 2
2 3 1
2 3 3
2 4 3
3
1 2
3 4
1 4

5 7
1 5 1
2 5 1
3 5 1
4 5 1
1 2 2
2 3 2
3 4 2
5
1 5
5 1
2 5
1 5
1 4

4 7 5 3 9
5 1 2 7 8 9 3 10

*/
