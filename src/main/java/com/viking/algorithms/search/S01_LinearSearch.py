#!/usr/bin/python3
#coding=utf-8


def solution():
    items = (56, 3, 249, 518, 7, 26, 94, 651, 23, 9)
    target = 9
    result = -1
    for i in range(len(items)):
         if items[i] == target:
            result = i
            break
    if result == -1:
        print('No search result with the given target!')
    else:
        print('Search result:{}'.format(result))


if __name__ == '__main__':
    solution()
