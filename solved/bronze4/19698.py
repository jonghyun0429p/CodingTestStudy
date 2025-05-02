import sys

input = sys.stdin.readline

N, W, H, L = map(int, input().split())

cow_count = (W//L)*(H//L)

print(min(cow_count, N))