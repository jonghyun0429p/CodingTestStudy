import sys

input = sys.stdin.readline


N, M = map(int, input().split())

numList = [i for i in range(1, N+1)]

lst = []


def backtracking(x):
    if x == M + 1:
        print(*lst)

    for i in range(1, N+1):
        if len(lst) >= 1 and lst[-1] >= i:
            continue

        lst.append(i)
        backtracking(x+1)
        lst.pop()

backtracking(1)



