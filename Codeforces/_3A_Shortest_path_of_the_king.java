import java.util.*;
public class _3A_Shortest_path_of_the_king {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		String xy = leer.next();
		String ab = leer.next();
		int x = xy.charAt(0)-96;
		int y = xy.charAt(1)-48;
		int a = ab.charAt(0)-96;
		int b = ab.charAt(1)-48;
		int c=0;
		LinkedList<String> P= new LinkedList<String>();
		int d1=Math.abs(a-x);
		int d2=Math.abs(b-y);
		while(x!=a || y!=b){
			c++;
			if(d1==d2){
				if(a>x && b>y){P.add("RU");x++;y++;}
				if(a>x && b<y){P.add("RD");x++;y--;}
				if(a<x && b>y){P.add("LU");x--;y++;}
				if(a<x && b<y){P.add("LD");x--;y--;}
			}
			else{
				if(d1>d2){
					if(x>a){x--;
					P.add("L");
					}
					else {x++;P.add("R");}
				    d1--;
				}
				else{
					if(y>b){
						y--;
						P.add("D");
					}else{
						y++;
						P.add("U");
					}
				d2--;
				}
			}
		}
		System.out.println(c);
		while(!P.isEmpty()){
			System.out.println(P.remove());
		}
	}

}
