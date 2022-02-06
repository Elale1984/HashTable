package com.algorithms;

import java.util.ArrayList;

class HashNode{
    int key;
    Object value;
    HashNode nextNode;

    public HashNode(int key, Object value) {
        this.key = key;
        this.value = value;
        nextNode = null;
    }

    public HashNode() {
        nextNode = null;
    }

    public int GetKey(){
        return key;
    }

    public Object GetValue(){
        return value;
    }
}


class HashTable<T> {
    HashNode[] arrayHash;
    private final int tableCapacity;

    public HashTable(int tableCapacity) {
      this.tableCapacity = tableCapacity;
      arrayHash = new HashNode[tableCapacity];
      for(int i = 0; i < tableCapacity; i++){
          arrayHash[i] = new HashNode();
      }


    }
    public int GetHash(int key){
        return key % tableCapacity;
    }

    public void put(int key, Object value){
        int HashIndex = GetHash(key);
        HashNode ArrayValue = arrayHash[HashIndex];
        HashNode newItem = new HashNode(key, value);
        newItem.nextNode = ArrayValue.nextNode;
        ArrayValue.nextNode = newItem;

    }
    public T get(int key){
        T value = null;

        int HashIndex = GetHash(key);
        HashNode ArrayValue = arrayHash[HashIndex];
        while (ArrayValue != null){
            if(ArrayValue.GetKey() == key){
                value = (T) ArrayValue.GetValue();
                break;
            }
            ArrayValue = ArrayValue.nextNode;
        }
        return value;
    }
}
