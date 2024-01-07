import java.util.*;
import java.io.*;
public class _154B_Physics_Practical{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner leer = new Scanner(new File("input.txt"));
		int n = leer.nextInt();
		int V[]= new int[10001];
		int K[]= new int[10001];
	    TreeSet<Integer>C= new TreeSet<Integer>();
	    for (int i = 0; i < n; i++){
	    	int c = leer.nextInt();
			C.add(c);
			K[c]++;
		}
       int f=C.first(),l=C.last(),h=K[l];
       for (int i=l-1;i>f; i--){
		 V[i]=h;
		 h=h+K[i];
	   }
       int min=1000000;
       int i = 0,c;
       while(!C.isEmpty()){
    	   c=C.pollFirst();
		   min=Math.min(min,V[c<<1]+i);
		   i=i+K[c];
	   }
       PrintWriter S = new PrintWriter("output.txt");
       S.println(min+"");S.close();
	}
}
