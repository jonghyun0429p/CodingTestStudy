import sys

N, M = map(int, sys.stdin.readline().rstrip().split(' '))

List = set()
result = []

for i in range(N):
    name = sys.stdin.readline().rstrip()
    List.add(name)

for i in range(M):
    name = sys.stdin.readline().rstrip()
    if(name in List):
        result.append(name)

result.sort()
length = len(result)
print(length)

for i in range(length):
    print(result[i])


