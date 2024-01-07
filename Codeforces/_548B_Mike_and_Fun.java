import java.util.*;
public class _548B_Mike_and_Fun {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		int  m= leer.nextInt();
		int q = leer.nextInt();
		boolean  M[][]= new boolean[n+1][m+2];
		int L[]= new int[501];
		TreeSet<Integer> T = new TreeSet<Integer>();
		for (int i = 1; i <=n; i++){int c =0;
			for (int j = 1; j <=m; j++){
                if(leer.nextInt()==1){M[i][j]=true;
                c++;
                }
                else {if(L[c]==0)T.add(c);L[c]++;c=0;}
			}
			if(L[c]==0)T.add(c);L[c]++;
		}
		for (int i = 0; i < q; i++){
			int x = leer.nextInt();
			int y = leer.nextInt();
			int l=y-1,r=y+1;
			M[x][y]=!M[x][y];
			while(M[x][l]||M[x][r]){
				if(M[x][l])l--;
				if(M[x][r])r++;
			}
			r=r-y-1;
			l=y-l-1;
			if(M[x][y]){
				y=r+l+1;
				L[r]--;
				L[l]--;
				if(L[r]==0)T.remove(r);
				if(L[l]==0)T.remove(l);
				if(L[y]==0)T.add(y);
				L[y]++;
			}
			else{
				y=r+l+1;
				L[y]--;
				if(L[y]==0)T.remove(y);
                if(L[r]==0)T.add(r);
				if(L[l]==0)T.add(l);
				L[r]++;
				L[l]++;
			}
			System.out.println(T.last());
		}
	}
}
