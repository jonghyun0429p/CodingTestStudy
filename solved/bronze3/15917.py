import sys
input = sys.stdin.readline

Q = int(input())

for test in range(Q):
    a = int(input())

    if (a&(-a))==a:
        print(1)
    else:
        print(0)



