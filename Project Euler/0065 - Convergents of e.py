import math;
twoProd=0
def gcd(a,  b) :
    if(a%b == 0):
        return b
    else:
        return gcd(b,a%b)
    
def getA(n):
    global twoProd
    v=1
    if(n%3==0):
        v = twoProd
        twoProd -= 2
    return v
3

n=100
twoProd = int(n/3)*2
num = 1
den = getA(n)
divisor = 0
n = n -1;
while (n>=2):
    ai = getA(n)
    newDen = ai * den + num
    num = den
    den = newDen
    divisor = gcd (num,den)
    num = int(num/divisor)
    den = int(den/divisor)
    n = n -1;

num = num + den*2
divisor = gcd(num,den)
num = int(num/divisor)
print (num, '/', den,'\n')
sum = 0;
while(num>0):
    sum += (num%10);
    num = int(num/10);

print(sum);
