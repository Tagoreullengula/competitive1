import java.util.*;
public class _510C_Fox_And_Names_2 {
static boolean M[][],b;
static LinkedList<Character> alf; 
static int t,P[];
public static void Calcula(int x){
		alf.add((char)(x+97));
		for(int i = 0; i<26; i++){
			if(M[x][i]){
				P[i]--;
				if(i<t && P[i]==0)
					Calcula(i);
			}
		}
	
}
	public static void main(String[] args){
		Scanner leer = new Scanner(System.in);
		int n = leer.nextInt();
		String h = leer.next();
		M= new boolean [26][26];
		P= new int[26];
	
		b = true;
		for (int i = 1; i < n; i++){
		    String cad = leer.next();
		    int min = Math.min(cad.length(), h.length());
		    boolean q= false;
		    for (int j = 0;j < min; j++){
				int x=h.charAt(j)-97;
				int y=cad.charAt(j)-97;
				if(x!=y){
					if(!M[x][y])P[y]++;
				    M[x][y]=true;
				    q=true;
				    break;
				}
			}
		    b=(q||h.length()<cad.length())&&b;
		    h=cad;
		}
		alf= new LinkedList<Character>();
		t=0;
		while(t<26&&b){
			if(P[t]==0)Calcula(t);
			t++;
		}
		if(b&&alf.size()==26)
		{System.out.println();
		while(!alf.isEmpty()){
			System.out.print(alf.remove());
		}
		}else System.out.println("Impossible");
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