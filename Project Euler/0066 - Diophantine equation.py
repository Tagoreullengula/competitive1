import math;
D = 0
maxX = 0
for d in range (2,1001):
	rnum = 1
	rden = 0
	lnum = 0
	lden = 1
	isLeft = True
	root = math.sqrt(d)
 	a0 = int(root)
 	if(root == a0):
 		continue
 	an = a0
 	dn = 1
 	mn = 0
	while (True):
		num=0
		den=0
		if (isLeft):
			lnum += an*rnum
			lden += an*rden
			num = lnum
			den = lden
		else:
			rnum += an*lnum
			rden += an*lden
			num = rnum
			den = rden
		if(num*num == den*den*d + 1):
			if(num>maxX):
				maxX = num
				D = d
			break
		mn = dn * an - mn
		dn = long((d - mn*mn)/dn)
		an = long((a0 + mn)/dn)
		isLeft = not isLeft

print(D, '\n')