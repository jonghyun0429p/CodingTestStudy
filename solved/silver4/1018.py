import sys

chess = []
counts = []
min = 64
col, row = map(int, sys.stdin.readline().rstrip().split(' '))

for i in range(col):
    chess.append(list(sys.stdin.readline().rstrip()))

for i in range(col-7):
    for j in range(row-7):
        Wcount, Bcount = 0, 0
        for c in range(8):
            for r in range(8):
                if((c+r)%2==0):
                    if(chess[c+i][r+j] == 'B'):
                        Wcount += 1
                else:
                    if(chess[c+i][r+j] == 'W'):
                        Wcount += 1
                if((c+r)%2==0):
                    if(chess[c+i][r+j] == 'W'):
                        Bcount += 1
                else:
                    if(chess[c+i][r+j] == 'B'):
                        Bcount += 1

        if(Wcount<Bcount):   
            if(Wcount<min):
                min = Wcount
        else:   
            if(Bcount<min):
                min = Bcount

print(min)


        

