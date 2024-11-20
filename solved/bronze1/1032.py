import sys

count = int(sys.stdin.readline().rstrip())
String = list(sys.stdin.readline().rstrip())

for i in range(count-1):
    str = sys.stdin.readline().rstrip()

    for i in range(len(String)):
        if(String[i] != str[i]):
            String[i] = '?'

String = ''.join(String)
print(String)