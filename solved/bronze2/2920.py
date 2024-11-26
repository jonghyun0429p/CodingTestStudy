import sys
input = sys.stdin.readline

lst = list(map(int, input().split()))

asc = True
des = True
mix = False

for i in range(8):
    if i != 0:
        if lst[i-1] + 1 != lst[i]:
            asc = False
            mix = True
        if lst[i-1] != lst[i] + 1:
            des = False
            mix = True

if asc:
    print('ascending')
elif des:
    print('descending')
else:
    print('mixed')
        
