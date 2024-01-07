import java.util.*;
public class _520B_Two_Buttons {
	public static void main(String[] args) {
          Scanner leer = new Scanner(System.in);
          int n = leer.nextInt(),m=leer.nextInt();
          int p =0,d=m&1,c=0;
          while(true){
        	  if(m>n){
        		  d=m&1;
        		  if(d==0)
        			  m=m/2;
        		  else
        			  m=m+1;
        		  c++;
        	  }
        	  else{
        		 p=n-m+c;break; 
        	  }
          }
         System.out.println(p);
	}

}
/*
10 1
4 6
4 8
5 4
7 7
1 10000
23 46
23 28
23 21
23 34
23 25
23 45
23 89



*/