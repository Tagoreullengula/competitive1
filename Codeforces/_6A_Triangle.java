import java.util.*;
public class _6A_Triangle {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int a = leer.nextInt();
		int b = leer.nextInt();
		int c = leer.nextInt();
		int d = leer.nextInt();
        int ab=a+b,ac=a+c,ad=a+d,bc=b+c,bd=b+d,cd=c+d;
        if(ab>c&&ac>b&&bc>a || ab>d&&ad>b&&bd>a || ac>d&&ad>c&&cd>a || bc>d&&cd>b&&bd>c){
        System.out.println("TRIANGLE");	
        }else {
        	if(ab==c ||ab==d || ac==b || ac==d || ad==b || ad==c || bc==a || bc==d || bd==a || bd==c || cd==a || cd==b){
        		System.out.println("SEGMENT");
        	}else System.out.println("IMPOSSIBLE");
        }
	}

}
/*
4 2 1 3
7 2 2 4
3 5 9 1
*/