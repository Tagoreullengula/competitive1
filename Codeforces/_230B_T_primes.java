import java.util.*;
public class _230B_T_primes{
static long P[];
public static void Criba(){
	P[0]=-1;
	P[1]=-1;
	P[2]= 1;
	P[4]= 2;
	for(int i = 6; i <1000001 ; i+=2){
		P[i]=-1;
	}
	long j;
	for (long i = 3; i < 1000001; i+=2) {
		j=i*i;
		
		if(P[(int)i]==0){
			P[(int)i]=1;
			if(j<1000001){
			  P[(int)j]=2;
			  long h = i*2;
			  j+=h;
			  while(j<1000001){
				  P[(int)j]=-1;j+=h;
			  }
			  }
		}
	}
}
	public static void main(String[] args) {
		P= new long[1000001];
		Scanner leer = new Scanner(System.in);
		Criba();
        while(leer.hasNext()){
        	long n = leer.nextInt();
        	for (long xd = 0; xd < n; xd++) {
				long x = leer.nextLong();
				if(x>1000001){
					double y = Math.sqrt(x);
					if(y==(int)y && P[(int)y]==1){System.out.println("YES");}
					else System.out.println("NO");
				}else{
					if(P[(int)x]==2)System.out.println("YES");
					else System.out.println("NO");
				}
					
			}
        	
        }
	}
}
