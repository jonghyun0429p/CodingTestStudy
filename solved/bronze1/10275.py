T = int(input())

for test_case in range(T):
    n, a, b = map(int, input().split())
    
    day = 0
    MIN = min(a,b)
    MAX = max(a,b)
    
    while True:
        if 2**(n-day) > MIN:
            day += 1
            if 2**n - 2**(n-day) > MAX:
                day += 1
                break
        else:
            break

    print(day)