import sys
input = sys.stdin.readline

from collections import deque

def printing(docs, count):
    cnt = 0
    while True:
        if docs[0] == max(docs):
            cnt += 1
            if count == 0:
                print(cnt)
                break
            docs.popleft()
            count = count - 1
        else:
            docs.rotate(-1)
            if count > 0:
                count = count - 1
            else:
                count = len(docs)-1

T = int(input())

for i in range(T):
    N, M = map(int, input().split(' '))

    Docs = deque(map(int, input().split(' ')))

    printing(Docs, M)








