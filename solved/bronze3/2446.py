n = int(input())

for i in range(n):
    for k in range(i):
        print(' ', end='')
    for j in range(2*(n-i)-1):
        print('*', end='')
    print('')

for i in range(1, n):
    for k in range(n-i-1):
        print(' ', end='')
    for j in range(2*(i+1)-1):
        print('*', end='')
    print('')


# star_num = 2*n-1
# space_max = n-1
#
# for count in range(star_num):
#     for blank in range(abs(n-count)):
#         print(' ', end='')
#     # 횟수가 늘어남에 따라 점점 줄어들다가 절댓값으로 인해 다시 커지기 시작함. 하지만, 1-2면 |-1|이므로 다시 1이 되므로 다른 방법을 찾던가 해야됨.
#     for star in range(abs(star_num-2*count)):
#         print('*', end='')
#     print('')

