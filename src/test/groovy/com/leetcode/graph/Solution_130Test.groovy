package com.leetcode.graph


import spock.lang.Specification

/**
 *
 * @author chenxi <chenxi01@souche.com>
 * @date 2020/5/28
 */
class Solution_130Test extends Specification {
    def 'Solve'() {
        expect:
        //        char[][] a = [['O', 'X', 'X', 'O', 'X'],
        //                     ['X', 'O', 'O', 'X', 'O'],
        //                     ['X', 'O', 'X', 'O', 'X'],
        //                     ['O', 'X', 'O', 'O', 'O'],
        //                     ['X', 'X', 'O', 'X', 'O']]
        // expected: [["O","X","X","O","X"],["X","X","X","X","O"],["X","X","X","O","X"],["O","X","O","O","O"],["X","X","O","X","O"]]

        //        char[][] a =
        //                [["X", "O", "X", "X"],
        //                 ["O", "X", "O", "X"],
        //                 ["X", "O", "X", "O"],
        //                 ["O", "X", "O", "X"],
        //                 ["X", "O", "X", "O"],
        //                 ["O", "X", "O", "X"]]

        char[][] a = [["X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"],
                      ["X", "X", "X", "X", "X", "X", "X", "X", "X", "O", "O", "O", "X", "X", "X", "X", "X", "X", "X", "X"],
                      ["X", "X", "X", "X", "X", "O", "O", "O", "X", "O", "X", "O", "X", "X", "X", "X", "X", "X", "X", "X"],
                      ["X", "X", "X", "X", "X", "O", "X", "O", "X", "O", "X", "O", "O", "O", "X", "X", "X", "X", "X", "X"],
                      ["X", "X", "X", "X", "X", "O", "X", "O", "O", "O", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"],
                      ["X", "X", "X", "X", "X", "O", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"]]

        println 'start:'
        print(a)
        new Solution_130().solve(a)
        println '\n\nend:'
        print(a)
    }

    void print(char[][] a) {
        for (char[] b : a) {
            println Arrays.toString(b)
        }
        //        int m = a.length
        //        int n = a[0].length
        //        for (int i = 0; i < m; i++) {
        //            for (int j = 0; j < n; j++) {
        //                System.out.print('|' + a[i][j])
        //            }
        //            System.out.print('|\n');
        //        }
    }
}
