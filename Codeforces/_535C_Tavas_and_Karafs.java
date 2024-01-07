import java.util.*;
public class _535C_Tavas_and_Karafs {
	static long mor,S[];
	static int I[],l,t,m,A,B,li,ls,r,h;
	public static void Calcula(){
		if(li<=ls){
			int i = (li+ls)/2;
			
			if(S[i]==0){S[i]=B;S[i]*=i;S[i]*=(i-1);S[i]/=2;S[i]+=(long)(i*A);}
			long s = S[i]-S[l]+h;
			if(s!=mor){
				if(s<mor){
					long e=(long)(A+i*B);
					s+=e;
					if(s<=mor && e<=t){
						li=i+1;Calcula();
					}
					else r=i;
				}else{
					ls=i;Calcula();
				}
			}else r=i;
		}else r=-1;
	}
	public static void main(String[] args){
       Scanner leer = new Scanner(System.in);
       A = leer.nextInt();
       B = leer.nextInt();
       int n = leer.nextInt();
       S= new long[1000001];
       I= new int[1000001];
       for (int i = 0; i < n; i++){
		   l = leer.nextInt();
		   t = leer.nextInt();
		   m = leer.nextInt();
		   mor=t;mor*=m; 
		   li=l;
		   h=A+(l-1)*B;
		   if(I[t]==0)
	    	   I[t]=(t-A)/B+1;
		   ls=I[t];
		   if(S[l]==0){S[l]=B;S[l]*=l;S[l]*=(l-1);S[l]/=2;S[l]+=(long)(l*A);}	
		   Calcula();
	       System.out.println(r);
	
       }

	}

}
/*
2 1 4
1 5 3
3 3 10
7 10 2
6 4 8  
 
1 5 2
1 5 10
2 7 4
 

1000000 1000000 1
1 1000000 1000000 
 
1 1 1
1 1000000 1000000

1 1 1
1000000 1000000 1000000

2 3 5
49529 164864 8367
168383 521372 25974
92947 647140 224508
666308 383786 762392
271927 782286 704448

2 3 1
148990 913922 18257

*/
