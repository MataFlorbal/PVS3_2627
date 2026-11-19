package oop.adts;

public class StringStack {
    String[] data;
    //nekdy zname jako 'top'
    int freeIndex;

    StringStack(){
        data = new String[5];
        freeIndex = 0;
    }

    //operace pro pridani do zasobniku
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
