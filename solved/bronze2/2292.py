N = int(input())
cnt = 1
numbox = 1

while N > numbox:
    numbox += 6 * cnt
    cnt += 1

print(cnt)