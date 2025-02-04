K = int(input())
numList = []
result = 0
for i in range(K):
    N = int(input())
    if N == 0:
        numList.pop()
    else:
        numList.append(N)

for i in numList:
    result += i

print(result)