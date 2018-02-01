#!/usr/bin/python3
#coding=utf-8


def main():
    items = (2, 5, 8, 12, 16, 23, 38, 56, 72, 91)
    target = 23
    low, high = 0, len(items)-1
    result = -1
    median = -1
    while low <= high:
        median = (low + high) // 2
        if items[median] == target:
            result = median
            break
        if items[median] > target:
            high = median - 1
        else:
            low = median + 1
    if result == -1:
        print('No binary search result with the given target!')
    else:
        print('Binary search result : {}'.format(result))


if __name__ == '__main__':
    main()
