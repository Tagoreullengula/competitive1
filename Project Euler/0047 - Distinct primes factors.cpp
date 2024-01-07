#include <bits/stdc++.h>
using namespace std;

int main() {
    list<int> primes;
    int counter = 0;
    int n = 4;
    int number = 3;
    primes.push_back(2);
    while(counter != n){
        int copy = number;
        int totalFactors = 0;
        int removeUntil = -1;
        set<int> newSet;
        for (list<int>::iterator it = primes.begin(); it != primes.end() && copy > 1 && newSet.size()<=n; ++it){
            int prime = *it;
            bool isFactor = false;
            if(prime*prime > number){
                prime = copy;
            }
            while (copy%prime == 0) {
                copy = copy/prime;
                isFactor = true;
                totalFactors++;
            }
            if(isFactor){
                newSet.insert(prime);              
            }
        }
        if(totalFactors == 1){
            primes.push_back(number);
        }
        if(newSet.size() == n){
            counter++;
        } else {
            counter = 0;
        }
        number++;
    }
    cout<<number-n<<'\n';
    return 0;
}

//std::ios_base::sync_with_stdio(false);