import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
nameList = dict()
for i in range(1, N+1):
    name = input().rstrip()
    nameList[i] = name

reversedList = dict(map(reversed, nameList.items()))

for i in range(M):
    nameOrNum = input().rstrip()
    if(nameOrNum.isdigit()):
        num = int(nameOrNum)
        print(nameList.get(num))
    else:
        print(reversedList.get(nameOrNum))

