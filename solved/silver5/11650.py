import sys

numbers = []

for i in range(int(sys.stdin.readline().rstrip())):
    numbers.append(list(map(int, sys.stdin.readline().rstrip().split(' '))))

numbers.sort(key=lambda x: x[1])
numbers.sort(key=lambda x: x[0])

for i in numbers:
    print(str(i[0])+ ' '+ str(i[1]))