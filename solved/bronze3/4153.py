import sys

def isTri(a, b, c):
    if(a**2 == b**2 + c**2):
        print("right")
    else:
        print("wrong")


while(True):
    a, b, c = map(int, sys.stdin.readline().rstrip().split(' '))

    if(a == 0 and b == 0 and c == 0):
        break
    
    if(a>b):
        if(a>c):
            isTri(a,b,c)
        else:
            isTri(c, a, b)
    else:
        if(b>c):
            isTri(b,c,a)
        else:
            isTri(c, a, b)