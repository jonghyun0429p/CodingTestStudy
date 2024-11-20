import sys

N = int(sys.stdin.readline().rstrip())

Nlist = set(map(int, sys.stdin.readline().rstrip().split(' ')))

M = int(sys.stdin.readline().rstrip())

Mlist = list(map(int, sys.stdin.readline().rstrip().split(' ')))

for i in range(M):
    length = len(Nlist)
    Nlist.add(Mlist[i])
    if(length == len(Nlist)):
        print(1)
    else:
        Nlist.remove(Mlist[i])
        print(0)
    