import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class _818C_Sofa_Thief{
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int d= Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(tk.nextToken()),m=Integer.parseInt(tk.nextToken());
		LinkedList<Integer> C[][]= new LinkedList[4][];
		C[0]= new LinkedList[n+1];C[1]= new LinkedList[n+1];
		C[2]= new LinkedList[m+1];C[3]= new LinkedList[m+1];
		int P[][]=new int[d+1][4];
		for (int i = 1; i <=d; i++){
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++)P[i][j]=Integer.parseInt(tk.nextToken());
			int pp[]= new int[4];
			pp[0]=Math.min(P[i][0], P[i][2]);
			if(C[0][pp[0]]==null)C[0][pp[0]]=new LinkedList<Integer>();
			C[0][pp[0]].add(i);
			pp[1]=Math.max(P[i][0], P[i][2]);
			if(C[1][pp[1]]==null)C[1][pp[1]]=new LinkedList<Integer>();
			C[1][pp[1]].add(i);	
			pp[2]=Math.min(P[i][1], P[i][3]);
			if(C[2][pp[2]]==null)C[2][pp[2]]=new LinkedList<Integer>();
			C[2][pp[2]].add(i);
			pp[3]=Math.max(P[i][1], P[i][3]);
			if(C[3][pp[3]]==null)C[3][pp[3]]=new LinkedList<Integer>();
			C[3][pp[3]].add(i);P[i]=pp;
		}
		boolean q=true;
		tk = new StringTokenizer(br.readLine());
		int CN[]= new int [4],e[]={1,-1,1,-1},I[]={1,n,1,m};
		for (int i = 0; i < 4; i++)CN[i]=Integer.parseInt(tk.nextToken());
		int R[]= new int [4],CC[]= new int[4];
		for (int i = 0; i < 4 && q; i++){q=false;
			for (int j = I[i],s=0; j <=I[i+1-i%2]&&j>=1; j=j+e[i]){
				if(C[i][j]!=null){
					if(s+C[i][j].size()>CN[i]){q=true;
							if(s==CN[i]||s+C[i][j].size()-1==CN[i]){
								if(s==CN[i]&&s+C[i][j].size()-1==CN[i]){
									if(i%2==0)CC[i]=P[C[i][j].getFirst()][i+1];
									else CC[i]=P[C[i][j].getFirst()][i-1];
								}else{
									if(s==CN[i])CC[i]=j;
									else CC[i]=j+e[i];
								}R[i]=j;
							}break;
						}else s+=C[i][j].size();
					}
				}
		}
		if(R[0]==CC[1]&&R[1]==CC[0]&&R[2]==CC[3]&&R[3]==CC[2] && q){
			Iterator<Integer> it= C[0][R[0]].iterator();
			while(it.hasNext()){
				d=it.next();if(C[1][R[1]].contains(d)&&C[2][R[2]].contains(d)&&C[3][R[3]].contains(d))break;
			}
			pw.println(d);
		}
		else pw.println(-1);
		pw.close();
	}
}

/*
2
3 2
3 1 3 2
1 2 2 2
1 0 0 1

*/