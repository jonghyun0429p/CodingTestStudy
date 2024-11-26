import sys
input = sys.stdin.readline

numList = [-1 for _ in range(26)]

S = input().rstrip()

length = len(S)
for i in range(length):
    count = ord(S[i])-97
    if numList[count] == -1:
        numList[count] = numList[count]+i+1

print(*numList)