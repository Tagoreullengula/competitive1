#include <bits/stdc++.h>
using namespace std;

int main() {
    int limit = 1000000;
    long n = 3;
    long d = 7;
    long ln = 0;
    long ld = 1;
    long rn = 1;
    long rd = 1;
    long cn = 1;
    long cd = 2;
    while(cn != n || cd != d){
        if(cn * d < n * cd){
            ln = cn;
            ld = cd;
            cn += rn;
            cd += rd;
        } else {
            rn = cn;
            rd = cd;
            cn += ln;
            cd += ld;
        }
    }
    rn = cn;
    rd = cd;
    cn += ln;
    cd += ld;
    cout<<rn<<'/'<<rd<<'\n';
    cout<<ln<<'/'<<ld<<'\n';
    cout<<cn<<'/'<<cd<<'\n';
    while (cd<=limit) {
        cn += rn;
        cd += rd;
    }
    cout<<cn - rn<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);