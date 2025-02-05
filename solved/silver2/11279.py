#11279 최대힙

#단순하게 리스트 정렬로 풀기 - 당연히 시간초과

# T = int(input())
#
# nList = []
#
# for i in range(T):
#     n = int(input())
#     if n == 0:
#         if nList:
#             nList.sort()
#             print(nList.pop())
#         else:
#             print('0')
#     else:
#         nList.append(n)
#         nList.sort()

#딕셔너리로 풀기

T = int(input())

nDict = dict()

for i in range(T):
    n = int(input())
    if n == 0:
        if nDict:
            nDict.pop(max(nDict.keys()))
        else:
            print('0')
    else:
        if i in nDict:
            nDict[i] = nDict.get(i)+1
        else:
            nDict[i] = 1



