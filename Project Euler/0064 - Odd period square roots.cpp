#include <bits/stdc++.h>
using namespace std;

int main () {
    int counter = 0;
    for(int i = 2; i<=10000; i++) {
        long double newI = i;
        long double root = sqrtl( newI );
        int pos = 0;
        cout.precision(30);
        cout<<i<<' '<<root<<' ';
        int rootIntPart = int(root);
        if (root == rootIntPart) {
            cout<<'\n';
            continue;
        }
        int intPart = rootIntPart;
        int dn = 1;
        int mn = 0;
        while (intPart != 2*rootIntPart) {
            mn = dn*intPart-mn;
            dn = (i - mn*mn)/dn;
            intPart = (rootIntPart+mn)/dn;
            pos++;
        }
        counter += (pos%2);
        cout<<pos<<'\n';
    }
    cout<<counter<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);