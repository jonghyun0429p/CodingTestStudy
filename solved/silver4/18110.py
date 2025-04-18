import sys

input = sys.stdin.readline

from collections import deque

def average(data):
    sum = 0
    length = len(data)

    if length == 0:
        return 0

    for i in data:
        sum += i

    return roundfix(sum/length)


def roundfix(data):
    numremain = data - int(data)
    if numremain < 0.5:
        return int(data)
    else:
        return int(data + 1)


cnt = int(input())
cut = roundfix(cnt*0.15)
#형식 고민중.
#numList = []
datas = deque()

for i in range(cnt):
    datas.append(int(input()))

datas = deque(sorted(datas))

for i in range(cut):
    datas.popleft()
    datas.pop()

print(average(datas))