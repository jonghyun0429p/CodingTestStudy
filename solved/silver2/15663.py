import sys
input = sys.stdin.readline

N, M = map(int, input().split())

NList = sorted(list(map(int, input().split())))
visited = [False for _ in range(N)]

lst = []

def backtracking():
    if len(lst) == M:
        print(*lst)
    check = 0
    for i in range(N):
        if visited[i] == False and check != NList[i]:
            lst.append(NList[i])
            visited[i] = True
            check = NList[i]
            backtracking()
            lst.pop()
            visited[i] = False

backtracking()
