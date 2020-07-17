
# Templates

## Backtracking
```
```

## Sliding Window
```
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

```
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

# Tags
```
#[WA]
#[Better]
#[Share]
#[Other]
[relax]
```

---


# Ideas

`N-Sum`
https://en.wikipedia.org/wiki/3SUM

`#dp` 
[six kinds of buy-and-sell-stocks](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/)

---

# List

## relax

https://leetcode-cn.com/problems/4sum-ii/

## fight

`#bit #prefix`
https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/

https://leetcode-cn.com/problems/merge-k-sorted-lists/

1488 avoid-floor


## research

[前缀和定义](https://zhuanlan.zhihu.com/p/107778275)

[前缀和 & 差分  & 二维前缀和 & 互斥原理](https://www.cnblogs.com/jiamian/p/11523152.html)

[前缀和、二维前缀和与差分的小总结](https://blog.csdn.net/k_r_forever/article/details/81775899)