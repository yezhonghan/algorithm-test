package com.yes.algorithm;

import java.util.LinkedList;

public class BinaryTree {

    public Integer data;

    public BinaryTree leftChildNode;

    public BinaryTree rightChildNode;

    public Integer size;

    public BinaryTree(Integer data){
        this.data = data;
    }

    public static BinaryTree initTree(LinkedList<Integer> list){

        BinaryTree rootNode = null;

        if (list == null || list.isEmpty()){
            return null;
        }
        Integer data = list.removeFirst();
        rootNode = new BinaryTree(data);
        rootNode.leftChildNode = initTree(list);
        rootNode.rightChildNode = initTree(list);
        return rootNode;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(7);
        BinaryTree tree = initTree(list);
        System.out.println(tree.leftChildNode == null);
        System.out.println(tree.rightChildNode == null);
    }
}
