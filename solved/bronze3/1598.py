nums = input().split(' ')

for i in range(2):
    nums[i] = int(nums[i])-1

print(abs(nums[1]//4-nums[0]//4)+ abs(nums[1]%4-nums[0]%4))