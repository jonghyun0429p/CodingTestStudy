import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)
N, M = map(int, input().split())
NList = list(map(int, input().split()))
NList.sort()
lst = []

def backtracking():
    if len(lst) == M:
        print(*lst)
        return

    for i in range(N):
        if NList[i] not in lst:
            lst.append(NList[i])
            backtracking()
            lst.pop()

backtracking()