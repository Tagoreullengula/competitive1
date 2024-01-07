import java.util.*;
public class _569B_Inventory {
   public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		StringBuilder r = new StringBuilder();
		int n =leer.nextInt();
		boolean V [] = new boolean[n+1];
		LinkedList<Integer> A = new LinkedList<Integer>();
		int a;
		for (int j = 0; j < n; j++){
			 a=leer.nextInt();
			if(a<=n)V[a]=true;
			A.add(a);
		}
		LinkedList<Integer> C = new LinkedList<Integer>();
        for (int i = 1; i <=n; i++)
			if(!V[i])C.add(i);
        V= new boolean[n+1];
		while(!A.isEmpty()){
			a=A.remove();
			if(a<=n&&!V[a]){
				r.append(a+" ");
				V[a]=true;
			}else r.append(C.remove()+" ");
		}
		System.out.print(r);
	}
}
