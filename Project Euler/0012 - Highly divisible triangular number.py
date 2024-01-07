import math
n = int(math.ceil((math.sqrt(8*(250^2)) - 1)/2))
sum = int((n * (n-1))/2)
while(True):
    div1 = 1
    counter=0
    sum = sum + n
    while(True): 
        div2 = int(sum/div1)
        if(div2>=div1):
            if(sum % div1 == 0):  
                counter += 1
                if(div2>div1):
                    counter += 1
        else:
            break    
	div1 += 1
    if(counter >= 500):
	print(sum)
	break
    else:
        n +=1

