import java.awt.Point;
import java.util.*;
import java.util.Map.Entry;
public class _579B_Finding_Team_Member {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();	
		TreeMap<Integer, Point> T = new TreeMap<Integer, Point>();
		int d=n<<1;
		Point p;
		for (int i = 2; i <=d; i++){
			for (int j = 1; j < i; j++){
				p= new Point(i,j);
				T.put(leer.nextInt(), p);
			}
		}
		int res[]= new int[d+1];
		while(n>0){
			Entry<Integer, Point> K= T.pollLastEntry();
			p=K.getValue();
			int x=(int)p.getX(),y=(int)p.getY();
			if(res[x]==0 && res[y]==0){
				n--;res[x]=y;res[y]=x;
			}
		}
		for (int i = 1; i <=d; i++) {
			System.out.print(res[i]+" ");
		}
	}
}
