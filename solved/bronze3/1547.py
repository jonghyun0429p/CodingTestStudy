count = int(input())
pos = [1,0,0]
gone = 0

for i in range(count):
    chans = input().split(' ')
    tmp = pos[int(chans[0])-1]
    pos[int(chans[0])-1] = pos[int(chans[1])-1]
    pos[int(chans[1])-1] = tmp

for i in range(3):
    if(pos[i] == 1):
        print(i+1)
        gone += 1
    
if(gone == 0):
    print(-1)