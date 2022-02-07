package com.algorithms;


import java.util.Objects;

public class MyHashTable {

    private static class MyHashNode {

        private String data;
        private MyHashNode nextNode;

        public MyHashNode(String data){
            this.data = data;
            this.nextNode = null;
        }

        public MyHashNode(){
            this.nextNode = null;
        }
    }

    MyHashNode[] hashTable;
    int hashCapacity;

    public MyHashTable(int hashCapacity) {
        this.hashCapacity = hashCapacity;
        hashTable = new MyHashNode[hashCapacity];
        for(int i = 0; i < hashCapacity; i++){
            hashTable[i] = new MyHashNode();
        }
    }
    public int getHash(String data){
        return (data.length() % 37);
    }

    public void addToHashTable(String data){
        int hashedIndex = getHash(data);
        MyHashNode existingNode = hashTable[hashedIndex];
        MyHashNode newItem = new MyHashNode(data);
        newItem.nextNode = existingNode.nextNode;
        existingNode.nextNode = newItem;
    }

    public int findInHashTable(String data){

        int levels = 0;
        int hashIndex = getHash(data);
        MyHashNode currentNode = hashTable[hashIndex];
        while(currentNode != null){
            if(Objects.equals(currentNode.data, data)){
                return levels;
            }
            currentNode = currentNode.nextNode;
            levels++;
        }
        return -1;
    }

}
