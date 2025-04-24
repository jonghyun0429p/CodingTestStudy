#할로윈의 사탕
import sys
input = sys.stdin.readline

t = int(input())

for i in range(t):
    candys, bros = map(int, input().split(' '))

    bro = candys // bros
    dad = candys % bros

    print("You get %d piece(s) and your dad gets %d piece(s)." % (bro, dad))