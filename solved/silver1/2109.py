import sys
input = sys.stdin.readline

N = int(input())
center_num = int(N/2)
num_list = []
num_dict = dict()
sum = 0

for T in range(N):
    num = int(input())
    sum += num
    num_list.append(num)
    if num in num_dict.keys():
        num_dict[num] += 1
    else:
        num_dict[num] = 1

num_list.sort()
num_avg = round(sum/N)
print(num_avg)

num_cen = num_list[center_num]
print(num_cen)

mode_max = max(num_dict.values())
keys = [k for k, v in num_dict.items() if v == mode_max]
if len(keys) == 1:
    print(keys[0])
else:
    keys.sort()
    print(keys[1])

num_max = max(num_list)
num_min = min(num_list)
print(num_max-num_min)