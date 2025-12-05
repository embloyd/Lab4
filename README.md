# Мурай Анастасия ИТ-3 Лабораторная №4
# Задание 1
## Задача 1
### Текст задачи
Создайте	сущность	Коробка,	которая	обладает	следующими	характеристиками:	
• Может	хранить	один	произвольный	объект	в	один	момент	времени.	
• Объект	можно	получить	и	разместить	на	хранение	в	любой	момент	времени.	
• Если	объект	забирают	из	коробки	–	ссылку	на	этот	объект	необходимо	обнулить.	
• Если	объект	кладут	в	коробку,	но	она	не	пуста	–	необходимо	выкинуть	исключение.	
• Имеет	метод	проверки	на	заполненность.	
• Методы	класса	должны	работать	с	тем	типом	данных,	который	был	указан	во	время	
создания	объекта	
Создайте	Коробку	которая	может	хранить	целочисленное	значение,	разместите	туда	число	3.	
Передайте	Коробку	в	какой-либо	метод,	извлеките	значение,	и	выведите	его	на	экран.
### Алгоритм решения
```java
package lab4;
//коробка, которая может хранить один объект любого типа
//T - тип хранимого объекта (Integer, String, Double)
public class Box<T> {
    private T content;  //хранимый объект

    //Конструктор пустой коробки
    public Box() {
        this.content = null;
    }

    //конструктор коробки с содержимым
    public Box(T content) { //объект для хранения
        if (this.content != null) {
            throw new IllegalStateException("Коробка уже содержит объект");
        }
        this.content = content;
    }

   //положить в коробку
    public void put(T object) {
        if (content != null) {
            throw new IllegalStateException("Коробка уже содержит объект");
        }
        this.content = object;
    }

    //взять объект. возвращаем объект из коробки, или null если коробка пуста
    public T take() {
        T temp = content;
        content = null;  //обнуляем ссылку после извлечения
        return temp;
    }

    //посмотреть объект (без извлечений)
    public T peek() {
        return content;
    }
    //заолнена ли коробка. возвращаем true если коробка содержит объект, false если пуста
    public boolean isFull() {
        return content != null;
    }
    //пуста ли коробка. возвращаем true если коробка пуста, false если содержит объект
    public boolean isEmpty() {
        return content == null;
    }

    //очистить
    public void clear() {
        content = null;
    }

    @Override
    public String toString() {
        if (content == null) {
            return "Коробка [пусто]";
        } else {
            return "Коробка [" + content + "]";
        }
    }
}
```

# Задание 1
## Задача 3
### Текст задачи
Создайте	ссылочный	тип	Сравнимое,	гарантирующий	наличие	по	данной	ссылке	метода	со	
следующими	характеристиками:	
• Называется	“сравнить”	
• Принимает	объект.	
• Тип	принимаемого	объекта	может	быть	изменен	без	изменения	самого	Сравнимого.	
• Возвращает	целое	число.
### Алгоритм решения
Создаем интерфейс Comparable.java
```java
package lab4;

public interface Comparable<T> {

    int compare(T other);
}
```
Создадим класс Student (Студент), который можно сравнивать по оценкам:
```java
package lab4;

//Класс Студент, который реализует интерфейс Comparable<Student>
public class Student implements Comparable<Student> {
    private String name;
    private int grade;
    private int age;

    public Student(String name, int grade, int age) {
        this.name = name;
        this.grade = grade;
        this.age = age;
    }

    //Реализуем метод compare() из интерфейса Comparable
    @Override
    public int compare(Student other) {
        //Сравниваем оценки: чем выше оценка, тем "больше" студент
        return this.grade - other.grade;
    }

    //сравнение по возрасту
    public int compareByAge(Student other) {
        return this.age - other.age;
    }

    //сравнение по имени
    public int compareByName(Student other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (оценка: " + grade + ", возраст: " + age + ")";
    }
}
```
# Задание 2
## Задача 2
### Текст задачи
Создайте	метод,	принимающий	набор	Коробок	из	задачи	3.1.1	и	возвращающий	максимальное	из	
их	значений	в	формате	double.	Принимаемые	методом	Коробки	могут	быть	параметризованы	
любыми	видами	чисел.
### Алгоритм решения
```java
//коробка может хранить только числа (Integer, Double, Float и т.д.)
public class Box<T extends Number> {
    private T content;  // хранимый объект

    //Конструктор пустой коробки
    public Box() {
        this.content = null;
    }

    //Конструктор коробки с содержимым
    public Box(T content) {
        if (this.content != null) {
            throw new IllegalStateException("Коробка уже содержит объект!");
        }
        this.content = content;
    }

    //положить
    public void put(T object) {
        if (content != null) {
            throw new IllegalStateException("Коробка уже содержит объект!");
        }
        this.content = object;
    }

    //взять
    public T take() {
        T temp = content;
        content = null;
        return temp;
    }

    // Посмотреть объект в коробке
    public T peek() {
        return content;
    }

    //заполнена ли коробка
    public boolean isFull() {
        return content != null;
    }

    //пуста ли коробка
    public boolean isEmpty() {
        return content == null;
    }

    //очистить
    public void clear() {
        content = null;
    }

    //получить значение как double (для сравнения)
    public double getValueAsDouble() {
        if (content == null) {
            return 0.0;
        }
        return content.doubleValue();
    }

    @Override
    public String toString() {
        if (content == null) {
            return "Коробка [пусто]";
        } else {
            return "Коробка [" + content + "]";
        }
    }
}
```

# Задание 3
## Задача 1
### Текст задачи
Разработайте	такой	метод,	который	будет	принимать	список	значений	типа	T,	и	объект	имеющий	
единственный	метод	apply.	Данный	метод	надо	применить	к	каждому	элементу	списка,	и	вернуть	
новый	список	значений	типа	P,	при	этом	типы	T	и	P	могут	совпадать,	а	могут	не	совпадать.	
Используйте	разработанный	метод	следующим	образом:	
1. Передайте	в	метод	список	со	значениями:“qwerty”,	“asdfg”,	“zx”,	а	получите	список	чисел,	
где	каждое	число	соответствует	длине	каждой	строки.	
2. Передайте	в	метод	список	со	значениями:	1,-3,7,	а	получите	список	в	котором	все	
отрицательные	числа	стали	положительными,	а	положительные	остались	без	изменений	
3. Передайте	в	метод	список	состоящий	из	массивов	целых	чисел,	а	получите	список	в	
котором	будут	только	максимальные	значения	каждого	из	исходных	массивов
### Алгоритм решения
Создаем интерфейс Function
```java
package lab4;

//интерфейс для преобразования значений
@FunctionalInterface
public interface Function<T, P> {
    P apply(T value);
}
```
Создаем обобщенный метод applyToList
```java
public static <T, P> List<P> applyToList(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    //4(1)
    private static void demonstrateFunction(Scanner sc) {

        try {
            //Пример 1: Строки - их длины
            System.out.println("1. Преобразование строк в их длины:");

            List<String> strings = new ArrayList<>();
            strings.add("qwerty");
            strings.add("asdfg");
            strings.add("zx");

            System.out.println("Исходный список строк: " + strings);

            //Используем лямбда-выражение: строка - ее длина
            List<Integer> lengths = applyToList(strings, str -> str.length());

            System.out.println("Список длин строк: " + lengths);

            //Пример 2: Числа - абсолютные значения
            System.out.println("2. Преобразование чисел в абсолютные значения:");

            List<Integer> numbers = new ArrayList<>();
            System.out.println("Введите 3 целых числа:");
            for (int i = 0; i < 3; i++) {
                System.out.print("Число " + (i + 1) + ": ");
                numbers.add(getIntInput(sc, ""));
            }

            System.out.println("Исходный список чисел: " + numbers);

            //Используем лямбда-выражение: число - его модуль
            List<Integer> absoluteValues = applyToList(numbers, num -> Math.abs(num));

            System.out.println("Список абсолютных значений: " + absoluteValues);

            //Пример 3: Массивы - их максимумы
            System.out.println("3. Преобразование массивов в их максимальные значения:");

            List<int[]> arrays = new ArrayList<>();
            System.out.println("Создадим 3 массива целых чисел:");

            for (int i = 0; i < 3; i++) {
                System.out.println("Массив " + (i + 1) + ":");
                System.out.print("Сколько чисел в массиве? (от 2 до 5): ");
                int size = getIntInRange(sc, "", 2, 5);

                int[] array = new int[size];
                System.out.println("Введите " + size + " чисел:");
                for (int j = 0; j < size; j++) {
                    System.out.print("Число " + (j + 1) + ": ");
                    array[j] = getIntInput(sc, "");
                }
                arrays.add(array);
            }

            //Выводим массивы
            System.out.println("Исходные массивы:");
            for (int i = 0; i < arrays.size(); i++) {
                System.out.print("Массив " + (i + 1) + ": [");
                int[] arr = arrays.get(i);
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j]);
                    if (j < arr.length - 1) System.out.print(", ");
                }
                System.out.println("]");
            }

            //Используем лямбда-выражение: массив - его максимум
            List<Integer> maxValues = applyToList(arrays, arr -> {
                int max = arr[0];
                for (int num : arr) {
                    if (num > max) max = num;
                }
                return max;
            });

            System.out.println("Максимальные значения массивов: " + maxValues);


        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
```

# Задание 3
## Задача 2
### Текст задачи
Разработайте	такой	метод,	который	будет	принимать	список	значений	типа	T	и	объект	имеющий	
единственный	метод	test	(принимает	T	и	возвращает	boolean).	Верните	новый	список	типа	T,	из	
которого	удалены	все	значения	не	прошедшие	проверку	условием.	
Используйте	разработанный	метод	следующим	образом:	
1. Передайте	в	метод	список	со	значениями:	“qwerty”,	“asdfg”,	“zx”,	и	отфильтруйте	все	
строки	имеющие	менее	трех	символов	
2. Передайте	в	метод	список	со	значениями:	1,-3,7,	и	отфильтруйте	все	положительные	
элементы	
3. Передайте	в	метод	список	состоящий	из	массивов	целых	чисел,	а	получите	список	в	
котором	будут	только	те	массивы,	в	которых	нет	ни	одного	положительного	элемента
### Алгоритм решения
Создаем интерфейс Predicate
```java
package lab4;

//интерфейс для проверки условий
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T value);
}
```
Добавляем метод filterToList в Main.java
```java
public static <T> List<T> filterToList(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    private static void demonstrateFilter(Scanner sc) {

        try {
            //Пример 1: Фильтрация строк по длине
            System.out.println("1. Фильтрация строк (удаляем строки короче 3 символов):");

            List<String> strings = new ArrayList<>();
            strings.add("qwerty");
            strings.add("asdfg");
            strings.add("zx");
            strings.add("hello");
            strings.add("a");
            strings.add("world");

            System.out.println("Исходный список строк: " + strings);

            //Фильтруем: оставляем только строки длиной >= 3
            List<String> filteredStrings = filterToList(strings, str -> str.length() >= 3);

            System.out.println("После фильтрации (длина >= 3): " + filteredStrings);

            //Пример 2: Фильтрация чисел (оставляем только положительные)
            System.out.println("2. Фильтрация чисел (оставляем только положительные):");

            List<Integer> numbers = new ArrayList<>();
            System.out.println("Введите 5 целых чисел:");
            for (int i = 0; i < 5; i++) {
                System.out.print("Число " + (i + 1) + ": ");
                numbers.add(getIntInput(sc, ""));
            }

            System.out.println("Исходный список чисел: " + numbers);

            //Фильтруем: оставляем только положительные числа
            List<Integer> positiveNumbers = filterToList(numbers, num -> num > 0);

            System.out.println("После фильтрации: " + positiveNumbers);

            //Пример 3: Фильтрация массивов (без положительных элементов)
            System.out.println("3. Фильтрация массивов (оставляем массивы без положительных элементов):");

            List<int[]> arrays = new ArrayList<>();
            System.out.println("Создадим 4 массива целых чисел:");

            for (int i = 0; i < 4; i++) {
                System.out.println("Массив " + (i + 1) + ":");
                System.out.print("Сколько чисел в массиве? (от 2 до 4): ");
                int size = getIntInRange(sc, "", 2, 4);

                int[] array = new int[size];
                System.out.println("Введите " + size + " чисел:");
                for (int j = 0; j < size; j++) {
                    System.out.print("Число " + (j + 1) + ": ");
                    array[j] = getIntInput(sc, "");
                }
                arrays.add(array);
            }

            //Выводим исходные массивы
            System.out.println("Исходные массивы:");
            for (int i = 0; i < arrays.size(); i++) {
                System.out.print("Массив " + (i + 1) + ": [");
                int[] arr = arrays.get(i);
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[j]);
                    if (j < arr.length - 1) System.out.print(", ");
                }
                System.out.println("]");
            }

            //Фильтруем: оставляем массивы без положительных элементов
            List<int[]> arraysWithoutPositives = filterToList(arrays, arr -> {
                for (int num : arr) {
                    if (num > 0) {
                        return false; //нашли положительный - массив не подходит
                    }
                }
                return true; //все числа неположительные
            });

            System.out.println("После фильтрации (массивы без положительных элементов):");
            if (arraysWithoutPositives.isEmpty()) {
                System.out.println("Нет подходящих массивов");
            } else {
                for (int i = 0; i < arraysWithoutPositives.size(); i++) {
                    System.out.print("Массив " + (i + 1) + ": [");
                    int[] arr = arraysWithoutPositives.get(i);
                    for (int j = 0; j < arr.length; j++) {
                        System.out.print(arr[j]);
                        if (j < arr.length - 1) System.out.print(", ");
                    }
                    System.out.println("]");
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
```
