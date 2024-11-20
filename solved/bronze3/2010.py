import sys

count = int(sys.stdin.readline().rstrip())

result = 0
for i in range(count):
    num = int(sys.stdin.readline().rstrip())
    result += num

print(result-count+1)
    