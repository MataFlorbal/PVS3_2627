package Vyuka.OOP.adts;

public class QueuePractice {
    public static void main(String[] args) {
        StringQueue queue = new StringQueue();
        queue.enqueue("Test");
        queue.enqueue("Dalsi");
        queue.enqueue("slovo");
        System.out.println(queue.peek());
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Another");
        System.out.println(queue.peek());
        System.out.println(queue.getSize());

        StringQueue roulette = new StringQueue();
        roulette.enqueue("Honza");
        roulette.enqueue("Milan");
        roulette.enqueue("Marek");
        roulette.enqueue("Bohm");
        roulette.enqueue("Jessie");
        roulette.enqueue("Horvath");

        String onTurn;
        while (roulette.getSize() > 1) {
            onTurn = roulette.dequeue();

            if (Math.random() > 0.16){
                roulette.enqueue(onTurn);
            }
        }
    }
}
