import java.util.*;
public class _475B_Strongly_Connected_City {

	public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        int m = leer.nextInt();
        String F = leer.next();
        String C = leer.next();
        char a=F.charAt(0),b=F.charAt(n-1),c=C.charAt(0),d=C.charAt(m-1);
        if(a=='>'&&d=='v'&&b=='<'&&c=='^' || a=='<'&&c=='v'&&b=='>'&&d=='^')System.out.println("YES");
        else System.out.println("NO");
	}

}
/*
3 3
><>
v^v
4 6
<><>
v^v^v^


*/