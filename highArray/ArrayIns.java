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
        System.out.println("The number of elements in the array: " + nElems);
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
        if (nElems != 0) {
            int i, j;
            /**
             * Поиск совпадений в массиве, если найдено присвоить ему значение -1
             */
            for (i = 0; i < nElems - 1; i++) {
                for (j = i + 1; j < nElems; j++) {
                    if (a[i] == a[j]) {
                        a[j] = -1;
                    } else {
                        break;
                    }
                }
            }
            /**
             * сортировка массива
             */
            insertionSort();
            int numberСoincidence = 0;
            int firstСoincidence = 0;
            /**
             * Если значение равно -1, увеличить кол-во совпадений и перейти к следующему
             */
            for (int k = 0; k < nElems; k++) {
                firstСoincidence = k;
                while (a[k] == -1) {
                    numberСoincidence++;
                    k++;
                }
                /**
                 * Если кол-во совпадений больше 0 переместить все значения влево на позицию равную numberСoincidence
                 */
                if (numberСoincidence > 0) {
                    while (k != nElems) {
                        a[firstСoincidence] = a[k];
                        firstСoincidence++;
                        k++;
                    }
                }
                /**
                 * Ненужные значения установить в null и уменьшить кол-во элемнтов
                 */
                for (k = nElems - 1; numberСoincidence > 0; k--) {
                    a[k] = 0;
                    nElems--;
                    numberСoincidence--;
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
        arr.insert(22);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(11);
        arr.insert(11);
        arr.insert(11);

//        for (int j = 0; j < maxSize; j++) // Заполнение массива
//        { // случайными числами
//            long n = (long) (java.lang.Math.random() * (maxSize - 1));
//            arr.insert(n);
//        }
        arr.display();                                   // Вывод элементов
        long firstTime = System.currentTimeMillis();
        arr.insertionSort();                           // Сортировка методом вставки
//        arr.reversInsertionSort();
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
