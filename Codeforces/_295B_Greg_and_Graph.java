import java.util.*;
public class _295B_Greg_and_Graph {
	static int M[][];
	public static void main(String[] args){
		Scanner leer = new Scanner (System.in);
        int n = leer.nextInt();
        M= new int [n+1][n+1];
        for (int i = 1; i <=n; i++){
			for (int j = 1; j <=n; j++){
				M[i][j]= leer.nextInt();
			}
		}
        LinkedList<Integer> P = new LinkedList<Integer>();        
        for (int i = 0; i < n; i++)
			P.push(leer.nextInt());
        
        LinkedList<Long>S= new LinkedList<Long>();
        boolean V[]= new boolean[n+1];
        while(!P.isEmpty()){
        	int p = P.pop();V[p]=true;
        	long s =0;
        	for (int i = 1; i <=n; i++) {
				for (int j = 1; j <=n; j++) {
					int h = M[i][p]+M[p][j];
					if(h<M[i][j])M[i][j]=h;
					if(V[i]&&V[j])s=s+M[i][j];
				}
			}
        	S.push(s);
        }
       while(!S.isEmpty())
    	   System.out.print(S.pop()+" ");
	}
}


/*

1
0
1

2
0 5
4 0
1 2

4
0 3 1 1
6 0 400 1
2 4 0 1
1 1 1 0
4 1 2 3

4
0 57148 51001 13357
71125 0 98369 67226
49388 90852 0 66291
39573 38165 97007 0
2 3 1 4

*/


