import sys
from collections import deque
input = sys.stdin.readline


N, r, c = map(int, input().split())



def divide_conquer(N, r, c):

    ans = 0

    while N != 0:

        N -= 1

        if r < 2**N and c < 2**N:
            pass
        elif r < 2**N and c >= 2**N:
            ans += 2**(2*N)
            c -= 2**N
        elif r >= 2**N and c < 2**N:
            ans += 2*2**(2*N)
            r -= 2**N
        elif r >= 2**N and c >= 2**N:
            ans += 3*2**(2*N)
            r -= 2**N
            c -= 2**N

    print(ans)

divide_conquer(N, r, c)


