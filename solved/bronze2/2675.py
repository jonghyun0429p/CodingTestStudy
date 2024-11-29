T = int(input())

for test_case in  range(1, 1+T):
    num, string = input().split()
    num = int(num)

    for i in range(len(string)):
        for j in range(num):
            print(string[i], end='')
    
    print()




