#!/usr/bin/python3
#coding=utf-8
import math

def main():
    items = (0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610)
    target = 89
    N = len(items)
    result = -1
    step = int(math.sqrt(N))
    prev = -1

    while items[int(min(step, N)) -1 ] < target:
        prev = step
        step *= 2
        if prev >= N:
            break
    if prev >= N:
        print('Number {} is at index {}.'.format(target, result))
    else:
        while items[prev] < target:
            prev += 1
            if prev == min(step, N):
                break
        if prev < N and items[prev] == target:
            result = prev
        print('Number {} is at index {}.'.format(target, result))        


if __name__ == '__main__':
    main()
