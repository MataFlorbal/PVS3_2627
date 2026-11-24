package Vyuka.OOP.adts;


public class StringStack implements MyStack {
    public String[] data;
    int freeIndex; //'top'

    private static final int BASE_SIZE = 16;

    StringStack(){
        data = new String[BASE_SIZE];
        freeIndex = 0;
    }

    @Override
    public void push(String toAdd) {
        if(freeIndex == data.length){
            expandArray();
        }

        data[freeIndex] = toAdd;
        freeIndex++;
    }

    private void expandArray(){
        String[] newPole = new String[(int) (data.length * 2)];

        for (int i = 0; i < data.length; i++) {
            newPole[i] = data[i];
        }

        data = newPole;
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            return null;
        } else {
            freeIndex--;
            return data[freeIndex];
        }
    }

    @Override
    public String peek() {
        if(isEmpty()){
            return null;
        }

        return data[freeIndex - 1];
    }

    @Override
    public boolean isEmpty() {
        return freeIndex == 0;
    }

    public static void main(String[] args) {
        StringStack test = new StringStack();
        test.push("Test");
        test.push("world");
        System.out.println(test.pop());
        test.push("example");
        System.out.println(test.peek());
        System.out.println(test.pop());

        StringStack studenti3E = new StringStack();
        studenti3E.push("Honza A.");
        studenti3E.push("Honza B.");
        studenti3E.push("Honza C.");
        studenti3E.push("Honza D.");

        System.out.println(studenti3E.pop());

        for (int i = 0; i < 100_000; i++) {
            test.push("Hippopotomonstrosequlepedaliophobia");
        }

        System.out.println(test.data.length);
    }
}
