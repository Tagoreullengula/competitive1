import java.util.*;
public class _547B_B_Mike_and_Feet{
	public static void main(String[] args){
    Scanner leer = new Scanner(System.in);
 	int n = leer.nextInt();
 	long o[]= new long[n+1];
 	for (int i = 1; i <=n; i++){o[i]=leer.nextLong();}
 	LinkedList<Integer> P= new LinkedList<Integer>();
 	int l[]= new int[n+1];
 	int r[]= new int[n+1];
 	for (int i = 1; i <=n; i++){
		while(!P.isEmpty()&&o[P.getFirst()]>=o[i])
			P.pop();
		if(P.isEmpty())l[i]=0;
		else l[i]=P.getFirst();
		P.push(i);
	}
 	P=new LinkedList<Integer>();
 	for (int i = n; i >0; i--){
		while(!P.isEmpty()&&o[P.getFirst()]>=o[i])
			P.pop();
		if(P.isEmpty())r[i]=n+1;
		else r[i]=P.getFirst();
		P.push(i);
	}
 	long Res[]= new long[n+1];
 	for (int i = 1; i <=n; i++){
        int p= r[i]-l[i]-1;        
        Res[p]=Math.max(Res[p], o[i]);
	}
	long h=0;
	StringBuilder q = new StringBuilder();
 	for (int i = n; i >0; i--){
	   if(Res[i]>h)h=Res[i];
	   o[i]=h;
 	}
 	for (int i = 1; i <=n; i++) 
		q.append(o[i]+" ");
	System.out.println(q);
	}
}

/*
10
1 2 3 4 5 4 3 2 1 6

3
524125987 923264237 374288891

1
7

2 
4 5

2 
3 3


8
3 5 4 1 7 2 4 3


*/