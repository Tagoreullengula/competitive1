import java.util.*;
public class _463D_Gargari_and_Permutations{
static int n ,k,V[],max,P[][],R[];

public static int Subsecuencia(int ant){
		if(R[ant]==0){
			int i=ant+1;
			R[ant]=1;
			while(i<n){
		    boolean r=true;
		 	 for (int j2 = 1; j2 <k && r; j2++){
		     	r=P[j2][V[ant]]<P[j2][V[i]];
		 	 }
			 R[i]=Subsecuencia(i);
			 if(R[i]>=R[ant]&&r){
				 R[ant]=R[i]+1;
			 }i++;
			 }
           
		}
		if(R[ant]>max)max=R[ant];
	return R[ant];
}



   public static void main(String[] args){
		Scanner leer = new Scanner(System.in);
		while(leer.hasNext()){
			n=leer.nextInt();
			k=leer.nextInt();
			P= new int[k][n+1];
			R= new int[n];
			V= new int[n];
			for (int i = 0; i < n; i++) {
				V[i]=leer.nextInt();
			}
			for (int i = 1; i <k; i++) {
				for (int j = 1; j <=n; j++) {
					P[i][leer.nextInt()]=j;
				}
			}
		
			max=0;
			Subsecuencia(0);
			System.out.println(max);
  		}
	}
}
/*
3 2
1 3 2
2 1 3

4 3
1 4 2 3
4 1 2 3
1 2 4 3

7 2
2 3 4 7 6 5 1
1 3 5 4 6 7 2

7
2
1 3 5 4 6 7 2
2 3 4 7 6 5 1

4 4
2 3 4 1
1 4 2 3
4 1 2 3
1 2 4 3

9
5
1 2 3 4 5 6 7 8 9
2 4 6 8 1 3 5 7 9
1 3 5 7 9 2 4 6 8
1 2 3 4 5 6 9 8 7
1 2 3 4 5 6 7 9 8

9 2
1 3 5 7 9 2 4 6 8
2 4 6 8 1 3 5 7 9

66 2
46 64 35 28 65 51 6 50 47 41 58 3 14 52 61 13 25 63 54 17 19 4 39 62 55 56 30 34 26 2 22 27 11 42 12 36 44 49 9 32 45 29 20 7 60 21 5 33 37 57 15 48 38 53 23 31 18 66 43 8 16 59 1 10 40 24
8 36 20 65 42 14 47 57 23 1 64 53 54 4 61 43 29 62 18 3 30 58 6 33 32 41 37 40 28 17 45 39 24 15 44 16 51 56 46 7 48 66 38 59 60 25 34 50 11 22 27 9 52 21 13 63 5 10 12 55 19 26 31 49 2 35


*/
