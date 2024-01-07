import java.util.*;
public class _535B_Tavas_and_SaDDas{
	public static void main(String[] args){
		Scanner leer = new Scanner (System.in);
		char n[] = leer.next().toCharArray();
		int d=1;
		int res=0;  
	    for (int i = n.length-1; i>=0; i--){
	    	if(n[i]=='7')
		    res+=d;
	    	d=d<<1;
	    }
	    res+=d-1;
	    System.out.println(res);
	}
}
/*
4
7
77
74
444
474
447
747
774
777
777777777
444444444
444444444444
*/
