import java.util.*;
public class _554B_Ohana_Cleans_Up{
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        int M[][]= new int [n][n];
        TreeMap<String, Integer> T = new TreeMap<String, Integer>();
        int max =0;
        for (int i = 0; i < n; i++){
			String cad = leer.next(),c="";
			for (int j = 0; j < n; j++){char t= cad.charAt(j);
				if(t=='0')c=c+j+"-";
			}
			int h=0;
			if(T.containsKey(c))h=T.get(c);
			h++;
			if(h>max)max=h;T.put(c, h);
        }
        System.out.println(max);
	}
}
