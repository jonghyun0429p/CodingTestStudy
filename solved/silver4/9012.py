import sys

T = int(sys.stdin.readline().rstrip())
Tlist = []

for i in range(T):
    Tlist.append(list(sys.stdin.readline().rstrip()))

for i in range(T):
    count = 0
    for j in range(len(Tlist[i])):
        if(Tlist[i][j] == '('):
            count += 1
        elif(Tlist[i][j] == ')'):
            count -= 1
        if(count < 0):
            print("NO")
            break
        # print(Tlist[i][j])
        # print(count)
    if(count == 0):
        print("YES")
    elif(count > 0):
        print("NO")
