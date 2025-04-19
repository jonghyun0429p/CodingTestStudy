#11279 최대힙

import sys
input = sys.stdin.readline

#단순하게 리스트 정렬로 풀기 - 당연히 시간초과

# T = int(input())
#
# nList = []
#
# for i in range(T):
#     n = int(input())
#     if n == 0:
#         if nList:
#             nList.sort()
#             print(nList.pop())
#         else:
#             print('0')
#     else:
#         nList.append(n)
#         nList.sort()

#딕셔너리로 풀기-시간초과

# T = int(input())
#
# nDict = dict()
#
# for i in range(T):
#     n = int(input())
#     if n == 0:
#         if nDict:
#             maxvalue = max(nDict.keys())
#             nDict.pop(maxvalue)
#             print(maxvalue)
#         else:
#             print('0')
#     else:
#         if n in nDict:
#             nDict[n] = nDict.get(n)+1
#         else:
#             nDict[n] = 1

# 힙 구현 heapq는 최소 힙이니까, 구현해줘야함.

def heappush(heap, data):
    heap.append(data)
    current = len(heap) - 1

    while current > 0:
        parent = (current - 1) // 2
        if heap[parent] < heap[current]:
            heap[parent], heap[current] = heap[current], heap[parent]
            current = parent

        else:
            break

def heappop(heap):
    length = len(heap)
    if not heap:
        return 0
    else:
        if length == 1:
            return heap.pop()
        elif length == 2:
            heap[0], heap[1] = heap[1], heap[0]
            return heap.pop()

    maximum = heap[0]
    heap[0] = heap.pop()

    current = 0
    current_length = length-1
    maxIndex = length-2

    while current*2+1 < current_length:
        child_left = current*2 + 1
        if current*2+2 <= maxIndex:
            child_right = current*2 + 2
            max_value = maxchild(heap, current, child_left, child_right)
            if max_value == child_left:
                heap[current], heap[child_left] = heap[child_left], heap[current]
                current = child_left
            elif max_value == child_right:
                heap[current], heap[child_right] = heap[child_right], heap[current]
                current = child_right
            else:
                break
        else:
            if heap[current] < heap[child_left]:
                heap[current], heap[child_left] = heap[child_left], heap[current]
                current = child_left
            else:
                break

    return maximum

def maxchild(heap, current, child_left, child_right):
    if heap[child_left] >= heap[child_right]:
        if heap[child_left] > heap[current]:
            return child_left
        else:
            return current
    else:
        if heap[child_right] > heap[current]:
            return child_right
        else:
            return current

heap = []

T = int(input())

for i in range(T):
    n = int(input())
    if n == 0:
        print(heappop(heap))
    else:
        heappush(heap, n)














