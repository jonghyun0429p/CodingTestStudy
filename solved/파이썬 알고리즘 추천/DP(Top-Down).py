def fibonacci_bu(n):
    memo = [0, 1]  # base case

    for i in range(2, n+1):
        memo.append(memo[i - 1] + memo[i - 2])

    return memo[-1]


print(fibonacci_bu(36))