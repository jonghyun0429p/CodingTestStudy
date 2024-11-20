import sys

count = int(sys.stdin.readline().rstrip())

for i in range(count):
    west, east = map(int, sys.stdin.readline().rstrip().split(' '))
    bridge = 0
    result = 1
    for i in range(east-west):
        result = result*(east-i)/(i+1)
    
    print(int(result))
