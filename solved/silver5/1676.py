import sys

N = int(input())

num = 1

#팩토리얼 구하기
for i in range(1, N+1):
    num *= i

#0이 나오면 cnt에 +1 아니면 멈추게 만들었음.
cnt = 0
while True:
    if num % 10 != 0:
        break    
    cnt+=1
    num = num//10

print(cnt)