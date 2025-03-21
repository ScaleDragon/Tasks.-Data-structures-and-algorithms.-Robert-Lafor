package Data_Structures_and_Algorithms_Robert_LaForte.chapter_4.StackAndQueu;

import java.util.Arrays;

/*
4.2. Создайте класс Deque по описанию деков (двусторонних очередей) в этой
главе. Класс должен содержать методы insertLeft(), insertRight(), removeLeft(),
removeRight(), isEmpty() и isFull(). Также в нем должна быть реализована поддержка
циклического переноса индексов, по аналогии с очередями.
 */
class Deque {
    private int maxSize;
    private long[] dequeArray;
    private int left;
    private int right;
    private int nItems;

    public Deque(int size) {
        maxSize = size;
        dequeArray = new long[maxSize];
        left = 0;
        right = 0;
        nItems = 0;
    }

    public void insertLeft(long v) {
        if (!isFull()) {
            if (left == -1) {
                left = maxSize - 1;           // Циклический перенос начала очереди
            }
            dequeArray[left--] = v;       // Вставка значения
            nItems++;
        } else {
            System.out.println("The queue is full ");
            System.out.println("For the number (" + v + ") there is no free cell");
        }
    }

    public void insertRight(long v) {
        if (!isFull()) {
            if (right == maxSize - 1) {
                right = 0;               // Циклический перенос конца очереди
            }
            dequeArray[++right] = v;      // Вставка значения
            nItems++;
        } else {
            System.out.println("The queue is full ");
            System.out.println("For the number (" + v + ") there is no free cell");
        }
    }

    public long removeLeft() {
        System.out.print("The method \"removeLeft\" deleted the number: ");
        long tempLeft = -1;
        if (!isEmpty()) {
            tempLeft = dequeArray[++left];           // Выборка и увеличение left
            if (left == maxSize - 1) {
                left = -1;
            }
            nItems--;
        } else {
            System.out.println("The queue is empty ");
            return -1;
        }
        return tempLeft;
    }

    public long removeRight() {
        System.out.print("The method \"removeRight\" deleted the number: ");
        long tempRight = -1;
        tempRight = dequeArray[right--];             // Выборка и уменьшение right
        if (!isEmpty()) {
            if (right == -1) {
                right = maxSize - 1;
            }
            nItems--;
        } else {
            System.out.println("The queue is empty ");
            return -1;
        }
        return tempRight;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }

    @Override
    public String toString() {
        return "Deque: " + Arrays.toString(dequeArray);
    }
}
//-------------------------------------------------------------
// Конец класса Deque

class DequeApp {
    public static void main(String[] args) {
        Deque theDeque = new Deque(6);          // Очередь из 5 ячеек
        System.out.println(theDeque.isEmpty());
        theDeque.insertLeft(10);                 // Вставка 5 элементов
        theDeque.insertLeft(20);
        theDeque.insertLeft(30);
        theDeque.insertRight(40);
        theDeque.insertRight(50);
        System.out.println(theDeque);

        theDeque.insertRight(70);           // Добавление ещё 2-х элементов
        theDeque.insertLeft(90);            // Проверка на отсутствие свободной ячейки

        System.out.println(theDeque);
        while (!theDeque.isEmpty()) {
            System.out.println(theDeque.removeRight());              // Извлечение всех элементов removeRight()/removeLeft()
            System.out.println(theDeque.removeLeft());
        }
    }
}

