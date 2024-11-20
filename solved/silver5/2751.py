import sys

numbers = []

for i in range(int(sys.stdin.readline().rstrip())):
    numbers.append(int(sys.stdin.readline().rstrip()))

numbers.sort()

for i in numbers:
    print(i)