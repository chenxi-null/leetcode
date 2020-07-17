
# 目录说明

题解代码分布在两个地方：

1. 一部分题解在 `src/main/java` 里，`src/main/test` 是对应的测试用例，这部分代码可以通过 maven (如 `mvn clean test`) 执行

2. 另一部分题解在 `src/main/leetcode/editor/cn` 里， 是 IntelliJ-IDEA leetcode 插件生成的文件格式，是另一份题解代码

# 题型整理
- Sliding Window | Two Pointers
- Slow and fast pointers
- DP
- Backtracking
- DFS 
- BFS
- Linked List
- Tree
    - traverse tree in pre/in/post order
    - Binary Search Tree
- Graph
    - Topological sorting
- UnionJoinSet 
- Sorting 
- MISC
    - array | string
    - queue & stack
    - bit manipulation
        - xor 
 

# 解题模版

## Sliding Window
```java
int l = 0; 
int r = 0; // inclusive
for (; r < n; r++) {
    // add into window
    update state

    while (l < r && statisfied) {
        update the answer

        // remove from window
        update state
        l++;
    }
}
```

```java
int l = 0; // inclusive
int r = 0; // exclusive
while (l < n) {
    if (!satisfied) {
        // add an element into window
        r++;
        update satisfied-state
    }    

    while (l < r && satisfied) {
        update the answer

        // remove the left-most element from window
        update satisfied-state
        l++;
    }
}
```


---

## Backtracking
```
```

# Tags
```
#[WA]
#[Better]
#[Share]
#[Other]
[relax]
```

---


# Research

## `N-Sum`
https://en.wikipedia.org/wiki/3SUM

## `DP` 股票问题
[six kinds of buy-and-sell-stocks](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/)

## 前缀和 & 查分
[前缀和定义](https://zhuanlan.zhihu.com/p/107778275)

[前缀和 & 差分  & 二维前缀和 & 互斥原理](https://www.cnblogs.com/jiamian/p/11523152.html)

[前缀和、二维前缀和与差分的小总结](https://blog.csdn.net/k_r_forever/article/details/81775899)

---

# 待解决

## relax

https://leetcode-cn.com/problems/4sum-ii/

## fight

`#bit #prefix`
https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/

https://leetcode-cn.com/problems/merge-k-sorted-lists/

1488 avoid-floor
