package Data_Structures_and_Algorithms_Robert_LaForte.arras;

// highArray.java
// Класс массива с высокоуровневым интерфейсом
// Запуск программы: C>java HighArrayApp
////////////////////////////////////////////////////////////////
public class HighArray {
    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов в массиве

    //-----------------------------------------------------------
    public HighArray(int max) // Конструктор
    {
        a = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }

    public int size(){
        System.out.println(nElems);
        return nElems;
    }

    //-----------------------------------------------------------
    public boolean find(long searchKey) { // Поиск заданного значения
        int j;
        for (j = 0; j < nElems; j++) // Для каждого элемента
            if (a[j] == searchKey) // Значение найдено?
                break; // Да - выход из цикла
        if (j == nElems) // Достигнут последний элемент?
            return false; // Да
        else
            return true; // Нет
    }

    //-----------------------------------------------------------
    public void insert(long value) // Вставка элемента в массив
    {
        a[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) // Поиск заданного значения
            if (value == a[j])
                break;
        if (j == nElems) // Найти не удалось
            return false;
        else // Значение найдено
        {
            for (int k = j; k < nElems; k++) // Сдвиг последующих элементов
                a[k] = a[k + 1];
            nElems--; // Уменьшение размера
            return true;
        }
    }

    //-----------------------------------------------------------
    public void display() // Вывод содержимого массива
    {
        for (int j = 0; j < nElems; j++) // Для каждого элемента
            System.out.print(a[j] + " "); // Вывод
        System.out.println("");
    }

    // Программные проекты
    // 2.1 Добавьте в класс HighArray из програмы highArray.java (листинг 2.3) метод
    //getMax(), который возвращает наибольшее значение ключа в массиве или –1, если
    //массив пуст. Добавьте в main() код для тестирования нового метода. Считайте, что
    //все ключи являются положительными числами.
    public long getMax() {
        long maxValue = 0;
        if (nElems != 0) {
            for (int i = 0; i < nElems; i++) {
                if (maxValue < a[i]) {
                    maxValue = a[i];
                }
            }
            return maxValue;
        }
        return -1;
    }

    //2.2 Измените метод из пункта 2.1 так, чтобы элемент с наибольшим ключом не
    //только возвращался методом, но и удалялся из массива. Присвойте новой версии
    //имя removeMax().
    public long[] removeMax() {
        long maxValue = 0;
        int indexMaxValue = 0;
        if (nElems != 0) {
            for (int i = 0; i < nElems; i++) {
                if (maxValue < a[i]) {
                    maxValue = a[i];
                    indexMaxValue = i;
                }
            }
            for (int i = indexMaxValue; i < nElems; i++) {
                a[i] = a[i + 1];
            }
            nElems--;
        }
        // 2.3. Метод removeMax() из пункта 2.2 может использоваться для сортировки
        //содержимого массива по ключу. Реализуйте алгоритм сортировки, который не изменяет класса HighArray
        // (а изменяет только код main()). Вам потребуется второй массив для хранения отсортированных данных.
        // (Этот алгоритм представляет собой крайне примитивную разновидность сортировки методом выбора, описанной
        //в главе 3, «Простая сортировка».)
        long[] arrSort = a;
        for (int i = 0; i < nElems - 1; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (arrSort[j] < arrSort[i]) {
                    long temp = arrSort[i];
                    arrSort[i] = arrSort[j];
                    arrSort[j] = temp;
                }
            }
        }
        return arrSort;
    }

    /*
        2.6. Добавьте в класс HighArray программы highArray.java (листинг 2.3) метод
        noDups(), удаляющий все дубликаты из массива. Другими словами, если массив
        содержит три элемента с ключом 17, метод noDups() должен удалить два из них. Не
        беспокойтесь о сохранении порядка элементов. Одно из возможных решений —
        сравнить каждый элемент со всеми остальными элементами и заменить все дубликаты null
        (или другим значением, не встречающимся среди реальных ключей),
        после чего удалить из массива все вхождения null. Конечно, размер массива при
        этом уменьшится.
     */
    public void noDups() {
        int duplicate=0;
        for (int i = 0; i < nElems; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] == a[j] && a[i] != -1) {
                    a[j] = -1;
                    duplicate++;
                }
            }
        }
        System.out.println("duplicate: " + duplicate);
        for (int i = 0; i <= nElems; i++) {
            if (a[i]==-1){
                for (int j = i+1; j <= nElems ; j++) {
                    a[i]=a[j];
                    i++;
                }
                nElems-=duplicate;
            }
        }

    }
//-----------------------------------------------------------
} // Конец класса HighArray
////////////////////////////////////////////////////////////////

class HighArrayApp {
//    public long[] selectionSort(HighArray arr) {
//        long[] arrSort = new long[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[i]) {
//                    long temp = arr[j];
//                    arr[i] = arr[j];
//                    arr[i] = temp;
//                }
//            }
//            arrSort[i] = arr[i];
//        }
//        return arrSort;
//    }

    public static void main(String[] args) {
        int maxSize = 100; // Размер массива
        HighArray arr; // Ссылка на массив
        arr = new HighArray(maxSize); // Создание массива
        HighArrayApp arrSort = new HighArrayApp();
        arr.insert(77); // Вставка 10 элементов
        arr.insert(99);
        arr.insert(22);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(33);
        arr.insert(22);

        arr.display(); // Вывод элементов
        arr.size();
        arr.noDups();
        arr.display();
        arr.size();

//        int searchKey = 35; // Поиск элемента
//        if (arr.find(searchKey))
//            System.out.println("Found " + searchKey);
//        else
//            System.out.println("Can't find " + searchKey);
//        arr.delete(00); // Удаление трех элементов
//        arr.delete(55);
//        arr.delete(99);
//        arr.display(); // Повторный вывод
//        System.out.println("maxValue " + arr.getMax());
//        arr.removeMax();
//        arr.display(); // Повторный вывод
    }
} // Конец класса HighArrayApp
////////////////////////////////////////////////////////////////