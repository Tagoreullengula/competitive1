import java.util.*;
public class _490C_Hacking_Cypher{
	public static void main(String[] args){
		Scanner leer = new Scanner (System.in);
		String cad = leer.next();
		int a = leer.nextInt();
		int b = leer.nextInt();
		int m1=0,m2=0;
		int c[]= new int [cad.length()];
		int c1=10%a,c2=1;
		int res=cad.length();
		for (int i = 0,j=cad.length()-1; i <cad.length()-1;i++){
        	int d = cad.charAt(i)-48;
        	m1=((m1*c1)%a+d%a)%a;
        	if(m1==0)c[i]++;
        	d=cad.charAt(j)-48;
        	if(d!=0){
        	m2=(m2+(c2*(d%b))%b)%b;
        	if(m2==0)c[j-1]++;
        	}
        	c2=(c2*(10%b))%b;
        	j--;
        	if(c[j]!=2){
        		if(c[i]==2 && i<res)res=i;
        	}else res=j;       	
		}
        if(res!=cad.length()){System.out.println("YES");
        System.out.println(cad.substring(0,res+1));
        System.out.println(cad.substring(res+1));
        }
        else System.out.println("NO");
	}
}

/*
116401024
97 1024

284254589153928171911281811000
1009 1000

120
12 1

*/