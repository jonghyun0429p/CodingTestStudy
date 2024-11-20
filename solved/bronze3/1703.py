while(True):
    nums = input().split(' ')

    if(nums[0] == '0'):
        break

    age = int(nums[0])

    branch = 1

    for i in range(age*2):
        if(i % 2 == 1):
            branch -= int(nums[i+1])
        else:
            branch *= int(nums[i+1])

    print(branch)



