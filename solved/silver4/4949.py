def endcheck(x):
    checkList = []
    check = True
    for i in x:
        if i == '(' or i == '[':
            checkList.append(i)
        elif i == ')':
            if checkList:
                popdata = checkList.pop()
                if popdata == '[':
                    check = False
                    break
            else:
                check = False
                break

        elif i == ']':
            if checkList:
                popdata = checkList.pop()
                if popdata == '(':
                    check = False
                    break
            else:
                check = False
                break

    if check and not checkList:
        print('yes')
    else:
        print('no')

while True:
    x = input()
    if x == '.':
        break
    endcheck(x)
