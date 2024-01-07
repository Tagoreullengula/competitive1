import java.util.*;

//funciona pero hay que optimizar

public class _493E_Vasya_and_Polynomial {
	static Scanner leer;
	public static void main(String[] args) {
	  leer = new Scanner(System.in);
	  while(leer.hasNext()){
		  long t =leer.nextLong(),a=leer.nextLong(),b=leer.nextLong();
		  String cad="";
		  int c=0;
		  if(a==b)c++; // para polinomnios constantes 
		  if(t>1){
			  if(b>=a && a>=t){
				   long p=0,q=1,k=b,x;
			       while(k>0){x=k;k=0;
			    	   while(x>=a){x=x-a;k++;}
			    	   p+=x*q;q=q*t;
			       }
			       if(p==a)c++;
			  }
		  }
		  if(t==1){
				  if(a!=1&&b!=1){ // para polinomios 1 n m  con     n>1 && m>1
					  if(b>a){   // para m>n
                           long s = 0;
                           while(b>0){
                        	   s=s+b%a;
                        	   b=b/a;
                           }if(s==a || s==1) c++;
					  }
				  }// para polinomios 1 1 n  || 1 n 1 que podrian ser "0" o "inf"
				  else{if(c==1)c=-1;}
		  }
		  if(c==-1)cad="inf";
		  else cad=c+"";
		  System.out.println(cad);
	  }
	}
}
