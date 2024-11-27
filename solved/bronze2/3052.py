import sys
input = sys.stdin.readline

numList = [0 for i in range(42)]
cnt = 0
for i in range(10):
    N = int(input().rstrip())
    if numList[N%42] == 0:
        numList[N%42] = 1
        cnt += 1

print(cnt)
