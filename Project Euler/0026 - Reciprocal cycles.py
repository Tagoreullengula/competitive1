
max = 0
dMaxs = []
for d in range (2, 1000):
    modules = [0]*d
    mod = 1
    count = 0
    prod = mod
    while(mod>0):
	if(prod<d):
	    prod *= 10
	    count += 1
	else:
	    if(modules[mod]!=0):
		if(count - modules[mod]>= max):
		    if(count - modules[mod]> max):
			max= count - modules[mod]
			dMaxs = []
		    dMaxs.append(d)
		break
	    else:
		modules[mod] = count
		mod = prod%d
		prod = mod


print(dMaxs)
