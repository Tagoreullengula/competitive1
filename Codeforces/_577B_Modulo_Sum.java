import java.util.*;
public class _577B_Modulo_Sum {
	public static void main(String[] args) {
	 Scanner leer = new Scanner(System.in);
	 int n = leer.nextInt();
	 int m = leer.nextInt();
	 boolean M[]= new boolean[m];
	 LinkedList<Integer> ms= new LinkedList<Integer>(),c;
	 ms.add(0);
	 for (int i = 0; i < n&&!M[0]; i++){
		 long a = leer.nextLong()%m;
		 c=(LinkedList<Integer>)ms.clone();
	     while(!c.isEmpty()&&!M[0]){
		     int  h= (c.remove()+(int)a)%m;
		     if(!M[h]){
		    	 M[h]=true;
		    	 ms.add(h);
		     }
		 }
	     if(!M[(int)a]){ms.add((int)a);M[(int)a]=true;}
	 }
     if(M[0])System.out.println("YES");
     else System.out.println("NO");
	}
}