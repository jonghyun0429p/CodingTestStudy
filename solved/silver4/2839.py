N = int(input())
memo = [5000 for i in range(5001)]

memo[3] = 1
memo[5] = 1

for i in range(6, N+1):
    memo[i] = min(memo[i - 3], memo[i - 5]) + 1

if memo[N] < 5000:
    print(memo[N])
else:
    print(-1)


print(memo)