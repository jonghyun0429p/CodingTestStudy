inputs = input().split(' ')
numbers = []
loca = []

for i in inputs:
    numbers.append(int(i))


result = numbers[2] + numbers[3]
loca.append(numbers[3]-numbers[1])
loca.append(numbers[2]-numbers[0])
loca.append(numbers[1])
loca.append(numbers[0])

for i in loca:
    if(i<result):
        result = i

print(result)