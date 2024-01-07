import java.util.*;
public class _488B_Candy_Boxes_2 {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		int A[] = new int[4];
		int min=0,max=0;
	    for (int i = 0; i < n; i++) {
				A[i]=leer.nextInt();
				if(A[i]<A[min])min=i;
				if(A[i]>A[max])max=i;
		}
	    int maxp=A[min]*3;
	    boolean r= maxp>=A[max];
	    LinkedList<Integer> R = new LinkedList<Integer>();
	    if(n==0&&r){R.add(1);R.add(1);R.add(3);R.add(3);}
	    if(n==1&&r){R.add(A[0]);R.add(maxp);R.add(maxp);}
	    if(n==2&&r){max=A[max];
	    	min=A[min]+maxp-max;
	    	if(min>maxp){R.add(maxp);R.add(min);}
	    	else {R.add(min);R.add(maxp);}
	    }
	    if(n==3&&r){
	    	Arrays.sort(A);
	    	min=A[1];
	    	max=A[3];
	    	if(maxp!=max){
	    	r=maxp+min==A[3]+A[2];
	    	if(!r){int minp=max/3;
	    		r=max%3==0&&minp+max==A[2]+min;
	    		if(r)R.add(minp);
	    	}
	    	else R.add(maxp);
	    	}else R.add(maxp+min-A[2]);
	    }
	    if(n==4&&r){Arrays.sort(A);
	    	r=A[0]+A[3]==A[1]+A[2]&&maxp==A[3];
	    }
        if(r){
        	System.out.println("YES");
        	while(!R.isEmpty()){
        		System.out.println(R.remove());
        	}
        }
        else System.out.println("NO");
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
*/