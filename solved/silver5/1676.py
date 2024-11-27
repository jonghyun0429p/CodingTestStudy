import sys

N = int(sys.stdin.readline().rstrip())

#팩토리얼 함수 선언
def factorial(x):
    if x == 1:
        return 1
    else:
        return x * factorial(x-1)
    
#함수를 인덱스로 접근하기 위해서 문자열로 바꿈.
num = str(factorial(N))

#0이 나오면 cnt에 +1 아니면 멈추게 만들었음.
cnt = 0
for i in range(1, len(num)):
    if num[-i] != '0':
        break
    cnt += 1

print(cnt)