import math  

n = 1000
a = 0
b = 0

limit = int(n*(1-math.sqrt(0.5)) + 1)
for i in range (1, limit, 1):
	num = n*(n-i-i)
	den = 2*(n-i)
	if(num%den == 0):
		a = i
		b = int(num/den)
		break
#a^2 + b^2 = c^2
print (a*b*int(math.sqrt(a*a+b*b)))
