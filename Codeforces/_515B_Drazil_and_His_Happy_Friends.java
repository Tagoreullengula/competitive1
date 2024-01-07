import java.util.*;
public class _515B_Drazil_and_His_Happy_Friends {
static boolean H[],M[],hv[],mv[];
static int b,g,n,m,x,y,l;
static LinkedList<Integer>B,G;
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
        n = leer.nextInt();
        m = leer.nextInt();
        H= new boolean[n];
        M= new boolean[m];
        hv= new boolean[m];
        mv= new boolean[n];
        b=leer.nextInt();
        B= new LinkedList<Integer>();
        G= new LinkedList<Integer>();
        for (int i = 0; i < b; i++) {
			int x = leer.nextInt();
			H[x]=true;
			B.add(x);
		}
        x=n-b;
        g=leer.nextInt();
        for (int i = 0; i < g; i++){
			int x=leer.nextInt();
        	M[x]=true;
        	G.add(x);
		}
        y=m-g;
        l=0;
        int d;
        if(n>1&&m>1||b==0&&g==0){
        while(!B.isEmpty() || !G.isEmpty()){
        	if(l==0){
            while(!B.isEmpty()){
            	d=B.remove()%m;
            	while(!hv[d]){
            		hv[d]=true;
            		if(!M[d]){M[d]=true;
            		G.add(d);
            		y--;
            		}
            		d=(d+n)%m;
            	}
            }
        	}else{
        	    while(!G.isEmpty()){
        	    	d=G.remove()%n;
        	    	while(!mv[d]){
        	    	   mv[d]=true;
        	    	   if(!H[d]){H[d]=true;
        	    		   B.add(d);
        	    	   x--;
        	    	   }
        	    	   d=(d+m)%n;
        	    	}
        	    }
        	}
        l=1-l;
        }
        }else
        	x=y=0;
        if(x==0&&y==0)System.out.println("Yes");
        else System.out.println("No");
        
        
	}

}
/*
2 3
0
1 0
2 4
1 0
1 2
2 3
1 0
1 1
10000000 10000000
0
0
10000000 1
1 234
0
9 6
3 4 7 8
2 0 3



*/