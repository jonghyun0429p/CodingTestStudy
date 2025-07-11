N = int(input())
sum = 0
cnt = 1
while N > 1:
    sum = N%(cnt*10) + sum
    N = N//(cnt*10)

print(sum)

