package Data_Structures_and_Algorithms_Robert_LaForte.highArray;

// bubbleSort.java
// Пузырьковая сортировка
// Запуск программы: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
    private long[] a;                 // Ссылка на массив a
    private int nElems;               // Количество элементов данных

    //-------------------------------------------------------------
    public ArrayBub(int max)          // Конструктор
    {
        a = new long[max];             // Создание массива
        nElems = 0;                    // Пока нет ни одного элемента
    }

    //-------------------------------------------------------------
    public void insert(long value)    // Вставка элемента в массив стандартная
    {
        a[nElems] = value;             // Собственно вставка
        nElems++;                      // Увеличение размера
    }

    //-------------------------------------------------------------
    public void display()             // Вывод содержимого массива
    {
        for (int j = 0; j < nElems; j++)       // Для каждого элемента
            System.out.print(a[j] + " ");  // Вывод
        System.out.println("");
    }

    //-------------------------------------------------------------
    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--)   // Внешний цикл (обратный)
            for (in = 0; in < out; in++)        // Внутренний цикл (прямой)
                if (a[in] > a[in + 1])       // Порядок нарушен?
                    swap(in, in + 1);          // Поменять местами
    }

    /*
     3.1. В программе bubbleSort.java (листинг 3.1) и в приложении BubbleWort Work
     BubbleWort shop индекс in всегда перемещается слева направо, находит наибольший элемент
     и перемещает его к позиции out справа. Измените метод bubbleSort() так, чтобы
     в нем выполнялись двусторонние перемещения, иначе говоря, индекс in сначала,
     как и прежде, переносит наибольший элемент слева направо, но затем он меняет
     направление и переносит наименьший элемент справа налево. Вам понадобятся
     два внешних индекса: справа (старый индекс out) и слева.
     */
    public void alternativeSort() {
        int rightOut, in, leftOuter;
        for (rightOut = nElems - 1, leftOuter = 0; rightOut > 0; rightOut--, leftOuter++) {
            for (in = 0; in < rightOut; in++) {
                if (a[in] > a[in + 1]) {
                    long temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                    if (a[in] < a[leftOuter]) {   // затем он меняет направление и переносит наименьший элемент справа налево
                        temp = a[in];
                        a[in] = a[leftOuter];
                        a[leftOuter] = temp;
                    }
                }
            }
        }
    }

    //=======================================================================================
    /*
     2. Напишите код для вставки данных, отсортированных в обратном порядке
    (99 999, 99 998, 99,997, …), в программу bubbleSort.java. Используйте такой же
    объем данных, как в упражнении 1. Повторите эксперимент с программами
    selectSort.java и insertSort.java.
     */
    public void reversBubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 0; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] < a[in + 1]) {
                    long temp = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = temp;
                }
            }
        }
    }

    //-------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//-------------------------------------------------------------
}  // Конец класса ArrayBub

////////////////////////////////////////////////////////////////
class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100_000;            // Размер массива
        ArrayBub arr;                 // Ссылка на массив
        arr = new ArrayBub(maxSize);  // Создание массива
        arr.insert(77);               // Вставка 10 элементов
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
//        for (int j = 0; j < maxSize; j++) // Заполнение массива случайными числами
//        {
//            long n = (long) (java.lang.Math.random() * (maxSize - 1));
//            arr.insert(n);
//        }
//        arr.display();                // Вывод элементов
        long firstTime = System.currentTimeMillis();
        arr.bubbleSort();
//        arr.alternativeSort();             // Пузырьковая сортировка элементов
        long secondTime = System.currentTimeMillis();
        arr.display();                // Повторный вывод
        System.out.println("Time " + (secondTime - firstTime) / 1000);
    }  //
}  // Конец класса BubbleSortApp
////////////////////////////////////////////////////////////////