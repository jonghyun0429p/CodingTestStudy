import sys

N = int(sys.stdin.readline().rstrip())

Nlist = (list(sys.stdin.readline().rstrip().split(' ')))

M = int(sys.stdin.readline().rstrip())

Mlist = (list(sys.stdin.readline().rstrip().split(' ')))

counts = []

d = dict()

for i in Nlist:
    if(i in d):
        d[i] += 1
    else:
        d[i] = 1

for i in Mlist:
    if(i in d):
       print(d[i], end=' ')
    else:
        print(0, end=' ')

