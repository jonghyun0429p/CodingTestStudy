import sys
count = int(sys.stdin.readline().rstrip())
sum, num = 0,1
while(sum < count):
    sum = sum + num
    num += 1
        
before = sum - num + 1

if(num % 2 == 1):
    print(str(count - before)+'/'+str(num - count + before) )
else:
    print(str(num - count + before)+'/'+str(count - before) )


