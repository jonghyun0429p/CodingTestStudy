import sys
input = sys.stdin.readline

sys.setrecursionlimit(10**7)

M = int(input())

MList = list(map(int, input().split()))
maximum = max(MList)

lst = [0 for _ in range(M)]

for i in range(M):
    for j in range(i):
        if MList[i] > MList[j] and lst[i] < lst[j]:
            lst[i] = lst[j]
    lst[i] += 1

print(max(lst))