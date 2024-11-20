import sys
input = sys.stdin.readline

T = int(input())

numList = list(map(int, input().split(' ')))

sortedList = sorted(numList)

numSet = set(numList)

numDict = dict()

result = []

for i in range(T):
    if sortedList[i] in numDict.keys():
        continue
    else:
        numDict[sortedList[i]] = len(numDict)

for i in numList:
    result.append(numDict[i])
print(*result)