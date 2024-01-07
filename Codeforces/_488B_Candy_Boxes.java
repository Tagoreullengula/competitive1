import java.util.*;
public class _488B_Candy_Boxes{
	public static void main(String[] args) {
		Scanner leer = new Scanner (System.in);
		int n =leer.nextInt();
		int A[] = new int[4];
		int R[] = new int[501]; 
		for (int i = 0; i < 4; i++){
			if(i<n){
			A[i]= leer.nextInt();
			R[A[i]]++;
			
			}else A[i]=501;
		}   
        Arrays.sort(A);
        int min=1,max=3,maxp=3,minp=1;
        boolean M=true,m=true,r=true;
        if(n>0){min=A[0];max=A[n-1];maxp=max;
           minp=max/3;        
           M=max%3==0;
           m=min<=166;
           if(!M){minp++;maxp=minp*3;}
        }
        r=minp<=min&&maxp<=500;
        if(r){
            if(n==1){min=minp*4-max;
               if(min>max){int d=min;min=max;max=d;}
            }
        	if(n==2){
        		  if(!M&&!m){int d=max+min;
     			  minp=d/4;
     			  maxp=d-minp;
                  r=d%4==0&&maxp<=500;
     			  }else{
     				  if(M){
     					   max=minp*4-min;
     		               if(min>max){int d=min;min=max;max=d;}
     				  }
     				  else{
     					  r=maxp+minp==min+max;
     					  if(!r){
     					  maxp=min*3;
     					  minp=min;
     					  min+=maxp-max;
     					  if(min>max){int d=min;min=max;max=d;}
     					  r=true;
     					  }
     				  }
     			  }
        	}
        	if(n==3){
        		if(M){
        			if(minp!=min){
        				r=minp+max==min+A[1];
        				if(r)
        					max=A[1];
        			}else{
        				min=max+min-A[1];
        				max=A[1];
        				if(min>max){int d=min;min=max;max=d;}
        				}
        		}else{
        			r=minp==min&&maxp+minp==max+A[1];
        			if(r)
        				min=A[1];
        			else{
        				maxp=min*3;
        				minp=min;
        				min=A[1];r=maxp+minp==max+min;;
        			}
        		}
        	}
        	
        	if(n==4){
        		r=A[0]+A[3]==A[1]+A[2]&&A[0]*3==A[3];
        	}else {A[3]=maxp;A[0]=minp;A[1]=min;A[2]=max;}
        }
        if(r){
        	System.out.println("YES");
        	for (int i = 0; i < 4; i++){
        		
				if(R[A[i]]==0)System.out.println(A[i]);
				else R[A[i]]--;
			}
        }else System.out.println("NO");
        
	}

}
/*
2
1
1

4
1
2
2
3

3
1
1
1

2
3
9

1 
500

1 
1

1
498

1
499

1 
201

1
203

2 
1 2

2 
2 2

2
200 305

2 
150
305

1
494

4

4 
16
6 
7

4
18
6
12
12

2
12
12

3 
13 14 15

3
13 
7
15

3
16
6
7

3
16
6
8

3
16
6
17

3
1
2
2

3
1
2
3

3
2
2
3

3
184
100
71

Este ejercicio es especial, nos hizo pensar un monton para resolverlo, pensado que la respueta tenia que estar en un rango de1 a 500
pero resulta que el rango es de 1 a 1000000,  lo cual lo facilita enormemente.Aun  asi el codigo presentado resulve el dilema para
el rango equivocado, lo cual es digno de ser conservado, para la prueba los hechos, El codigo funciono hasta el test 32 donde ahi 
se difurco las respuetas para dicho caso.


*/
