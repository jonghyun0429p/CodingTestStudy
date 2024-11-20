import sys
import heapq

input = sys.stdin.readline

T = int(input())
hip = []


for i in range(T):
    x = int(input())

    if x == 0:
        if not hip:
            print(0)
        else:
            print(heapq.heappop(hip))
    else:
        heapq.heappush(hip, x)

