import java.util.*;
public class _437C_The_Child_and_Toy_2{
	public static void main(String[] args){
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		int m = leer.nextInt();
		int v[]= new int [n+1];
		for (int i = 1; i <=n; i++) 
			v[i]=leer.nextInt();
		long s = 0;
		
		for (int i = 0; i < m; i++) {
			s=s+Math.min(v[leer.nextInt()], v[leer.nextInt()]);
		}
      System.out.println(s);
	}
}
/*
4 4
100 100 100 100
1 2
2 3
2 4
3 4

4 3
10 20 30 40
1 4
1 2
2 3

7 10
40 10 20 10 20 80 40
1 5
4 7
4 5
5 2
5 7
6 4
1 6
1 3
4 3
1 4

1 0
23333

5 4
1 2 2 2 2
1 2
1 3
1 4
1 5

10 30
3 6 17 15 13 15 6 12 9 1
3 8
1 10
4 7
1 7
3 7
2 9
8 10
3 1
3 4
8 6
10 3
3 9
2 3
10 4
2 10
5 8
9 5
6 1
2 1
7 2
7 6
7 10
4 8
5 6
3 6
4 1
8 9
7 9
4 2
5 10

3 3
1 1 1
1 2
2 3
3 1


*/
