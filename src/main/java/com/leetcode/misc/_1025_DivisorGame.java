package com.leetcode.misc;
/*
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.

Return True if and only if Alice wins the game, assuming both players play optimally.

 

Example 1:

Input: 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.
Example 2:

Input: 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 

Note:

1 <= N <= 1000

https://leetcode-cn.com/problems/divisor-game

---

Solution:

通过前面几个数字的推导，可以得出一个大胆的猜想:
N 为奇数时先手必败，N 为偶数时先手必胜

复习一波数学归纳法:

首先，当 N = 1 和 N = 2 时结论成立

假设当 N = k (k > 2) 时结论也成立，我们来看 N = k + 1 时是否成立:
如果 k + 1 为奇数，next_N 也一定为偶数（证明略），而 next_N <= k，所以 F(k + 1) 等于 false；
如果 k + 1 为偶数，next_N 既可以是奇数也可以是偶数，而因为奇数必输，此时先手方可以选择让 next_N 为奇数，即让对手输，所以此时 F(k + 1) 等于 true。

综上，可以证明猜想成立。

 */

/**
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/7/24
 */
public class _1025_DivisorGame {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}
