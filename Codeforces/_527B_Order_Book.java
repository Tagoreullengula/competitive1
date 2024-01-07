import java.util.Map.Entry;
import java.util.*;
public class _527B_Order_Book {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        int s = leer.nextInt();
        TreeMap<Integer, Long> B = new TreeMap<Integer, Long>();
        TreeMap<Integer, Long> S = new TreeMap<Integer, Long>();
        boolean rb[]= new boolean[100001];
        boolean rs[]= new boolean[100001];
        int cb=0,cs=0,mb=Integer.MAX_VALUE,ms=-1;
        for (int i = 0; i < n; i++) {
				String t= leer.next();
				int p = leer.nextInt();
				long q = leer.nextLong();
				if(t.charAt(0)=='B'){
					if(!rb[p]){
				    if(cb<s){rb[p]=true;
				    B.put(p,q);
				    cb++;if(p<mb)mb=p;
				    }else{
				    	if(p>mb){rb[p]=true;rb[mb]=false;
				    		B.put(p, q);B.pollFirstEntry();mb=B.firstKey();
				    	}
				    }
				    }else B.put(p,B.get(p)+q);  					
				}else{
					if(!rs[p]){
						if(cs<s){rs[p]=true;
							cs++;
							S.put(p,q);
							if(ms<p)ms=p;
						}else{
							if(p<ms){rs[p]=true;rs[ms]=false;
								S.pollLastEntry();S.put(p, q);ms=S.lastKey();
							}
						}
					}else S.put(p, S.get(p)+q);				
				}
		}
        Entry<Integer, Long> r;
        while(!S.isEmpty()){ r = S.pollLastEntry();
        	System.out.println("S "+r.getKey()+" "+r.getValue());
        }
        while(!B.isEmpty()){r=B.pollLastEntry();
        	System.out.println("B "+r.getKey()+" "+r.getValue());
        	}
	}
}
