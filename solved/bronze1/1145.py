import sys

nums = list(map(int, sys.stdin.readline().rstrip().split(' ')))

count = 0
num = 1

while(count<3):
    count = 0
    num += 1
    for i in nums:
        if(num % i == 0):
            count += 1

print(num)