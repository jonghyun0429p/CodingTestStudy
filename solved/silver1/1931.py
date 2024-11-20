import sys
input = sys.stdin.readline

conf_count = int(input())
max_count = 100000

List = []

for i in range(conf_count):
    start, end = map(int, input().split(' '))
    List.append([start,end])

List.sort(key=lambda x: (x[1], x[0]))

count = 1
endtime = List[0][1]
for i in range(1, conf_count):
    if endtime <= List[i][0]:
        endtime = List[i][1]
        count += 1

print(count)