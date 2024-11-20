import sys

count = int(sys.stdin.readline().rstrip())

numlist = list(map(int, sys.stdin.readline().rstrip().split(' ')))

# for i in range(len(numlist)):
#     for j in range(len(numlist)-i):
#         if(numlist[i] > numlist[j]):
#             tmp = numlist[i]
#             numlist[i] = numlist[j]
#             numlist[j] = tmp

numlist.sort()
# print(numlist)
# if(len(numlist)<4):
#     print(numlist[0]*numlist[-1])
# else:
#     print(numlist[0]*numlist[-2])
print(numlist[0]*numlist[-1])