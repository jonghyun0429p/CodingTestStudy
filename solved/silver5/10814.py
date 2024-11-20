import sys

lists = []

for i in range(int(sys.stdin.readline().rstrip())):
    a, b = list(sys.stdin.readline().rstrip().split(' '))
    lists.append([int(a),b])
    
lists.sort(key=lambda lists: lists[0])

for i in lists:
    print(str(i[0])+' '+i[1])