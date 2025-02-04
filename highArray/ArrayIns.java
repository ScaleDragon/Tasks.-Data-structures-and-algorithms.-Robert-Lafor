package Data_Structures_and_Algorithms_Robert_LaForte.highArray;

// insertSort.java
// Сортировка методом вставки
// Запуск программы: C>java InsertSortApp
//-------------------------------------------------------------
class ArrayIns {
    private long[] a;                 // Ссылка на массив a
    private int nElems;               // Количество элементов данных

    //-------------------------------------------------------------
    public ArrayIns(int max)          // Конструктор
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
    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++)     // out - разделительный маркер
        {
            long temp = a[out];            // Скопировать помеченный элемент
            in = out;                      // Начать перемещения с out
            while (in > 0 && a[in - 1] >= temp) // Пока не найден меньший элемент
            {
                a[in] = a[in - 1];            // Сдвинуть элемент вправо
                --in;                       // Перейти на одну позицию влево
            }
            a[in] = temp;                  // Вставить помеченный элемент
        }
    }

    /*   2.Напишите код для вставки данных, отсортированных в обратном порядке
         (99 999, 99 998, 99,997, …), в программу bubbleSort.java. Используйте такой же
         объем данных, как в упражнении 1. Повторите эксперимент с программами
         selectSort.java и insertSort.java.
*/
    public void reversInsertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++)     // out - разделительный маркер
        {
            long temp = a[out];            // Скопировать помеченный элемент
            in = out;                      // Начать перемещения с out
            while (in > 0 && a[in - 1] <= temp) // Пока не найден меньший элемент
            {
                a[in] = a[in - 1];            // Сдвинуть элемент вправо
                --in;                       // Перейти на одну позицию влево
            }
            a[in] = temp;                  // Вставить помеченный элемент
        }
    }

    //-------------------------------------------------------------
}  // Конец класса ArrayIns

////////////////////////////////////////////////////////////////
class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 10_000;            // Размер массива
        ArrayIns arr;                 // Ссылка на массив
        arr = new ArrayIns(maxSize);  // Создание массива
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
//        arr.insertionSort();          // Сортировка методом вставки
        arr.reversInsertionSort();
        arr.display();                // Повторный вывод
        long secondTime = System.currentTimeMillis();
        arr.display();                // Повторный вывод
        System.out.println("Time " + (secondTime - firstTime)/1000);
    }
}
////////////////////////////////////////////////////////////////
