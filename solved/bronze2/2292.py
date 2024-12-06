L = int(input())
string = input()
H = 0

for i in range(L):
    H += (ord(string[i])-96)*(31**i)

print(H%1234567891)