import java.util.*;
public class _495B_Modular_Equations {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		
		long a = leer.nextLong();
		long b = leer.nextLong();
		if(a!=b){
			long c=0;
			long res =a-b;
			if(res>b){
			long x=1;
				while(true){
				    double d = res;
				    d/=x;
				    if(d>=x){
				    long D=(long)d;
				    if(D==d){
				    	if(d>b){
				           if(x!=D)c++;
				           if(x>b)c++;
				    }else break;
				    }
				    x++;
                }else break;
			  }
			}
				System.out.println(c);
		}else System.out.println("infinity");

	}
}
/*
24 0
1000000000 999999999
24 6

21 5
9435152 272
10 10
26 1
1000000000 0
37 7
34 65
25 12 
25 1
*/