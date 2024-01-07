import java.util.*; 
public class _500A_New_Year_Transportation {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        int t = leer.nextInt();
        int s = 1;
        boolean p=false;
        for (int i = 1; i < n; i++) {
	        int a = leer.nextInt();
	        if(i==s&&s<t)
	        	s=s+a;
	        p=t==s||p;
		}
        if(p)System.out.println("YES");
        else System.out.println("NO");
	}
}
/*
8 4
1 2 1 2 1 2 1
8 5
1 2 1 2 1 1 1
4 4

2 2 1
*/