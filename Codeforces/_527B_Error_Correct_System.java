import java.util.*;
public class _527B_Error_Correct_System{
	public static void main(String[] args){
		Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        char s[] = leer.next().toCharArray();
        char t[] = leer.next().toCharArray();
        int h=0;
        int r=0;
        int x=-1,y=-1;
        int M[][]= new int [27][27];
        for (int i = 0; i < n; i++) {
			if(s[i]!=t[i]){
				h++;
				if(r!=2){
				int a = s[i]-96;
				int b = t[i]-96;
				M[a][b]=i+1;
				M[a][0]=i+1;
				M[0][b]=i+1;
				if(M[b][a]==0){
                    if(M[0][a]==0){
                	   if(M[b][0]!=0){x=i+1;y=M[b][0];r=1;}
                    }
                else{x=M[0][a];y=i+1;r=1;}
				}
				else{ r=2; x=i+1;y=M[b][a];}
				}
			}
		}
        System.out.println(h-r);
        System.out.println(x+" "+y);
        
	}
}
/*
9
pergament
permanent
6
wookie
cookie

4
petr
egor

6
double
bundle

9
abcdefghi
ihgfedcba

5
aaaaa
bbbbb

10
qweertaduu
uwerrdayuq	

*/