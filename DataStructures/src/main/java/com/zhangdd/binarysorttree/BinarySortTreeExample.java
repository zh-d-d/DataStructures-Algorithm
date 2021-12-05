package com.zhangdd.binarysorttree;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author zhangdd on 2021/12/4
 */
public class BinarySortTreeExample {

    public static void main(String[] args) {
        Integer arr[] = {7, 3, 10, 12, 5, 1, 9, 2};

        BinarySortTree tree = new BinarySortTree();

        Arrays.stream(arr)
                .collect(Collectors.toList()).stream()
                .map(BinarySortTree.Node::new)
                .forEach(tree::add);

//        tree.infixOrder();

        BinarySortTree.Node node = tree.searchTargetParentNode(5);
//        System.out.println(node);

        tree.infixOrder();

        System.out.println("====================");
        tree.delNode(1);
        tree.delNode(2);
        tree.delNode(3);
        tree.delNode(5);
        tree.delNode(7);
        tree.delNode(9);
        tree.delNode(12);
        tree.delNode(10);

        tree.infixOrder();


    }
}
