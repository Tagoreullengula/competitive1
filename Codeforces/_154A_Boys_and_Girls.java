import java.util.*;
import java.io.*;
public class _154A_Boys_and_Girls{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner leer = new Scanner(System.in);
     //Scanner leer = new Scanner(new File("input.txt"));
     int n = leer.nextInt();
     int m = leer.nextInt();
     StringBuilder A = new StringBuilder();
     while(n>0||m>0){
    	if(n>m){
    		if(n>0){
    			A=A.append('B');n--;
    		}
    		if(m>0){
    			A=A.append('G');m--;
    		}
    	}
    	else {
    		if(m>0){
    			A=A.append('G');m--;
    		}
    		if(n>0){
    	       A=A.append('B');n--;
    		}
    	}
    	PrintWriter S = new PrintWriter("output.txt");
    	S.println(A.toString());S.close();
     }
	}
}
