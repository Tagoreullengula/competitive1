import java.util.*;
public class _527C_Glass_Carving{
	public static void main(String[] args) {
		Scanner leer = new Scanner (System.in);
		int w= leer.nextInt();
		int h = leer.nextInt();
		int n = leer.nextInt();
		TreeSet<Integer> H = new TreeSet<Integer>();
		TreeSet<Integer> V = new TreeSet<Integer>();
        H.add(h);V.add(w);
        LinkedList<Character> L= new LinkedList<Character>();
        LinkedList<Integer> C = new LinkedList<Integer>();
        int hl[]= new  int[200001];
        int hr[]= new  int[200001];
        int vl[]= new  int[200001];
        int vr[]= new  int[200001];
        for (int i = 0; i < n; i++){
			String cad = leer.next();
			int c = leer.nextInt();
			if(cad.charAt(0)=='H')
				H.add(c);
			else
				V.add(c);
			L.push(cad.charAt(0));
			C.push(c);
		}
      
        int li=0,ls=H.pollFirst();
        long mh=0,mv=0;
        while(true){
        	int d=ls-li;
        	if(d>mh)
        	    mh=d;
        	if(!H.isEmpty()){
        		hl[ls]=li;
        		li=ls;
        		ls=H.pollFirst();
        	hr[li]=ls;}else break;
        }
        li=0;
        ls=V.pollFirst();
        while(true){
        	int d=ls-li;
        	if(d>mv)
        	    mv=d;
        	if(!V.isEmpty()){
        		vl[ls]=li;
        		li=ls;
        		ls=V.pollFirst();
        	vr[li]=ls;}else break;
        }
        
        LinkedList<Long> R = new LinkedList<Long>();
        long max = mv*mh;
        R.push(max);
        while(C.size()>1){
        	char t = L.pop();
        	int c = C.pop();
        	if(t=='H'){
        		hr[hl[c]]=hr[c];
        		hl[hr[c]]=hl[c];
        		int d = hr[c]-hl[c];
        		if(d>mh){mh=d;
        			max=mh*mv;
        			}
        	}
        	else{
        		vr[vl[c]]=vr[c];
        		vl[vr[c]]=vl[c];
        		int d = vr[c]-vl[c];
        		if(d>mv){
        			mv=d;
        			max=mv*mh;
        		}
        	}
        	R.push(max);
        }
        while(!R.isEmpty())
        	System.out.println(R.pop());
        
	}
}

/*

4 3 4
H 2
V 2
V 3
V 1

7 6 5
H 4
V 3
V 5
H 2
V 1

20 14 5
V 1
H 13
H 10
V 4
H 3


200000 200000 10
H 1
H 2
V 5
H 3
H 32434
V 98732
V 1345
H 44444
V 1
H 44445


10 10 10                    
V 6
H 8
V 4
V 8
H 2
H 5
V 9
H 7
H 3
V 7



Res:
60
48
32
32
24
12
12
12
8
8



*/