import java.util.*;
public class _496C_Removing_Columns {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		int m = leer.nextInt();
	    int c =0;
	    LinkedList<String> A = new LinkedList<String>();
	    LinkedList<LinkedList<String>> B = new LinkedList<LinkedList<String>>();
	    for (int i = 0; i < n; i++)A.add(leer.next());
        B.add(A);
			for (int i = 0; i < m&&B.size()>0; i++){
				LinkedList<LinkedList<String>>C =(LinkedList<LinkedList<String>>)B.clone();
				A= new LinkedList<String>();
			    boolean p = true;
			    for (int j=0;j<B.size()&&p;j++){
				A = (LinkedList<String>)C.remove().clone();
				String ant =A.remove(),sig;
				LinkedList<String> N=null;
				while(!A.isEmpty()){
					sig=A.remove();
					if(ant.charAt(i)>=sig.charAt(i)){
				         if(ant.charAt(i)==sig.charAt(i)){
						        if(N==null){N= new LinkedList<String>();N.add(ant);}
						        N.add(sig);
					     }else{
					    	 c++;
					    	 p=false;break;
					     }
					}else{if(N!=null){C.add(N);N=null;}
					}
					ant=sig;
				}if(N!=null&&p)C.add(N);
			}
			if(p)B=(LinkedList<LinkedList<String>>)C.clone();
		}
	    System.out.println(c);
	}
}



/*
1 10
codeforces

4 4
case
care
test
code

5 4
code
forc
esco
defo
rces

3 4
abcd
edfg
hijk

10 10
ddorannorz
mdrnzqvqgo
gdtdjmlsuf
eoxbrntqdp
hribwlslgo
ewlqrontvk
nxibmnawnh
vxiwdjvdom
hyhhewmzmp
iysgvzayst


*/