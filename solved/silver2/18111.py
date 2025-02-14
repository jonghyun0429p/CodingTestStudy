import sys
input = sys.stdin.readline

#구현하고자 하는 방안.
#들어오는 수를 리스트화함.
#ex 000
#   001  =>  4211 0의 갯수, 1의 갯수... 이런식으로
#   123
#그렇게 되면, 최대갯수를 구할 수 있고, time 비교도 비교적 쉬워짐.
def average(ground, inventory):
    time = 0
