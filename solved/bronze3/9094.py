T = int(input())

for i in range(T):
    n, m = map(int, input().split())
    cnt = 0
    for a in range(1, n):
        for b in range(a+1, n):
            result = (a**2+b**2+m)/(a*b)
            if result == int(result):
                cnt += 1

    print(cnt)
