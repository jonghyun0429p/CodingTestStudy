import sys

N = int(sys.stdin.readline().rstrip())

stack = []
result = []

for i in range(N):
    com = sys.stdin.readline().rstrip()
    if(' ' in com):
        com, n = com.split(' ')
        stack.append(int(n))
    else:
        if(com == 'pop'):
            if(stack):
                data = stack[0]
                stack.remove(data)
                result.append(data)
            else:
                result.append(-1)
        elif(com == 'size'):
            result.append(len(stack))
        elif(com == 'empty'):
            if(stack):
                result.append(0)
            else:
                result.append(1)
        elif(com == 'back'):
            if(stack):
                data = stack.pop()
                stack.append(data)
                result.append(data)
            else:
                result.append(-1)
        else:
            if(stack):
                result.append(stack[0])
            else:
                result.append(-1)

for i in result:
    print(i)