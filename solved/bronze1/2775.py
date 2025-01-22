T = int(input())

memo = [[0 for i in range(15)] for i in range(15)]

for i in range(15):
    memo[0][i] = i+1
    memo[i][0] = 1

def dp(a, b):

    if memo[a][b] == 0:
        for i in range(1, a+1):
            for j in range(1, b+1):
                memo[i][j] = memo[i-1][j] + memo[i][j-1]

for i in range(T):
    a = int(input())
    b = int(input())
    b -= 1

    dp(a, b)
    print(memo[a][b])
