#!/usr/bin/python3
#coding=utf-8


def fibonacci(size):
    if size == 1:
        return [1]
    elif size == 2:
        return [1, 1]
    else:
        f = [1, 1]
        for i in range(2, size):
            f.append(f[i-1] + f[i-2])
        return f


def search():
    data = (1, 5, 15, 22, 25, 31, 39, 42, 47, 49, 59, 68, 88, 186)
    target = 39
    index = fibonacciSearch(data, target)
    if index != -1:
        print('Element found at index : {}'.format(index))
    else:
        print('Element not found.')


def printList(data):
    for data_ in data:
        print(data_, end=' ')
    print('')


def fibonacciSearch(data, target):
    lo = 0
    hi = len(data)-1
    mid = 0
    f = fibonacci(20)
    printList(f)
    
    k = 0
    while len(data) >= f[k]:
        k += 1
    print('finbonacci k : {}'.format(k))
    
    temp = []
    for i in range(len(data)-1):
        temp.append(data[i])
    for i in range(len(data), f[k]):
        temp.append(data[len(data)-1])
    printList(temp)

    while lo <= hi:
        mid = lo + f[k-1] - 1
        if temp[mid] > target:
            hi = mid - 1
            k = k - 1
        elif temp[mid] < target:
            lo = mid + 1
            k = k -2
        else:
            if mid <= len(data)-1:
                return mid
            else:
                return len(data)-1
    return -1


if __name__ == '__main__':
    search()
