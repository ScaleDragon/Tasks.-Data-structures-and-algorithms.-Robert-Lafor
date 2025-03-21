package Data_Structures_and_Algorithms_Robert_LaForte.chapter_3.arras;

// selectSort.java
// Сортировка методом выбора
// Запуск программы: C>java SelectSortApp
////////////////////////////////////////////////////////////////
class ArraySel {
    private long[] a;                 // Ссылка на массив a
    private int nElems;               // Количество элементов данных

    //-------------------------------------------------------------
    public ArraySel(int max)          // Конструктор
    {
        a = new long[max];             // Создание массива
        nElems = 0;                    // Пока нет ни одного элемента
    }

    //-------------------------------------------------------------
    public void insert(long value)    // Вставка элемента в массив
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
    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++)   // Внешний цикл
        {
            min = out;                     // Минимум
            for (in = out + 1; in < nElems; in++) // Внутренний цикл
                if (a[in] < a[min]) {         // Если значение min больше,
                    min = in;                // значит, найден новый минимум
                }
            swap(out, min);                // swap them
        }
    }

    /*   2.Напишите код для вставки данных, отсортированных в обратном порядке
         (99 999, 99 998, 99,997, …), в программу bubbleSort.java. Используйте такой же
         объем данных, как в упражнении 1. Повторите эксперимент с программами
         selectSort.java и insertSort.java.
*/
    public void reversSelectionSort() {
        int out, in, max;
        for (out = 0; out < nElems - 1; out++)   // Внешний цикл
        {
            max = out;                     // Минимум
            for (in = out + 1; in < nElems; in++) // Внутренний цикл
                if (a[in] > a[max]) {         // Если значение min больше,
                    max = in;                // значит, найден новый минимум
                }
            swap(out, max);                // swap them
        }
    }

    //-------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
    //-------------------------------------------------------------
}

////////////////////////////////////////////////////////////////
class SelectSortApp {
    public static void main(String[] args) {
        int maxSize = 100_000;            // Размер массива
        ArraySel arr;                 // Ссылка на массив
        arr = new ArraySel(maxSize);  // Создание массива
//        arr.insert(77);               // Вставка 10 элементов
//        arr.insert(99);
//        arr.insert(44);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);
        for (int j = 0; j < maxSize; j++) // Заполнение массива
        { // случайными числами
            long n = (long) (java.lang.Math.random() * (maxSize - 1));
            arr.insert(n);
        }

//        arr.display();                // Вывод элементов
        long firstTime = System.currentTimeMillis();
//        arr.selectionSort();          // Сортировка методом выбора
        arr.reversSelectionSort();    // Сортировка  обратном порядке методом выбора
        arr.display();                // Повторный вывод
        long secondTime = System.currentTimeMillis();
//        arr.display();                // Повторный вывод
        System.out.println("Time " + (secondTime - firstTime) / 1000);
    }
}  // Конец класса SelectSortApp
////////////////////////////////////////////////////////////////
