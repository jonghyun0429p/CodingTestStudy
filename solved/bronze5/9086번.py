count = int(input())
for i in range(count):
    testCase = input()
    if(type(testCase)==str):
        print(testCase[0] + testCase[-1])