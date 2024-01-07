import java.util.*;
public class _510C_Fox_And_Names {
static Lista A[];
static LinkedList<Character> Res;
static int t;
public static void Construye(int x){	
  		Res.add((char)(x+97));
  		Nodo aux = A[x].ini;
		  while(aux!=null)
    	  {   int k=aux.n;
    	      A[k].c--;
    	      if(k<t&&A[k].c==0)
    	      Construye(k);
    	      aux=aux.sig;
    	  }
    }

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		A= new Lista[26];
		int n = leer.nextInt();
		String cad = leer.next();
		boolean b = true;
		Res= new LinkedList<Character>();
		boolean M [][]= new boolean[26][26];
		for (int i = 0; i < 26; i++) 
			A[i]=new Lista();
		for (int i = 1; i < n; i++){
			String k = leer.next();
			int h = cad.length();
		    int g = k.length(),min=Math.min(g,h);
			boolean p=false;
			for (int j = 0; j < min&&b;j++){
				int ant=cad.charAt(j)-97,sig=k.charAt(j)-97;
				if(ant!=sig){
					    p=true;
					    if(!M[ant][sig])
						{
					    A[ant].add(sig);
						M[ant][sig]=true;
						A[sig].c++;
						
						}
					    break;
				}
			}
			b=(p||h<g)&&b;
			cad=k;
		}
		t=0;
		while(t<26&&b){
			if(A[t].c==0){
				Construye(t);}
			t++;
		}
		if(b&&Res.size()==26){
			System.out.println();
			while(!Res.isEmpty())
				System.out.print(Res.remove());
		}
		else System.out.println("Impossible");
		
	}

	public static class Nodo{
		int n;
		Nodo sig;
		public Nodo(int x){
			n=x;
			sig=null;
		}
	}
	public static class Lista{
		Nodo ini;
		int c;
		public Lista(){
			ini= null;
			c=0;
		}
		public void add(int x){
			Nodo r= ini,ant=null;
			if(ini==null){ini= new Nodo(x); return;}			
			while(r!=null){
				if(r.n>x)
					break;
				else ant=r;r=r.sig;
			}
			Nodo aux = new Nodo(x);
			 if(ant!=null)    
		     {ant.sig=aux;
		     aux.sig=r;		    	 
		     }else
		     {aux.sig=ini;ini=aux;}
		     
		    
		}
	}
	
}
/*
3
rivest
shamir
adleman

10
tourist
petr
wjmzbmr
yeputons
vepifanov
scottwu
oooooooooooooooo
subscriber
rowdark
tankengineer

10
petr
egor
endagorion
feferivan
ilovetanyaromanova
kostka
dmitriyh
maratsnowbear
bredorjaguarturnik
cgyforever



7
car
care
careful
carefully
becarefuldontforgetsomething
otherwiseyouwillbehacked
goodluck

5
nfghrdt
nfeh
nb
zg
zf

11
qqqyoujtewnjomtynhaaiojspmljpt
qvpasam
qjakgyy
qrilibyhmarrxgkxbdwoehydsrycgpnlutqdckyuinixvxhrivzupbhpjglonoalcprquhanoonkfqjtoslxinzazea
qriaisyiczirailcowqzldmovahigwtbqcdvxdwkctmvauvkiztupnscsoxldpkf
lwygddtmexgvjojpkzlohffebnafhbjoatqriplvo
lwpzqikilhwlkdedcutkcrlbsq
laibjksiqzh
lmwreeowfqibhwibbityjfrcnveqydiukldcjavhgdbzoqqqrwgglawqhvffzljlsdypbfgagkasbpbfplwayqadtjwp
lsrqpadkxrzjrwulyvbbtpoowllzkmvtmnhnrujglwajxfbidhdfzcebqvadexrdkfkwcnqsiyckwjpaqbsmreuenwoukvydif
bdaeadljwjruolywjrg

15
p
t
tp
tb
ab
aa
aat
aab
r
rb
rq
rr
rrt
rrz
rrx

17
p
t
tp
tb
ab
aa
aat
aab
r
rb
rq
rr
rrt
rrz
rrx
rrxy
rrxx

27
p
t
tp
tb
ab
aa
aat
aab
r
rb
rq
rr
rrt
rrz
rrx
rrxy
rrxx
rrxxd
rrxxt
rrxxtc
rrxxtm
rrxxtk
rrxxtkh
rrxxtkk
rrxxtkkp
rrxxtkkt
rrxxtkka

10
adjcquqdqcsvixgwglwrrmkhdsbebbjvcgz
aoalcgxovldqfzaorahdigyojknviaztpcmxlvovafhjphvshyfiqqtqbxjjmq
bijtrgtxgzfcpuchdsmkvqrhgdiidnnunwsxscqqn
bmxqnwdcyberszmofrwoc
bomjxrqsfskevfxphcqoqkbbomcyurwlrnhrhctntzlylvwulbdkcdppgykichjtpukfnlxfcev
bynjwjcrqayjpcijndyzmctzbaoqeugwrmhpkzvyygkovpckbzetshne
cfhp
cgdlozuqzwhfssrcxarcjflftmwngzonwfsvtukxvbsoubbbpbfwjfngelekpmoadizdsortkabmsw
cgffiwrszzdbzjyhvgpnfsapufjqfespxbfljgtdgsmfeecqfwfvkweiacditmsnfaldcqlrycllmccmodlnlbkwv
ciobbloxjxuozsuvqwphlhglufb
*/