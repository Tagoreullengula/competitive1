import math
n = 1000
n2 = 2*n*n
sieve = [True]*(n2+1)
sieve[0]=False
sieve[1]=False
primes = [] 
for i in range (2,n2+1):
    if(sieve[i]):
	if(i <= n):
    	    primes.append(i)
	for j in range (i+i,n2+1,i):
	    sieve[j] = False


arrayA = []
arrayB = []
maxConsecutive = 0
for bp in range(0,len(primes)):
    b = primes[bp]
    iniA = max(-b, -n+1)
    for a in range (iniA, n):
        count = 1
	for i in range (1, b):
	    number = i*i + a*i + b
	    if(sieve[number]):
		count += 1
	    else:
		break
	if(count >= maxConsecutive):
	    if(count > maxConsecutive):
		arrayA = []
		arrayB = []
		maxConsecutive = count
	    arrayA.append(a)
	    arrayB.append(b)
print (arrayB, arrayA)
print (arrayB[0]*arrayA[0])
