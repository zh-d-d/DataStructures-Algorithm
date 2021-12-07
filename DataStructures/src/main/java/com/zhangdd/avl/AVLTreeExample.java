package com.zhangdd.avl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangdd on 2021/12/5
 */
public class AVLTreeExample {

    public static void main(String[] args) {
        //测试左旋转数据
//        Integer[] arr = {4, 3, 6, 5, 7, 8};

        //测试右旋转数据
//        Integer[] arr = {10, 12, 8, 9, 7, 6};

        //测试双旋转数据
        Integer[] arr = {10, 11, 7, 6, 8, 9};

        List<AVLTree.Node> nodes = Arrays.stream(arr).map(AVLTree.Node::new)
                .collect(Collectors.toList());

        AVLTree tree = new AVLTree();

        nodes.forEach(tree::add);

        tree.infixOrder();

        System.out.println(tree);
        System.out.println(tree.getRoot().leftHeight());
        System.out.println(tree.getRoot().rightHeight());
    }
}
