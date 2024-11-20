import sys

x, y = map(int, sys.stdin.readline().rstrip().split(' '))

loca = []
row, col = 0, 0
count = 0

for i in range(x):
    loca.append(sys.stdin.readline().rstrip())

for i in range(x):
    count = 0
    for j in range(y):
        if(loca[i][j]=="X"):
            count = 1
    if(count == 0):
        row += 1

for i in range(y):
    count = 0
    for j in range(x):
        if(loca[j][i]=="X"):
            count = 1
    if(count == 0):
        col += 1

if(row > col):
    print(row)
else:
    print(col)

