import sys
input = sys.stdin.readline

def factorial(x):
    if x == 1:
        return 1
    else:
        return x * factorial(x-1)
    
while True:
    N = int(input())
    sum, cnt = 0, 0
    if N == 0:
        break
    else:
        while N:
            cnt += 1
            remain = N % 10
            N = N // 10
            sum += factorial(cnt)*remain
    
    print(sum)


