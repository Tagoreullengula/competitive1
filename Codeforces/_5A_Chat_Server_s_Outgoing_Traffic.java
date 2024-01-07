import java.util.*;
public class _5A_Chat_Server_s_Outgoing_Traffic{
	public static void main(String[] args){
		Scanner leer = new Scanner(System.in);
		int c=0,res=0;
		while(true){
	    String cad = leer.nextLine();
		if(cad.length()>0){
			if(cad.charAt(0)=='+' || cad.charAt(0)=='-'){
				if(cad.charAt(0)=='+')c++;
				else c--;
			}
			else res+= (cad.length()-cad.indexOf(":")-1)*c;
		}else break;
		}System.out.println(res);
	}
}

/*
+Mike
Mike:hello
+Kate
+Dmitry
-Dmitry
Kate:hi
-Kate

+Mike
-Mike
+Mike
Mike:Hi   I am here
-Mike
+Kate
-Kate

*/