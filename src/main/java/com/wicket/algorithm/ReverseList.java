package com.wicket.algorithm;

/**
 * 链表反转
 */
public class ReverseList {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    //迭代
    public static ListNode iterate(ListNode head){
        ListNode prev = null,next,curr = head;
        while(curr != null){   //判断当前链表节点不为空，可以遍历
            next = curr.next;   //将当前节点的next指针保存在临时节点next；
            curr.next = prev;   //将当前的前置数据置为当前节点的next指针数据
            prev = curr;        //保存当前节点至临时变量  prev，供下一个节点的next赋值使用
            curr = next;        //将原先链表的下一个节点赋值为当前节点，继续遍历
        }
        return prev;
    }

    //递归
    public static ListNode recursion(ListNode head){
        if(head == null || head.next == null){  //空链表，或者已经是最后一个节点
            return head;    //返回
        }
        ListNode newHeadNode = recursion(head.next);   //递归自己，获取下一个节点
        head.next.next = head;    //将当前节点的原先下一个节点的下一个节点更改为当前节点（前转后）
        head.next = null;         //将当前节点的后一个节点置为空
        return newHeadNode;
    }

    public static int add(int i){
        if(i > 10){
            return i;
        }
        int j = ++i;
        int x = add(j);
        return x;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

//        ListNode  reverseList = iterate(node1);
//        System.out.println(reverseList);

        ListNode  reverseList2 = recursion(node1);
        System.out.println(reverseList2);

        int a = add(1);
        System.out.println(a);
    }
}
