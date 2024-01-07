import java.util.*;
public class _552B_Vanya_and_Books {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		long n = leer.nextLong();
		int c =1;
		long h =9,s=0,r;
		while(n>0){
			if(n<h)
				h=n;
			s+=h*c;
			n-=h;
			h=h*10;
			c++;
		}
		System.out.println(s);
	}
}
