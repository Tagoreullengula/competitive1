import java.util.*;
public class _492C_Vanya_and_Exams {
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		long r = leer.nextLong();
		long avg = leer.nextLong();
		int B[]= new int[n];
		long D[]= new long[n];
		TreeMap<Integer, TreeMap<Long, Integer>> E = new TreeMap<Integer, TreeMap<Long, Integer>>();
		boolean t []= new boolean [1000001]; 
		avg=avg*n;
		boolean p=true;
		for (int i=0;i<n;i++){
			D[i]= leer.nextLong();
			B[i]=leer.nextInt();
			p=p&&avg>0;
			if(p){
			avg=avg-D[i];
			if(t[B[i]]){
				TreeMap<Long,Integer> aux=E.get(B[i]);
				if(aux.containsKey(D[i])){
					aux.put(D[i], aux.get(D[i])+1);
				}else
					aux.put(D[i],1);
				E.put(B[i], aux);
			}else{
				t[B[i]]= true;
				TreeMap<Long, Integer> aux= new TreeMap<Long, Integer>();
				aux.put(D[i],1);E.put(B[i], aux);
			}
            }
		}p=p&&avg>0;
		long c=0;
		while(p){
			int b = E.firstKey();
			TreeMap<Long,Integer> aux = E.remove(b);
			while(!aux.isEmpty()&&p){
				long nota=aux.firstKey();
				int re =aux.remove(nota);
				nota=r-nota;
				while(re>0&&p){
					if(nota>=avg){c+=avg*b;p=false;}
					else{c+=nota*b;avg=avg-nota;}
					re--;
				}
			}
		}
        System.out.println(c);
	}
}

/*
5 5 4
5 2
4 7
3 1
3 2
2 5

7 10 5
9 4
4 2
5 3
2 2
1 5
1 6
3 2

2 5 4
5 2
5 2
*/