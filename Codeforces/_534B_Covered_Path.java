import java.util.*;
public class _534B_Covered_Path {
static int V[];
static int t,d;
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int v1=leer.nextInt();
		int v2=leer.nextInt();
		t=leer.nextInt();
		d=leer.nextInt();
		V= new int [t];
		V[0]=v1;
		V[t-1]=v2;
		int res=v1;
		for (int i = 0; i < t-2; i++)
			V[i+1]=V[i]+d;
		for (int i = t-1; i>0 ; i--) {
			if(V[i-1]-V[i]>d)
				V[i-1]=V[i]+d;
			
			res+=V[i];
		}
  
		System.out.println(res);

	}

}
/*
5 6
4 2

10 10
10 0

5 4
5 2

10 5
5 2

*/