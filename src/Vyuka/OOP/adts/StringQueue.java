package Vyuka.OOP.adts;

public class StringQueue {
    QueueLink first, last;

    void enqueue(String toAdd){
        QueueLink link = new QueueLink();
        link.data = toAdd;

        if (first == null){
            first = link;
            last = link;
        }
        else {
            last.next = link;
            last = link;
        }
    }

    String dequeue(){
        if (first == null){
            return null;
        }

        String toReturn = first.data;
        first = first.next;
        return toReturn;
    }

    String peek(){
        if (first == null){
            return null;
        }
        return first.data;
    }

    int getSize(){
        int sizeCounter = 1;
        QueueLink helper = first;

        if (helper == null){
            return 0;
        }

        while (helper.next != null){
            sizeCounter++;
            helper = helper.next;
        }
        return sizeCounter;
    }

    boolean isEmpty(){
        return first == null;
    }
}

class QueueLink{
    String data;
    QueueLink next;
}
