from fractions import Fraction
from functools import reduce

def is_weird():
    num = int(input())
    if num % 2 != 0:
        print("Weird")
    elif num >= 2 and num <= 5:
        print("Not Weird")
    elif num >= 6 and num <= 20:
        print("Weird")
    else:
        print("weird")

def arithmetic():
    a = int(input())
    b = int(input())

    print('{:d}'.format(a + b))
    print('{:d}'.format(a - b))
    print('{:d}'.format(a * b))

def division():
    a = int(input())
    b = int(input())

    print('{:d}'.format(a // b))
    print('{:f}'.format(a / b))

def n_squares():
    n = int(input())

    s = [x ** 2 for x in range(n)]
    for num in s: print(num)

def is_leap():
    year = int(input())
    return year % 4 == 0 and (year % 100 != 0 or (year % 100 == 0 and year % 400 == 0))

def print_series():
    n = int(input())
    for i in range(n): print(i + 1, end='')

def product(fracs):
    t = reduce(lambda f1, f2: f1 * f2, fracs)
    return t.numerator, t.denominator

def reduce_fracs():
    fracs = []
    for _ in range(int(input())):
        fracs.append(Fraction(*map(int, input().split())))
    result = product(fracs)
    print(*result)

if __name__ == '__main__':
    # is_weird(int(input()))
    # arithmetic()
    # division()
    # n_squares()
    # print(is_leap())
    # print_series()
    reduce_fracs()