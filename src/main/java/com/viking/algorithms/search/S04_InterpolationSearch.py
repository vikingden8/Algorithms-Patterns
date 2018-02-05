#!/usr/bin/python3
#coding=utf-8


def search():
    items = (0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610)
    target = 144
    index = interpolationSearch(items, target)
    if index == -1:
        print('Element found not found.')
    else:
        print('Element at index {}'.format(index))


def interpolationSearch(items, target):
    lo, hi = 0, len(items) - 1
    while lo <= hi and target >= items[lo] and target <= items[hi]:
        position = lo + int((target - items[lo]) * (hi - lo) / (items[hi] - items[lo]))
        if items[position] == target:
            return position
        if items[position] < target:
            lo = position + 1
        else:
            hi = position - 1
    return -1


if __name__ == '__main__':
    search()
