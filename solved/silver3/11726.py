import sys

n = int(sys.stdin.readline().rstrip())

memo = [None for i in range(n+3)]

memo[0] = 0
memo[1] = 1
memo[2] = 2

def dp(x):
    if memo[x] == None:
        for i in range(3, n + 1):
            memo[i] = memo[i - 2] + memo[i - 1]

    return memo

dp(n)

print(memo[n]%10007)

