import sys

N, M = map(int, sys.stdin.readline().rstrip().split(' '))

List = list(map(int, sys.stdin.readline().rstrip().split(' ')))
sumList = [None for i in range(N)]
sumList[0] = List[0]

endcount = 1

for C in range(M):
    start, end = map(int, sys.stdin.readline().rstrip().split(' '))

    if endcount < end:
        for i in range(endcount, end):
            sumList[i] = (sumList[i-1] + List[i])

        endcount = end


    if start == 1:
        print(sumList[end-1])
    else:
        print(sumList[end-1]-sumList[start-2])