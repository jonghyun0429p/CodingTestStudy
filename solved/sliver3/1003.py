import sys

count = int(sys.stdin.readline().rstrip())

memo = [[0, 0] for i in range(41)]

memo[0] = [1,0]
memo[1] = [0,1]
memo[2] = [1,1]

def fibonacci(n):
    if(memo[n] == [0, 0]):
        for i in range(3, n+1):
            memo[i][0] = memo[i-1][0] + memo[i-2][0]
            memo[i][1] = memo[i-1][1] + memo[i-2][1]
        return memo
    else:
        return memo
        

for i in range(count):
    N = int(sys.stdin.readline().rstrip())
    fibonacci(N)
    print(memo[N][0], memo[N][1])