import java.util.*;
public class _526B_Om_Nom_and_Dark_Park{
   public static void main(String[] args){
   Scanner leer = new Scanner(System.in);
   int n = leer.nextInt();
   int h=2,c=(int)Math.pow(2, n),max=0;
   int S []= new int[c];
  	  for (int r = 1; r < n; r++){
    	c=c>>1;
  	    int x=0,y=c;
  	    for (int i = 0; i < h; i++){
			int g = leer.nextInt();
			int f = S[x]+g;
			while(x<y){
					S[x]=f;
					x++;
			}
			y=y+c;
			}
    	 h=h<<1;
     }
  	  for (int i = 0; i < h; i++) {
  		 S[i]+=leer.nextInt();
  	     if(S[i]>max)max=S[i];
  	  }
     int res=0;
     for (int i = 0; i < S.length; i++)
    	S[i]=max-S[i];
    c =S.length;
    while(c>2){
    	int i=0,k=0;
    	while(i<c){
    		int x=S[i];
    		i++;
    		if(x>S[i]){S[k]=S[i];res+=x-S[i];}
    		else{S[k]=x;res+=S[i]-x;}
    		i++;
    		k++;
    	}
    	c=k;
    }
    res+=S[0]+S[1];
    System.out.println(res);
	}
}
/*
2
1 2 3 4 5 6

1
2 3

3
1 2 3 4 5 6 7 8 9 10 11 12 13 14 
*/