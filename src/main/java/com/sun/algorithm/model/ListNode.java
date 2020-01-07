package com.sun.algorithm.model;

import lombok.Data;

/**
 * Definition for singly-linked list.
 *
 * @author syl
 * @date 2019/10/31 - 09:59
 */
@Data
public class ListNode {

    int val;

    ListNode next;

    ListNode(int next) {
        this.val = next;
    }
}
