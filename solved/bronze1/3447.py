import sys

code = sys.stdin.readlines()

for i in code:
    while 'BUG' in i:
        i = i.replace('BUG', '')
    print(i, end='')



