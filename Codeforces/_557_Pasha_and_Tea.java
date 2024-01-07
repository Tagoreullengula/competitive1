import java.util.*;
import java.util.Map.Entry;
public class _557_Pasha_and_Tea {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		long w = leer.nextLong();
		long T[]= new long[n<<1];
		for (int i = 0; i < n<<1; i++){
            T[i]= leer.nextLong();
		}
				  Arrays.sort(T);
				  double r;
				  if(T[n]<=T[0]<<1)
					  r=n*T[n]*1.5;
				  else r =n*T[0]*3;
				  if(r>w)r=w;
		System.out.println(r);
	}
}

/*

1 5
2 3

3 18
4 4 4 2 2 2

2 4
1 1 1 1


2 1000000000 
1 1 1 1000000000 

3 13
1 1 7 7 4 4

*/