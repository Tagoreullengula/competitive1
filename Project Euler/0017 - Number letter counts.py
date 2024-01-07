digits=["one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
teens=["ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]
tens=["twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]

digitSum = 0
teenSum = 0
tenSum = 0
sum = 0
for i in range (0, len(digits)):
    digitSum += len(digits[i])
for i in range (0, len(teens)):
    teenSum += len(teens[i])
sum = digitSum + teenSum
# from 20 to 99:
for i in range (0, len(tens)):
    tenSum += len(tens[i]) * 10 + digitSum

sum += tenSum

# from 100 to 999:
sum += (digitSum + len("hundred") * 9) * 100 + (digitSum + teenSum + tenSum + len("and") * 99) * 9
# plus 1000:
sum += len(digits[0]) + len("thousand")
print(sum)


