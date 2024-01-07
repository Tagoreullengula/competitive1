import java.util.*;
public class _2A_Winner{
static int r,x;
static String cad;
	public static void main(String[] args){
		Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        Lista A = new Lista();
        r=0;
        for (int i = 0; i < n; i++){
			cad = leer.next();
			x = leer.nextInt();
			A.add();
			r++;
		}
        Nodo aux = A.ini;
        int max =0;
        r=0;
        while(aux!=null){
        	if(aux.score>max){
        		cad=aux.nombre;
        		max=aux.score;
        		r=aux.pos;
        		while(!aux.P.isEmpty()){
    				int i =aux.P.remove();
    				int j =aux.V.remove();
    				if(j>=max && i<r){
    					r=i;
    				}
    			}
        	}else{
        		if(aux.score==max){
        			while(!aux.P.isEmpty()){
        				int i =aux.P.remove();
        				int j =aux.V.remove();
        				if(j>=max && i<r){
        					cad=aux.nombre;
        					r=i;
        				}
        			}
        		}
        	}
        	aux=aux.sig;
        }
        System.out.println(cad);
	}
    static class Nodo{
	   int score,pos;
	   String nombre;
	   LinkedList<Integer> P ;
	   LinkedList<Integer> V ;
	   Nodo sig;
	   public Nodo(int s, String n,int p){
		   score=s;
		   nombre=n;
		   pos=p;
		   P= new LinkedList<Integer>();
		   V = new LinkedList<Integer>();
		   sig=null;
	   }
    }
    static class Lista{
    	Nodo ini,fin;
    	public Lista(){
    		ini= null;
    		fin=null;
    	}
    	public void add(){
    		Nodo aux = ini;
    		while(aux!=null){
    			if(aux.nombre.equals(cad)){
    				aux.score+=x;
    				aux.pos=r;
    				for (int i = 0; i < aux.V.size(); i++){
						int y = aux.V.remove();
						aux.V.add(y);
						aux.P.add(aux.P.remove());
						if(y==aux.score)return;
					}
    				aux.V.add(aux.score);
    				aux.P.add(r);
    				return;
    			}else aux = aux.sig;
    		}
    		aux= new Nodo(x,cad,r);
    		aux.P.add(r);
    		aux.V.add(aux.score);
    		if(ini==null)
    			ini=aux;
    		else fin.sig=aux;
    		fin=aux;
    	}
    }
}
/*
3
andrew 3
andrew 2
mike 5
3
mike 3
andrew 5
mike 2

10
a 4
b 5
a 1
g 3
c -8
b -2
r 2
t 6
t -7
c 2

15
aawtvezfntstrcpgbzjbf 681
zhahpvqiptvksnbjkdvmknb -74
aawtvezfntstrcpgbzjbf 661
jpdwmyke 474
aawtvezfntstrcpgbzjbf -547
aawtvezfntstrcpgbzjbf 600
zhahpvqiptvksnbjkdvmknb -11
jpdwmyke 711
bjmj 652
aawtvezfntstrcpgbzjbf -1000
aawtvezfntstrcpgbzjbf -171
bjmj -302
aawtvezfntstrcpgbzjbf 961
zhahpvqiptvksnbjkdvmknb 848
bjmj -735

*/
