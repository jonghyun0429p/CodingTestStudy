A, B, C  = map(int, input().split())

if C - B <= 0:
    print(-1)
else:
    result = A // (C-B)
    print(result + 1)