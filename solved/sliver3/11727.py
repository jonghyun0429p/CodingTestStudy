#2xn 타일링2
#1칸 1개, 2칸 3개, 3칸 5개, 4칸 9개, 5칸 24개

n = int(input())
dp = [0 for i in range(1001)]

dp[1] = 1
dp[2] = 3

def DP(x):
    if dp[x]:
        return dp[x]
    else:
        for i in range(3, n+1):
            dp[i] = dp[i-1] + 2*dp[i-2]
DP(n)
print(dp[n]%10007)
