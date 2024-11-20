import sys

string = list(sys.stdin.readline().rstrip().upper())

charlist = []
clist = []

for i in string:
    if(charlist.count(i)==0):
        charlist.append(i)
max = 0
for i in charlist:
    count = 0
    for j in string:
        if(i == j):
            count += 1
    if(count > max):
        max = count
        c = i
    clist.append(count)
    
if(clist.count(max) < 2):
    print(c)
else:
    print('?')

