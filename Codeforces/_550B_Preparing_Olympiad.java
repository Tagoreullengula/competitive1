import java.util.*;
public class _550B_Preparing_Olympiad {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		long l=leer.nextLong();
		long r = leer.nextLong();
		int x = leer.nextInt();
		int c []= new int [n];
		for (int i = 0; i < n; i++) 
			c[i]= leer.nextInt();
		int res=0;
		long  t = (2<<(n-1))-1;
		while(t>1){
		int k=1;
		int min=Integer.MAX_VALUE,max=0,p=0;
		long d=0;
		for (int i = n-1; i >=0; i--){
			if((t&k)==k){p++;
			  if(c[i]<min)min=c[i];
			  if(c[i]>max)max=c[i];
			  d+=c[i];
			}
			k=k<<1;
		}
		if(p>=2&&d>=l&&d<=r&&max-min>=x)res++;
		t--;
		}
		System.out.println(res);
	}
}
