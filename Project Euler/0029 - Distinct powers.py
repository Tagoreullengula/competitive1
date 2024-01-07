import math
import array
n = 100000
A = array.array('b', [True]*(n+1) )
maxPow = int(math.log(n, 2)) + 1
pows = array.array('i', [0] * maxPow)
for i in range (2, n+1):
    a = i
    for j in range (1,n):
	if(A[a]):
	    A[a] = False
	    pows[j] += 1
	else:
	    if(a>i):
		print(i,j,a)
	    break
	a = a*i
	if (a>n):
	    break

allPows = array.array('b', [True] * (n * (len(pows)-1) + 1) )
total = 0
for i in range (1, len(pows)):
    count=0
    for j in range (2, n+1):
	prod = i*j
	if(allPows[prod]):
	    count += 1
	    allPows[prod] = False
    total += pows[i]*count

print total
    
