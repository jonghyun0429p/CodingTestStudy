'''
    이분탐색을 사용할 수 있어야 풀 수 있음, 시간 초과 관리를 위해
'''
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

treeHeight = list(map(int, input().split(' ')))

start, end = 1, sum(treeHeight)

def binarySearch(start, end):
    mid = (start + end) // 2
    sum = 0
    for tree in treeHeight:
        if tree > mid:
            sum += tree - mid

    if sum >= M:
        start = mid + 1
    else:
        end = mid - 1

    if start <= end:
        binarySearch(start, end)
    else:
        print(end)

binarySearch(start, end)