import java.util.*;
public class _507B_Amr_and_pins {

	public static void main(String[] args) {
     Scanner leer = new Scanner(System.in);
     int r = leer.nextInt();
     int x1=leer.nextInt();
     int y1=leer.nextInt();
     int x2=leer.nextInt();
     int y2=leer.nextInt();
     double d = Math.sqrt(Math.pow(x1-x2, 2)+ Math.pow(y1-y2, 2))/(2*r);
     int dd=(int)d;
     if(d>dd)dd++;
     System.out.println(dd);
     
	}

}
/*
2 0 0 0 4
1 1 1 4 4
4 5 6 5 6
*/
