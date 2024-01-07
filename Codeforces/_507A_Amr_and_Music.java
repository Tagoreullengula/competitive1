import java.util.*;
public class _507A_Amr_and_Music{
	public static void main(String[] args) {
       Scanner leer = new Scanner (System.in); 
       int n = leer.nextInt();
       int m = leer.nextInt();
       int v []= new int [n+1];
       int h []= new int [n+1];
       for (int i = 1; i <=n; i++) {
		v[i]=leer.nextInt();
		h[i]=i;
	    int k = i;
	    while(k>1){
	    	if(v[k]<v[k-1]){
	    		int aux = v[k];v[k]=v[k-1];v[k-1]=aux;
	    		aux=h[k];h[k]=h[k-1];h[k-1]=aux;k--;
	    	}else break;
	    }
       }
        int l=1;
        while(l<v.length){
        m=m-v[l];
        if(m<0)break;	
        l++;
        }  
        System.out.println(l-1);
        for (int i = 1; i<l; i++) {
			System.out.print(h[i]+" ");
		}
	}
}

/*
4 10
4 3 1 2

5 6
4 3 1 1 2

1 3
4
*/
