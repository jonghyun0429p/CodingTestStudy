while(True):
    num = input()
    size = 0

    if(num == '0'):
        break

    for i in range(len(num)):
        if(num[i] == '1'):
            size += 3
        elif(num[i] == '0'):
            size += 5
        else:
            size += 4
        

    print(size+1)