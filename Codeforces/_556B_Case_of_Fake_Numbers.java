import java.util.*;
public class _556B_Case_of_Fake_Numbers {
	public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        boolean q = true;
        int x = n-leer.nextInt(),y;
        for (int i=1;i<n&&q;i++){
        	y=leer.nextInt();
			if((i&1)==1)
				q=(y+n-x)%n==i;
			else
			    q=(y+x)%n==i;
		}
        if(q)System.out.println("Yes");
        else System.out.println("No");
	}
}
