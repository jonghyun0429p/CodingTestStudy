num = int(input())

numlist = list(map(int, input().split(' ')))

maximum = max(numlist)
sum = 0

for i in range(num):
    numlist[i] = numlist[i]/maximum*100
    sum += numlist[i]

print(sum/num)




