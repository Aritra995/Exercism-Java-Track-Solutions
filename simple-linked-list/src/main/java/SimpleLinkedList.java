import java.lang.reflect.Array;
import java.util.*;

class SimpleLinkedList<T> {
    class Node{
        private T data;
        private Node next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    private int sizeOfLinkedList;
    SimpleLinkedList() {
        this.sizeOfLinkedList = 0;
    }

    SimpleLinkedList(T[] values) {
        for (T value : values) {
            push(value);
        }
    }

    void push(T value) {
        Node newNode = new Node(value);
        if ( head == null){
            this.head = newNode;
        } else {
            Node lastVisitedNode = head;
            lastVisitedNode = getLastNode(lastVisitedNode);
            lastVisitedNode.next = newNode;
        }
        sizeOfLinkedList++;
    }

    private Node getLastNode(Node lastVisitedNode) {
        while (lastVisitedNode.next != null){
            lastVisitedNode = lastVisitedNode.next;
        }
        return lastVisitedNode;
    }

    T pop() {
        T data = null;
        Node lastVisitedNode = head;
        if ( sizeOfLinkedList == 0){
            throw new NoSuchElementException();
        } else if (sizeOfLinkedList == 1) {
            data = lastVisitedNode.data;
            lastVisitedNode = null;
        } else {
            lastVisitedNode = getSecondLastNode(lastVisitedNode);
            data = lastVisitedNode.next.data;
            lastVisitedNode.next = null;
        }
        sizeOfLinkedList--;
        return data;
    }

    private Node getSecondLastNode(Node lastVisitedNode) {
        while (lastVisitedNode.next.next != null){
            lastVisitedNode = lastVisitedNode.next;
        }
        return lastVisitedNode;
    }

    void reverse() {
        if ( head == null){
            throw new NoSuchElementException();
        } else {
            Node lastVisitedNode = head;
            List<T> listOfNodeData = new ArrayList<>();
            addNodeDataToList(lastVisitedNode, listOfNodeData);
            
            Collections.reverse(listOfNodeData);

            lastVisitedNode = head;
            int index = 0;
            writeReversedDataToLinkedList(lastVisitedNode, listOfNodeData, index);
        }
    }

    private void writeReversedDataToLinkedList(Node lastVisitedNode, List<T> listOfNodeData, int index) {
        while(lastVisitedNode.next != null){
            lastVisitedNode.data = listOfNodeData.get(index);
            index++;
            lastVisitedNode = lastVisitedNode.next;
        }
        lastVisitedNode.data = listOfNodeData.get(index);
    }

    private Node addNodeDataToList(Node lastVisitedNode, List<T> listOfNodeData) {
        while (lastVisitedNode.next != null){
            listOfNodeData.add(lastVisitedNode.data);
            lastVisitedNode = lastVisitedNode.next;
        }
        listOfNodeData.add(lastVisitedNode.data);
        return lastVisitedNode;
    }

    T[] asArray(Class<T> clazz) {
        @SuppressWarnings("unchecked")
        T[] arrayOfLinkedList = (T[]) Array.newInstance(clazz, sizeOfLinkedList);
        Node lastVisitedNode = head;

        for (int index = 0; index < sizeOfLinkedList; index++){
            lastVisitedNode = addNodeDataToArrayInOrder(arrayOfLinkedList, index, lastVisitedNode);
        }
        Collections.reverse(Arrays.asList(arrayOfLinkedList));
        return arrayOfLinkedList;
    }

    private Node addNodeDataToArrayInOrder(T[] arrayOfLinkedList, int index, Node lastVisitedNode) {
        arrayOfLinkedList[index] = lastVisitedNode.data;
        lastVisitedNode = lastVisitedNode.next;
        return lastVisitedNode;
    }

    int size() {
        return sizeOfLinkedList;
    }
}
