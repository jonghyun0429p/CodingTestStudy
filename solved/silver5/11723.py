import sys

M = int(sys.stdin.readline().rstrip())
S = set()

for i in range(M):
    sen = sys.stdin.readline().rstrip()
    if(sen == 'all'):
        S.clear()
        for i in range(1, 21):
            S.add(i)
    elif(sen == 'empty'):
        S.clear()
    else:
        sen, x = sen.split(' ')
        x = int(x)
        if(sen == 'add'):
            if(not(x in S)):
                S.add(x)
        elif(sen == 'remove'):
            if(x in S):
                S.remove(x)
        elif(sen == 'check'):
            if(x in S):
                print(1)
            else:
                print(0)
        else:
            if(x in S):
                S.remove(x)
            else:
                S.add(x)
