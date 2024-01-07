import java.util.*;
public class _560B_Gerald_is_into_Art {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int a1= leer.nextInt(),b1=leer.nextInt();
		int a2= leer.nextInt(),b2=leer.nextInt();
		int a3= leer.nextInt(),b3=leer.nextInt();
        if(a2+a3<=a1&&Math.max(b2,b3)<=b1||a2+b3<=a1&&Math.max(a3,b2)<=b1||b2+a3<=a1&&Math.max(a2,b3)<=b1||b2+b3<=a1&&Math.max(a2,a3)<=b1
          ||a2+a3<=b1&&Math.max(b2,b3)<=a1||a2+b3<=b1&&Math.max(a3,b2)<=a1||b2+a3<=b1&&Math.max(a2,b3)<=a1||b2+b3<=b1&&Math.max(a2,a3)<=a1)System.out.println("YES");
        else System.out.println("NO");
	}
}
