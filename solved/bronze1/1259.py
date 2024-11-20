import sys

while(True):
    string = list(sys.stdin.readline().rstrip())
    check = 0

    if(string == ['0']):
        break

    if(len(string)%2 ==0):
        count = len(string)//2
    else:
        count = len(string)//2 + 1

    for i in range(count):
        if(string[i] != string[-i-1]):
            check = 1
    
    if(check == 1):
        print('no')
    else:
        print('yes')