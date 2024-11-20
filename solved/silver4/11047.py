import sys
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())

moneyList = dict()

for i in range(N):
    moneyList[i] = int(input().rstrip())

cnt = 0

while K > 0:
    for i in range(1, N+1):
        if K // moneyList.get(N-i) >= 1:
            K = K - moneyList.get(N-i)
            cnt += 1
            break

print(cnt)

    