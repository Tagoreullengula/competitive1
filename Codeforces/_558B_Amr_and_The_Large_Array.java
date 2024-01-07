import java.util.*;
public class _558B_Amr_and_The_Large_Array {
	public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
    int n = leer.nextInt();
    int v[][]= new int [1000001][3];
    int max =0;
	int a=0,b=0;
     for (int i = 1; i <=n; i++){
		int h = leer.nextInt();
		if(v[h][0]==0)v[h][1]=i;
		v[h][2]=i;
		v[h][0]++;
		if(v[h][0]>max||v[h][0]==max&&b-a>v[h][2]-v[h][1]){
			max=v[h][0];
			a=v[h][1];
			b=v[h][2];
		}
     }
     System.out.println(a+" "+b);
	}
}
