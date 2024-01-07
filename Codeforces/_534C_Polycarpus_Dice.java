import java.util.*;
public class _534C_Polycarpus_Dice {
	public static void main(String[] args){
		Scanner leer=new Scanner(System.in);
		StringBuilder coño = new StringBuilder();
		int n=leer.nextInt(),d;
		long A=leer.nextLong();
		LinkedList<Integer>D=new LinkedList<Integer>();
		long ls = A-n+1,li= -A;
		for (int i = 0; i < n; i++){
			d=leer.nextInt();
			li+=d;D.add(d);
		}li++;
        while(!D.isEmpty()){
        	d=D.remove();
        	int r=0;
        	if(ls<d)r+=d-ls;
			if(li<d)r+=d-li;
		    coño.append(r+" ");
		    }
        System.out.println(coño);
        }
	}
/*
2 8
4 4

1 3
5

2 3
2 3

5 8
1 1 1 3 5

3 9
3 4 5

3 4 
3 4 5

Aqui descubrimos que el StringBuilder optimiza la impresion de los datos;  muestra una sola linea con toda la concatenacion
*/