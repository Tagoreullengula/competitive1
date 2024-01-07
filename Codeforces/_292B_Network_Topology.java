import java.util.*;
public class _292B_Network_Topology {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		int m = leer.nextInt();
		int C[] = new int [n+1];
		for (int i = 0; i <m; i++) {
			int a = leer.nextInt();
			int b = leer.nextInt();
			C[a]++;C[b]++;
		}
        boolean b=true,r=true,s=true;
        int c1=0;
        int cn=0;
		for (int i = 1;i<=n&&(r||s||b); i++) {
			r=r&&C[i]==2;
		    if(C[i]==1){c1++;
		       b=b&&c1<=2;
		    }else b=b&&C[i]==2;
		    if(C[i]==n-1){cn++;
		    s=s&&cn==1;
		    }else s=s&&C[i]==1;
		}
		b=b&&c1==2;
		if(!b){
			if(!r){
				if(!s)
					System.out.println("unknown topology");
				else System.out.println("star topology"); 
			}else System.out.println("ring topology");
		}else System.out.println("bus topology");
	}

}
/*
4 3
1 2
2 3
3 4

4 4
1 2
2 3
3 4
4 1

4 3
1 2
1 3
1 4

4 4
1 2
2 3
3 1
1 4

*/