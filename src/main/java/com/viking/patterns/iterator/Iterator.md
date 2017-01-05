## Iterator Design Pattern（迭代器设计模式）

### 定义

提供一种方法顺序访问访问一个聚合（也就是Java中常见的List，Set，Map）对象中的各个元素，而又不暴露该对象内部表示。

### 结构和说明

![迭代器结构图](https://github.com/vikingden8/Algorithms-Patterns/blob/master/src/main/resources/iterator_diagram.png)

Iterator : 迭代器接口，定义访问和遍历元素的接口；

ConcreteIterator ： 具体的迭代器实现对象，实现对聚合对象的遍历，并跟踪遍历时的当前位置；

Aggregate ： 聚合对象，定义创建响应迭代器对象的接口；

ConcreteAggregate ： 具体的聚合对象，实现创建相应的迭代器对象。