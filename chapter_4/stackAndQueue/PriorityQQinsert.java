package Data_Structures_and_Algorithms_Robert_LaForte.chapter_4.stackAndQueue;

/*
 4.4. Реализация приоритетной очереди из листинга 4.6 обеспечивает быстрое
извлечение высокоприоритетных элементов, но вставка новых элементов выполняется
относительно медленно. Напишите программу с видоизмененным классом
PriorityQ, быстро выполняющим вставку (за время O(1)) с медленным извлечением
высокоприоритетного элемента. Включите метод для вывода содержимого
приоритетной очереди (см. п. 4.1).
 */

import java.util.Arrays;

public class PriorityQQinsert {           // class Priority queue with a quick insert
    private int maxSize;
    private long[] queArray;
    private int nItems;

    public PriorityQQinsert(int size) {
        maxSize = size;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long v) {          // вставка значения в конец очереди
        if (!isFull()) {
            queArray[nItems++] = v;
        }
    }

    public long remove() {                 // извлечение  минимального приоритетного значения
        if (!isEmpty()) {
            if (nItems == 0) {              // если очередь содержит одно значение
                return queArray[nItems--];  // вернуть это единственное значение
            } else {
                long priorityElement = queArray[0];
                int indexPriority = 0;               // индекс, где находится приоритетное значение
                for (int j = 0; j < nItems; j++) {
                    int nextValue = j + 1;
                    if (nextValue != nItems && priorityElement > queArray[nextValue]) {   // сравнение текущего значения с следующим по порядку
                        priorityElement = queArray[j + 1];                                // присвоить переменной минимальное значение
                        indexPriority = j + 1;                    // присвоить переменной индекс минимального значения
                    }
                }
                for (int i = indexPriority; i < nItems - 1; i++) {
                    queArray[i] = queArray[i + 1];                 // перемещение оставшихся значений в лево, на место минимального значения
                }
                nItems--;                // уменьшение количества элементов
                return priorityElement;
            }
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

    public void displayArray() {
        long value = 0;
        System.out.print("[");
        for (int i = 0; i <= nItems - 1; i++) {
            value = queArray[i];
            System.out.print(value);
            if (i < nItems - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        return "PriorityQQinsert " + Arrays.toString(queArray);
    }
}

class PriorityQQinsertApp {
    public static void main(String[] args) {
        PriorityQQinsert priorityQQinsert = new PriorityQQinsert(5);
        priorityQQinsert.insert(30);
        priorityQQinsert.insert(50);
        priorityQQinsert.insert(10);
        priorityQQinsert.insert(40);
        priorityQQinsert.insert(20);


        while (!priorityQQinsert.isEmpty()) {
            System.out.print("Элементы массива: ");
            priorityQQinsert.displayArray();
            System.out.println("Priority value: " + priorityQQinsert.remove());
            System.out.print("Массив после получения приоритетного числа: ");
            priorityQQinsert.displayArray();
            System.out.println("-------------------------------------------");
        }
    }
}
