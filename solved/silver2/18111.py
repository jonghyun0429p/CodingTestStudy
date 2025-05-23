import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())
ground_count_list = [0 for _ in range(257)]
ground_list = []

for _ in range(N):
    for ground in map(int, input().split()):
        ground_count_list[ground] += 1
        ground_list.append(ground)

def ground_equal(goal, ground_list, inventory):
    time = 0
    for i in range(len(ground_list)):
        differ = goal - ground_list[i]
        if differ < 0:
            inventory += -differ
            time += (-differ) * 2
        else:
            time += differ
            inventory -= differ
    if inventory < 0:
        return False
    return time

goal_ground = 0
time_min = float('inf')

for count in range(256, -1, -1):
    time = ground_equal(count, ground_list, B)
    if time is not False:
        if time < time_min:
            time_min = time
            goal_ground = count

print(time_min, goal_ground)