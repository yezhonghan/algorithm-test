package com.yes.algorithm;

public class MyLinkedList<T> {

    static class MyNode<T>{
        T data;
        MyNode<T> next;
        public MyNode(T t){
            data = t;
        }
    }

    MyNode<T> headNode;
    MyNode<T> endNode;
    int size;

    public MyLinkedList(){

    }

    public T put(T t) throws NullPointerException {
        if (t == null){
            throw new NullPointerException("空指针");
        }
        MyNode<T> tMyNode = new MyNode<>(t);
        if (this.size == 0){
            headNode = tMyNode;
            endNode = tMyNode;
        }else if (this.size >= 0){
            endNode.next = tMyNode;
            endNode = tMyNode;
        }
        size++;
        return t;
    }

    public T put(int index,T t) throws NullPointerException {
        MyNode<T> insertNode = new MyNode<>(t);
        if (index == 0){
            insertNode.next = headNode;
            headNode = insertNode;
        }else {
            MyNode<T> node = getNode(index-1);
            MyNode<T> next = node.next;
            insertNode.next = next;
            node.next = insertNode;
        }
        size++;
        return t;
    }

    public T get(int index){
        return getNode(index).data;
    }

    public T get(MyNode<T> thisNode){
        if (thisNode == null){
            return null;
        }
        T data = thisNode.data;
//        thisNode = thisNode.next;
        return data;
    }

    public MyNode<T> getNode(int index){
        if (index > this.size || index < 0){
            throw new ArrayIndexOutOfBoundsException("这里不行哦");
        }
        MyNode<T> myNode = headNode;
        for (int i = 1; i <= index; i++) {
            myNode = myNode.next;
        }
        return myNode;
    }

    public void printMyLinkList(){
        if (this.size == 0){
            System.out.println("null");
            return;
        }
        MyNode<T> nowNode = this.headNode;
        System.out.print("MyLinkList[");
        for (int i = 0; i < this.size; i++) {
            System.out.print(get(nowNode));
            if (i < size -1){
                System.out.print(",");
            }
            nowNode = nowNode.next;
        }
        System.out.println("]");
    }

    public T del(int index){
        MyNode<T> willDelNode = getNode(index);
        T data = willDelNode.data;
        MyNode<T> next = willDelNode.next;
        willDelNode.data = next.data;
        willDelNode.next = next.next;
        size--;
        return data;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkList = new MyLinkedList<>();
        try {
            myLinkList.put(1);
            myLinkList.put(2);
            myLinkList.put(4);
            myLinkList.put(3);
            myLinkList.put(6);
            myLinkList.put(11);
            myLinkList.put(1);
            myLinkList.printMyLinkList();
            myLinkList.put(0,100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(myLinkList.get(0));
        System.out.println(myLinkList.get(5));
        System.out.println("................");
        System.out.println(myLinkList.size);
        myLinkList.printMyLinkList();
        System.out.println("................");
        Integer del = myLinkList.del(5);
        System.out.println("del value:" + del);
        System.out.println("size:" + myLinkList.size);
        myLinkList.printMyLinkList();
    }

}
