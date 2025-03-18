package Data_Structures_and_Algorithms_Robert_LaForte.arras;

// orderedArray.java
// Работа с классом упорядоченного массива
// Запуск программы: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray {
    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов данных

    //-----------------------------------------------------------
    public OrdArray(int max) // Конструктор
    {
        a = new long[max]; // Создание массива
        nElems = 0;
    }

    //-----------------------------------------------------------
    public int size() {
        return nElems;
    }

    //-----------------------------------------------------------
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn; // Элемент найден
            else if (lowerBound > upperBound)
                return nElems; // Элемент не найден
            else // Деление диапазона
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // В верхней половине
                else
                    upperBound = curIn - 1; // В нижней половине
            }
        }
    }

    //-----------------------------------------------------------

    public void insert(long value) // Вставка элемента в массив
    {
        int j;
        for (j = 0; j < nElems; j++) { // Определение позиции вставки
            if (a[j] > find(value)) { // линейный поиск - замена на двоичный
                break;
            }
        }
        for (int k = nElems; k > j; k--) { // Перемещение последующих элементов
            a[k] = a[k - 1];
        }
        a[j] = value; // Вставка
        sortArray();
        nElems++; // Увеличение размера
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) // Найти не удалось
            return false;
        else // Элемент найден
        {
            for (int k = j; k < nElems; k++) // Перемещение последующих элементов
                a[k] = a[k + 1];
            nElems--; // Уменьшение размера
            return true;
        }
    }

    //-----------------------------------------------------------
    public void display() // Вывод содержимого массива
    {
        for (int j = 0; j < nElems; j++) // Перебор всех элементов
            System.out.print(a[j] + " "); // Вывод текущего элемента
        System.out.println("");
    }
    //-----------------------------------------------------------

    // 2.4. Измените программу orderedArray.java (листинг 2.4) так, чтобы методы insert() и delete(), а также
    //метод find() использовали двоичный поиск(как предлагается в тексте).

    public long[] sortArray() {
        if (nElems != 0) {
            for (int i = 0; i <= nElems - 1; i++) {
                for (int j = i + 1; j <= nElems; j++) {
                    if (a[i] > a[j]) {
                        long temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }
        return a;
    }

    /*
    2.5. Добавьте в класс OrdArray программы orderedArray.java (листинг 2.4) метод
merge(), объединяющий два упорядоченных исходных массива в один упорядоченный приемный массив. Включите в main()
 фрагмент кода, который заполняет два исходных массива случайными числами, вызывает merge() и выводит содержимое
полученного массива. Исходные массивы могут содержать разное количество элементов. Ваш алгоритм должен сравнивать ключи
исходных массивов и копировать меньший в приемный массив. Также необходимо предусмотреть ситуацию, когда элементы
в одном исходном массиве заканчиваются раньше, чем в другом.
     */
    public static long[] merge(OrdArray arr1, OrdArray arr2) {
        long[] b = new long[arr1.nElems + arr2.nElems];
        int i = 0, j = 0, k = 0;
        while (i < arr1.nElems && j < arr2.nElems) {
            if (arr1.a[i] < arr2.a[j]) {
                b[k++] = arr1.a[i++];
            } else {
                b[k++] = arr2.a[j++];
            }
        }
        while (i < arr1.nElems) {
            b[k++] = arr1.a[i++];
        }
        while (i < arr2.nElems) {
            b[k++] = arr2.a[i++];
        }
        for (long nums : b) {
            System.out.print(nums + " ");
        }
        System.out.println();
        return b;
    }
}

////////////////////////////////////////////////////////////////
class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100; // Размер массива
        OrdArray arr; // Ссылка на массив
        arr = new OrdArray(maxSize); // Создание массива
        OrdArray arr2; // Ссылка на массив
        arr2 = new OrdArray(10); // Создание массива 2
        arr.insert(77); // Вставка 10 элементов
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        //============================================
        arr2.insert(7); // Вставка 5 элементов
        arr2.insert(9);
        arr2.insert(4);
        arr2.insert(5);
        arr2.insert(2);

        arr.display();
        arr2.display();
        OrdArray.merge(arr, arr2);

        int searchKey = 55; // Поиск элемента
        if (arr.find(searchKey) != arr.size()) {
            System.out.println("Found " + searchKey);
        } else {
            System.out.println("Can't find " + searchKey);
        }
        arr.display(); // Вывод содержимого
        arr.delete(00); // Удаление трех элементов
        arr.delete(55);
        arr.delete(99);
        arr.display(); // Повторный вывод
    }
}
//Конец класса OrderedApp


