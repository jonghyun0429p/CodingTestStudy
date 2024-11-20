import sys

length = int(sys.stdin.readline().rstrip())

if(length == 64):
    print(1)
else:
    print(bin(63&length).count('1'))