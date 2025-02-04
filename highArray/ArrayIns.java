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

    public int size() {
        System.out.println("Size massive: " + nElems);
        return nElems;
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

    /*
2.Напишите код для вставки данных, отсортированных в обратном порядке
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

    /*
3.2. Добавьте в класс ArrayIns программы insertSort.java (листинг 3.3) метод
с именем median(), возвращающий медиану массива. (Напомним, что в группе чисел
половина меньше медианы, а другая половина больше.) Найдите простое решение
этой задачи.
     */
    public long median() {
        long median;
        int centerOfTheArray;
        if (nElems % 2 != 0) {
            centerOfTheArray = nElems / 2;
            return a[centerOfTheArray];
        } else {
            centerOfTheArray = (nElems / 2);
            median = (a[centerOfTheArray] + a[centerOfTheArray - 1]) / 2;
            return median;
        }
    }

    /*
     3.3. Добавьте в программу insertSort.java (листинг 3.3) метод noDups(), который
удаляет дубликаты из ранее отсортированного массива без нарушения порядка
элементов. (Используйте метод insertionSort() для сортировки данных или просто
вставьте данные в порядке сортировки в main().) Нетрудно представить себе схему,
в которой все элементы от позиции обнаружения дубликата до конца массива сдвигаются
на одну позицию, но это замедлит работу алгоритма до времени O(N^2) —
по крайней мере при большом количестве дубликатов. Проследите за тем, чтобы
в вашем алгоритме ни один элемент не перемещался более одного раза независимо
 от количества дубликатов — это обеспечит выполнение алгоритма за время O(N ).
     */
    public long[] noDups() {
        int lastСoincidence;
        if (nElems != 0) {
            for (int i = 0; i < nElems - 1; i++) {                  //0 0 11 11 22 33 44 55 66 77 88 99
                for (int j = i + 1; j < nElems; j++) {
                    int firstIndexСoincidence = 0;
                    if (a[i] == a[j]) {
                        firstIndexСoincidence++;
                    }
                    if (firstIndexСoincidence > 0) {
                        for (int k = j; k < nElems; k++) {
                            a[k - 1] = a[j++];
                        }
                        a[nElems - 1] = 0;
                        nElems -= firstIndexСoincidence;
                    }
                }
            }
        }
        return a;
    }

//-------------------------------------------------------------
}  // Конец класса ArrayIns

////////////////////////////////////////////////////////////////
class InsertSortApp {
    public static void main(String[] args) {
        int maxSize = 10_000;            // Размер массива
        ArrayIns arr;                 // Ссылка на массив
        arr = new ArrayIns(maxSize);  // Создание массива
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
        arr.insert(11);
        arr.insert(00);

//        for (int j = 0; j < maxSize; j++) // Заполнение массива
//        { // случайными числами
//            long n = (long) (java.lang.Math.random() * (maxSize - 1));
//            arr.insert(n);
//        }
        arr.display();                                   // Вывод элементов
        long firstTime = System.currentTimeMillis();
//        arr.insertionSort();                           // Сортировка методом вставки
        arr.reversInsertionSort();
        arr.display();                                   // Повторный вывод после сортировки
        arr.size();                                      // размер массива
        arr.noDups();
        arr.display();                                   // Повторный вывод
        arr.size();
        long secondTime = System.currentTimeMillis();
        System.out.println("Time " + (secondTime - firstTime) / 1000);
        System.out.println(arr.median());
    }
}
////////////////////////////////////////////////////////////////
