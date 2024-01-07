import java.util.*;
public class _518B_Tanya_and_Postcard{
	public static void main(String[] args){
       Scanner leer = new Scanner(System.in);
       char s[] = leer.next().toCharArray();
       char t[] = leer.next().toCharArray();
       LinkedList<Integer> sobras= new LinkedList<Integer>();
       int y=0;
       int w=0;
       int letras[]= new int[52];
       for (int i = 0; i < s.length; i++){
    	   if(s[i]>=97)s[i]+=-71;
    	   else s[i]+=-65;
    	   letras[s[i]]++;
       }       
       int z;
       for (int i = 0; i < t.length; i++){
    	   if(t[i]>=97){t[i]+=-71; z=t[i]-26;}
    	   else {t[i]+=-65; z=t[i]+26;}
    	   if(letras[t[i]]>0){
    	       letras[t[i]]--;
    	       y++;
    	   }else 
    		   sobras.add(z);
	   }
       while(!sobras.isEmpty()){
    	   z=sobras.remove();
    	   if(letras[z]>0){
    		   letras[z]--;
    		   w++;
    	   }
       }
       System.out.println(y+" "+w);
	}
}




/*
AbC
DCbA

ABC
abc

abacaba
AbaCaBA
*/