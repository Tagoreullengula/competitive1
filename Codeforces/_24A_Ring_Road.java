import java.util.*;
public class _24A_Ring_Road {
static int n,s,q;
static Grafo M[];
static boolean V [];
    public static void Recorrer(int i,int ant){
      if(!V[i]){
      V[i]=true;
      if(M[i].c1!=ant)
      {s=s+M[i].p1;
      Recorrer(M[i].c1,i);
      q=q+M[i].p2;
      }
      else{
      s=s+M[i].p2;
      Recorrer(M[i].c2,i);
      q=q+M[i].p1; 
      }
      }
    }
    
	public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
    
    	 n = leer.nextInt();
    	 M= new Grafo [n+1];
    	 for (int i = 1; i <=n; i++) 
			M[i]= new Grafo();
		for (int i = 0; i < n; i++) {
			int x = leer.nextInt();
			int y= leer.nextInt();
			int z = leer.nextInt();
			M[x].add(y,0);
			M[y].add(x,z);
		}
		V= new boolean [n+1];
		s=0;q=0;
		Recorrer(1,0);
		if(s<q)System.out.println(s);
		else System.out.println(q);
    

	}
	static class Grafo{
		int c1,c2,p1,p2;
        public Grafo(){
               c1= -1;c2=-1;p1=-1;p2=-1;
        }
	    public void add(int x , int p){
	    	if(c1==-1){c1=x;p1=p;}
	    	else{c2=x;p2=p;}
	    }
	}
}

/*
4
1 2 9
2 3 8
3 4 7
4 1 5 

6
1 5 4
5 3 8
2 4 15
1 6 16
2 3 23
4 6 42

3
1 3 1
1 2 5
3 2 1

3
1 3 1
1 2 1
3 2 1

6
2 3 23
4 6 42
1 5 4
5 3 8
2 4 15
1 6 16
*/