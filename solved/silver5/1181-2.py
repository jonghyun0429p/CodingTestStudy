import sys

count = int(sys.stdin.readline().rstrip())
words = []

for i in range(count):
    words.append(sys.stdin.readline().rstrip())

words.sort()
words.sort(key=len)
   
beforeWord = ''
for i in words:
    if(i != beforeWord):
        print(i)
    beforeWord = i