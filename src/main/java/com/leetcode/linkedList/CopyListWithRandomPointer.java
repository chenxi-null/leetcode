package com.leetcode.linkedList;
/*
138. Copy List with Random Pointer

https://leetcode-cn.com/problems/copy-list-with-random-pointer/

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import com.leetcode.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class CopyListWithRandomPointer {
    /*
    original node list:

        [array]
        1    2    3    4
        a -> b -> c -> d

        [map] pointer to idx

        a -> b ==> 1 -> 2
        [map] idx to idx (random pointer)

    new node list:

        array2

     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        LinkedList<Node> nodes = new LinkedList<>();
        Node p = head;
        while (p != null) {
            nodes.add(p);
            p = p.next;
        }
        Node[] arr = nodes.toArray(new Node[]{});

        Map<Node, Integer> refToIdxMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Node node = arr[i];
            refToIdxMap.put(node, i);
        }

        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Node ref = arr[i].random;
            if (ref != null) {
                Integer randomNodeIdx = refToIdxMap.get(ref);
                idxMap.put(i, randomNodeIdx);
            }
        }

        Node newHead = null;
        Node prev = null;
        for (int i = 0; i < arr.length; i++) {
            Node curr = new Node(arr[i].val);
            if (prev == null) {
                newHead = curr;
            } else {
                prev.next = curr;
            }
            prev = curr;
            arr[i] = curr;
        }
        idxMap.forEach((i, j) -> arr[i].random = arr[j]);
        return newHead;
    }
}