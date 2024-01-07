#include <bits/stdc++.h> 
using namespace std;
int removeDigit(int number, int d){
    int tenPow =  pow(10, d);
    return (number%tenPow) + (number/(tenPow*10))*tenPow;
}
int main()
{
    int n = 2;
    int lowerB = pow(10,n-1);
    int upperB = pow(10,n);
    long numProd = 1;
    long denProd = 1;
    for(int i = lowerB; i<upperB;i++ ){
        for(int j = i+1; j<upperB; j++){
            int num = i;
            for(int i2 = 0; i2<n; i2++){
                int numD = num%10;
                num = num/10;
                int den = j;
                for(int j2 = 0; j2<n; j2++){
                    int denD = den%10;
                    den = den/10;
                    if(denD == numD && (denD!=0 || numD !=0 || i2 !=0 || j2!=0)){
                        int iNum = removeDigit(i, i2);
                        int jDen = removeDigit(j, j2);
                        if(i*jDen == j*iNum){
                            numProd *= i;
                            denProd *= j;
                            //cout<<i<<'\n';
                            //cout<<j<<'\n'<<'\n';
                        }
                    }   
                }
            }
        }
    }
    long smallDiv = 2;
    while(true){
        if(smallDiv > numProd){
            break;
        }
        if(numProd%smallDiv== 0 && denProd%smallDiv==0){
            numProd = numProd/smallDiv;
            denProd = denProd/smallDiv;
        } else {
            smallDiv++;
        }
    }
    cout<<denProd;
    return 0; 
}
//std::ios_base::sync_with_stdio(false);