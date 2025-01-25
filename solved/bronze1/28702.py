numList = list()

for i in range(3):
    numList.append(input())

if numList[2].isdecimal():
    result = int(numList[2])+1
elif numList[1].isdecimal():
    result = int(numList[1])+2
else:
    result = int(numList[0])+3

if result % 15 == 0:
    print("FizzBuzz")
elif result % 3 == 0:
    print("Fizz")
elif result % 5 == 0:
    print("Buzz")
else:
    print(result)

