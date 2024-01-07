import java.util.*;
public class _330B_Road_Construction {

	public static void main(String[] args) {
		Scanner leer = new Scanner (System.in);
		while(leer.hasNext()){
			int n = leer.nextInt();
			 int m = leer.nextInt();
			 boolean V[] = new boolean[n+1];
			for (int i = 0; i < m; i++) {
				V[leer.nextInt()]=true;
				V[leer.nextInt()]=true;
			}
			int i = 1;
			while(V[i]){i++;}
			System.out.println(n-1);
			for (int j = 1; j <= n; j++) {
				if(i!=j)System.out.println(j+" "+i);
			}
		}

	}

}
/*
4 1
1 3
*/
