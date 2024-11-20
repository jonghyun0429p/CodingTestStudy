while(True):
    try:
        count = int(input())
        result = 0

        for i in range(count):
            data = int(input())
            result += data

        if(result == 0):
            print(0)
        elif(result < 0):
            print('-')
        else:
            print("+")
    except:
        break