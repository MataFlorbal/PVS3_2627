package Vyuka.OOP.adts;

import java.io.FileReader;

public class StringStack {
    String[] data;
    int freeIndex;

    StringStack(){
        data = new String[5];
        freeIndex = 0; //'top'
    }

    //pridat do zasobnkiu
    void push(String toAdd){
        data[freeIndex] = toAdd;
        freeIndex++;
    }

    String pop(){
        freeIndex--;
        return data[freeIndex];
    }

    String peek(){
        return data[freeIndex - 1];
    }

    public static void main(String[] args) {
        StringStack test = new StringStack();
        test.push("Test");
        test.push("world");
        System.out.println(test.pop());
        test.push("example");
        System.out.println(test.peek());
        System.out.println(test.pop());
    }
}
