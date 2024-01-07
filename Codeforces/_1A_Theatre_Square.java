import java.util.*;
public class _1A_Theatre_Square {
   public static void main(String[] args){
	   Scanner leer = new Scanner(System.in);
	   while(leer.hasNext()){
		   long n =leer.nextLong(),m=leer.nextLong(),a=leer.nextLong();
		   long res = ((m+a-1)/a)*((n+a-1)/a);
		   System.out.println(res);
	   }
   }
}
