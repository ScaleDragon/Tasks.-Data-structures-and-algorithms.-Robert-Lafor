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

    /*
     3.5. Измените метод insertionSort() в программе insertSort.java (листинг 3.3),
чтобы он подсчитывал количество копирований и сравнений в ходе сортировки,
а затем выводил полученные результаты. Для подсчета сравнений необходимо раз
бить надвое сложное условие во внутреннем цикле while. Используйте программу
для измерения количества копирований и сравнения для разных объемов данных,
отсортированных в обратном порядке. Подтверждают ли результаты теоретическую
сложность O(N^2)? Проделайте то же самое для почти отсортированных данных
(в которых только несколько элементов находятся не на своих местах). Какие выво
ды можно сделать об эффективности этого алгоритма для почти отсортированных
данных?
     */
    public void insertionSort() {
        int in, out, numberCopies = 0, numberComparisons = 0;
        for (out = 1; out < nElems; out++)     // out - разделительный маркер
        {
            long temp = a[out];            // Скопировать помеченный элемент
            numberCopies++;
            in = out;                      // Начать перемещения с out
            while (in > 0) // Пока не найден меньший элемент
            {
                if (a[in - 1] >= temp) {
                    a[in] = a[in - 1];            // Сдвинуть элемент вправо
                    numberComparisons++;
                    --in;                       // Перейти на одну позицию влево
                } else {
                    break;
                }
            }
            a[in] = temp;                  // Вставить помеченный элемент
        }
        System.out.println("Кол-во копирований: " + numberCopies);
        System.out.println("Кол-во сравнений: " + numberComparisons);
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
            long temp = a[out];            // Скопировать помеченный элемент        //77 99 44 55 22 22 22 88 11 0 66 33 11 11 11
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
            int numberCoincidence = 0;  // кол-во совпадений
            int firstCoincidence;       // первое совпадение
            /**
             * Если значение равно -1, увеличить кол-во совпадений и перейти к следующему
             */
            for (int k = 0; k < nElems; k++) {
                firstCoincidence = k;
                while (a[k] == -1) {
                    numberCoincidence++;
                    k++;
                }
                /**
                 * Если кол-во совпадений больше 0 переместить все значения влево на позицию равную numberСoincidence
                 */
                if (numberCoincidence > 0) {
                    while (k != nElems) {
                        a[firstCoincidence] = a[k];
                        firstCoincidence++;
                        k++;
                    }
                    System.out.println("The number of coincidences: " + numberCoincidence);
                }
                /**
                 * Ненужные значения установить в null и уменьшить кол-во элемнтов
                 */
                for (k = nElems - 1; numberCoincidence > 0; k--) {
                    a[k] = 0;
                    nElems--;
                    numberCoincidence--;
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
        arr.insert(00);
        arr.insert(11);
        arr.insert(11);
        arr.insert(11);
        arr.insert(22);
        arr.insert(22);
        arr.insert(22);
        arr.insert(77);               // Вставка 10 элементов
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(88);
        arr.insert(11);
        arr.insert(66);
        arr.insert(33);

//        for (int j = 0; j < maxSize; j++) // Заполнение массива
//        { // случайными числами
//            long n = (long) (java.lang.Math.random() * (maxSize - 1));
//            arr.insert(n);
//        }
        arr.display();                                     // Вывод элементов
        long firstTime = System.currentTimeMillis();
//        arr.reversInsertionSort();                       // Сортировка в обратном порядке
        arr.insertionSort();                               // Сортировка методом вставки
//        arr.display();                                   // Повторный вывод после сортировки
//        arr.size();                                      // Размер массива
//        arr.noDups();                                    // Удаляет дубликаты из ранее отсортированного массива
        arr.display();                                     // Повторный вывод
//        arr.size();
        long secondTime = System.currentTimeMillis();
        System.out.println("Time " + (secondTime - firstTime) / 1000);    // Время работы программы
//        System.out.println(arr.median());
    }
}
////////////////////////////////////////////////////////////////
