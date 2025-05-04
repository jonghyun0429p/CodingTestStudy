dp = [-1] * 91

def fib(n):
    if n <= 1:
        return n
    if dp[n] != -1:
        return dp[n]
    dp[n] = fib(n-1) + fib(n-2)

    return dp[n]

n = int(input())

print(fib(n))