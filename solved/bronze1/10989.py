import sys

input = sys.stdin.readline

N = int(input().rstrip())

numdict = dict()

for i in range(N):
    num = int(input().rstrip())
    if num in numdict:
        numdict[num] += 1
    else:
        numdict[num] = 1

for i in range(max(numdict.keys())+1):
    if i not in numdict:
        continue
    else:
        for j in range(numdict[i]):
            print(i)
