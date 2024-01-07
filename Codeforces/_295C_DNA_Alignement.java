import java.util.*;
public class _295C_DNA_Alignement {
static int P[],R[],S[];
static int res,n;
static int a,c,g,t,r;
public static int Calcula(int i){
	int y =0;
	if(i<n){
		R[i]=R[i-1]*2;
	while(R[i]<=R[i+1]){
		S[i]=R[i]-R[i-1];
		Calcula(i+1);
		R[i]++;
	}
	}else {
		S[i]=R[i]-R[i-1];
	}
	return y;
}
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		n = leer.nextInt();
		String cad = leer.next();
		res=0;
		P=new int[n+1];
		P[0]=1;
		
		for (int i = 1; i <=n; i++) {
			P[i]=((i%1000000007)+P[i-1])%1000000007;
		}
		int y=0;
		for (int i = 0; i < n; i++) {
			char x = cad.charAt(i);
			if(x!='A'){
			if(x!='C'){
				if(x!='G'){
					t++;
				}else g++;
			}
			else c++;
			}
			else a++;
		}
		r=0;
		if(a>=g && a>=c && a>=t)r++;
		if(g>=a && g>=c && g>=t)r++;
		if(c>=g && c>=a && c>=t)r++;
		if(t>=g && t>=c && t>=a)r++;
		R = new int[r+1];
		R[r]=n;
		//i=1;
	}
}
//AGCGAATCCCATTGT
