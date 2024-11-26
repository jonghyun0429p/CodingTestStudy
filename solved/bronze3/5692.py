N = int(input())

cnt = 0
sum = 0
while N != 0:
    cnt += 1
    remain = N % 10
    N = N // 10

    sum += remain*cnt
    print(remain*cnt)
print(sum)
