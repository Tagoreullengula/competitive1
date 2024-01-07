import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class _884E_Binary_Matrix{
	//TLE :'(
	public static void main(String[] args) throws IOException{
		PrintWriter pw= new PrintWriter (new BufferedWriter(new OutputStreamWriter(System.out)));
		FileReader fr= new FileReader("e:/prueba.txt"); 
		BufferedReader br = new BufferedReader (fr); //new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(tk.nextToken()),m=Integer.parseInt(tk.nextToken()),c=0;
		int PX[][]= new int[2][m+1],PY[][]= new int[2][m+1],R[]= new int [m+1];
		LinkedList<Integer> PP1= new LinkedList<Integer>();
		LinkedList<Integer> PP2= new LinkedList<Integer>();
		for (int i = 0; i < n; i++){
			char C[]=br.readLine().toCharArray();
			PX[1]= new int[m+1];
			for (int j = 1,r;j<=m;j=j+4){
				if(C[j/4]>=65)r=C[j/4]-55;else r=C[j/4]-48;
				for (int k = 0; k < 4; k++){
					R[j+k]=0;PY[1][j+k]=0;PY[0][j+k]=0;
					if((r&(1<<(3-k)))!=0){
						PX[1][j+k]=j+k;PY[1][j+k]=1;c++;
						if(PX[0][j+k]!=0||PX[1][j+k-1]!=0){
							if(PX[1][j+k-1]!=0){
								int x =j+k-1,y=1,aux;
								while(true){
									PP1.add(x);PP1.add(y);
									if(PX[y][x]!=x||PY[y][x]!=y){aux=x;x=PX[y][x];y=PY[y][aux];}
									else break;
								}PP1.add(j+k);PP1.add(1);
								while(!PP1.isEmpty()){aux=PP1.removeFirst();
								PX[1][aux]=x;PY[PP1.removeFirst()][aux]=y;}
								R[x]=Math.max(1,R[x]);c--;
							}
							if(PX[0][j+k]!=0){ 
								int x1=j+k,y1=0,aux,x2=j+k,y2=1;;
								while(true){
									PP1.add(x1);PP1.add(y1);
									if(PX[y1][x1]!=x1||PY[y1][x1]!=y1){aux=x1;x1=PX[y1][x1];y1=PY[y1][aux];}
									else break;
								}
								while(true){
									PP2.add(x2);PP2.add(y2);
									if(PX[y2][x2]!=x2||PY[y2][x2]!=y2){aux=x2;x2=PX[y2][x2];y2=PY[y2][aux];}
									else break;
								}
								if(x1!=x2||y1!=y2){c--;
									if(y1==1&&R[x1]==R[x2]){R[x1]++;R[x2]++;}
									if(y1==0||R[x1]<R[x2]){x1=x2;y1=y2;}
								}
								while(!PP1.isEmpty()){x2=PP1.removeFirst();y2=PP1.removeFirst();
								PX[y2][x2]=x1;PY[y2][x2]=y1;}
								while(!PP2.isEmpty()){x2=PP2.removeFirst();y2=PP2.removeFirst();
								PX[y2][x2]=x1;PY[y2][x2]=y1;}
							}
						}
					}
				}
			}
			
			PX[0]=PX[1];
		}
		fr.close();
		pw.println(c);
		pw.close();
	}
}
/*
3 4
1
A
8

2 8
5F
E3

1 4
0


*/