package Data_Structures_and_Algorithms_Robert_LaForte.chapter_4.StackAndQueu;

import java.util.Arrays;

/*
 4.3. Напишите реализацию стека на базе класса Deque из п. 4.2. Класс стека должен
 поддерживать те же методы и возможности, что и класс StackX в программе
stack.java (см. листинг 4.1).
 */

/**
 * Реализация стека на базе Deque из п. 4.2 использует двустороннюю реализацию, при этом
 * по правилам стека можно использовать одновременно только одну сторону(левую или правую). Проверка происходит
 * в методах pop(), push() и peek(). Для каждой стороны (левой или правой) используется свой метод.
 */
public class DequeStack {
    private long[] dequeStack;
    private int maxSize;
    private int right;
    private int left;
    private int nItems;

    public DequeStack(int size) {
        maxSize = size;
        dequeStack = new long[maxSize];
        right = -1;
        left = -1;
        nItems = 0;
    }

    //----------------------------------------------- методы для правой части Deque
    public void pushRight(long v) {
        if (!isFull()) {
            if (left == -1) {                      // проверка если left не используется
                dequeStack[++right] = v;
                nItems++;
            } else {
                System.out.println("The left side of the line is used to fill the stack");  // Используется левая сторона очереди для заполнения стека
            }
        }
    }

    public long popRight() {
        if (!isEmpty()) {
            if (left == -1) {                     // проверка если left не используется
                nItems--;
                return dequeStack[right--];
            } else {
                System.out.print("The left side of the line is used to fill the stack: ");  // Используется левая сторона очереди для заполнения стека
            }
        }
        return -1;
    }

    public long peekRight() {
        if (left == -1) {
            return dequeStack[right];                // получение верхнего значения
        } else {
            System.out.print("The left side of the line is used to fill the stack: ");  // Используется левая сторона очереди для заполнения стека
        }
        return -1;
    }

    //------------------------------------------------------ методы для левой части Deque

    public void pushLeft(long v) {
        if (!isFull()) {
            if (right == -1) {                   // проверка если right не используется
                if (left == -1) {
                    left = maxSize;
                }
                dequeStack[--left] = v;
                nItems++;
            } else {
                System.out.println("The right side of the line is used to fill the stack");  // Используется левая сторона очереди для заполнения стека
            }
        }
    }

    public long popLeft() {
        long temp = -1;
        if (!isEmpty()) {
            if (right == -1) {                  // проверка если right не используется
                temp = dequeStack[left++];
                nItems--;
                if (left == maxSize) {      // вернуть индекс left на -1, чтобы использовать right при не используемом left
                    left = -1;
                }
                return temp;
            } else {
                System.out.println("The left side of the line is used to fill the stack: ");  // Используется левая сторона очереди для заполнения стека
            }
        }
        return temp;
    }

    public long peekLeft() {
        if (right == -1) {                          // проверка если right не используется
            return dequeStack[left];               // получение верхнего значения
        } else {
            System.out.print("The right side of the line is used to fill the stack: ");
        }
        return -1;
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public int size() {
        return nItems;
    }

    @Override
    public String toString() {
        return "DequeStack: " +
                Arrays.toString(dequeStack);
    }
}

class DequeStakApp {

    public static void main(String[] args) {
        DequeStack dequeStack = new DequeStack(5);

        //-------------------------- проверка левой части Deque
        System.out.println("проверка левой части Deque ");
        dequeStack.pushLeft(10);
        dequeStack.pushRight(20);
        dequeStack.pushLeft(30);
        dequeStack.pushLeft(40);

        System.out.println(dequeStack.peekRight());
        System.out.println(dequeStack.peekLeft());

        dequeStack.pushLeft(50);
        dequeStack.pushLeft(60);
        System.out.println(dequeStack);
        System.out.println("Size dequeStack: " + dequeStack.size());
        while (!dequeStack.isEmpty()) {
            System.out.print(dequeStack.popLeft() + " ");
        }
        System.out.println("\n-----------------------");

        //-------------------------- проверка правой части Deque
        System.out.println("проверка правой части Deque ");
        dequeStack.pushRight(100);
        dequeStack.pushLeft(200);
        dequeStack.pushRight(300);

        System.out.println(dequeStack.peekRight());
        System.out.println(dequeStack.peekLeft());

        dequeStack.pushRight(400);
        dequeStack.pushRight(500);
        dequeStack.pushRight(600);
        System.out.println(dequeStack);
        System.out.println("Size dequeStack: " + dequeStack.size());
        while (!dequeStack.isEmpty()) {
            System.out.print(dequeStack.popRight() + " ");
        }
    }
}
