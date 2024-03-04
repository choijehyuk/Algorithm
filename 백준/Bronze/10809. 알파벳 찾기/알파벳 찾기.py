import sys

S = input()
eng = 'abcdefghijklmnopqrstuvwxyz'

for i in eng:
    if i in S:
        print(S.index(i), end = ' ')
    else :
        print(-1, end = ' ')