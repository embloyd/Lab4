package lab4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*
        System.out.println("--- Задание 1(1): Обобщенная коробка ---");

        demonstrateBox(sc);
*/
        System.out.println("--- Задание 1(3): Сравнимое ---");

        demonstrateComparable(sc);

        System.out.println("--- Задание 2: Поиск максимума в коробках ---");

        demonstrateMaxSearch(sc);

        System.out.println("--- Задание 4(1): Обобщенные методы ---");
        demonstrateFunction(sc);

        System.out.println("--- Задание 4(2): Обобщенные методы (Фильтр) ---");
        demonstrateFilter(sc);

        sc.close();


    }
    /*
    //задание 1(1)-----------------------------------
    private static void demonstrateBox(Scanner sc) {
        try {
            System.out.println("Часть 1: Коробка с числом 3");

            //1. Создаем коробку для целых чисел
            System.out.println("1. Создаем коробку для целых чисел:");
            Box<Integer> intBox = new Box<>();
            System.out.println("Создана: " + intBox);

            //2. Кладем число 3 в коробку
            System.out.println("2. Кладем число 3 в коробку:");
            intBox.put(3);
            System.out.println("После добавления: " + intBox);
            System.out.println("Коробка заполнена? " + intBox.isFull());

            //3. Передаем коробку в метод и извлекаем значение
            System.out.println("3. Передаем коробку в метод и извлекаем значение:");
            int value = extractAndPrint(intBox);
            System.out.println("Извлеченное значение: " + value);
            System.out.println("После извлечения: " + intBox);
            System.out.println("Коробка пуста? " + intBox.isEmpty());

            System.out.println("Часть 2: Интерактивная демонстрация");

            //4. Работа с разными типами через ввод с клавиатуры
            System.out.println("4. Демонстрация с разными типами:");

            System.out.println("Выберите тип коробки:");
            System.out.println("1 - Целое число");
            System.out.println("2 - Строка");
            System.out.println("3 - Дробь");
            System.out.print("Ваш выбор: ");

            int choice = sc.nextInt();
            sc.nextLine(); //очистка буфера

            switch (choice) {
                case 1:
                    Box<Integer> intBox2 = new Box<>();
                    System.out.print("Введите целое число: ");
                    int intValue = sc.nextInt();
                    sc.nextLine();
                    intBox2.put(intValue);
                    System.out.println("Создана: " + intBox2);
                    System.out.println("Извлекаем: " + intBox2.take());
                    break;

                case 2:
                    Box<String> stringBox = new Box<>();
                    System.out.print("Введите строку: ");
                    String strValue = sc.nextLine();
                    stringBox.put(strValue);
                    System.out.println("Создана: " + stringBox);
                    System.out.println("Извлекаем: " + stringBox.take());
                    break;

                case 3:
                    //простой пример с дробью
                    Box<String> fractionBox = new Box<>(); //упрощенно как строка
                    System.out.print("Введите дробь (например 1/2): ");
                    String fraction = sc.nextLine();
                    fractionBox.put(fraction);
                    System.out.println("Создана: " + fractionBox);
                    System.out.println("Извлекаем: " + fractionBox.take());
                    break;

                default:
                    System.out.println("Неверный выбор");
            }

            //5. Демонстрация ошибок
            System.out.println("Часть 3: Обработка ошибок");
            Box<String> testBox = new Box<>();
            testBox.put("Тестовый объект");

            try {
                System.out.println("Пытаемся положить второй объект в заполненную коробку:");
                testBox.put("Второй объект");
            } catch (IllegalStateException e) {
                System.out.println("Поймано исключение: " + e.getMessage());
            }

            //6. демонстрация методов
            System.out.println("Часть 4: Демонстрация работы с коробкой");
            System.out.print("Введите что-нибудь для коробки: ");
            String userInput = sc.nextLine();
            Box<String> demoBox = new Box<>();

            demoBox.put(userInput);
            System.out.println("Положили в коробку: " + demoBox);
            System.out.println("Коробка заполнена? " + demoBox.isFull());

            System.out.println("Посмотрим, что в коробке (peek()): " + demoBox.peek());
            System.out.println("После peek() коробка: " + demoBox);

            System.out.println("Достанем из коробки (take()): " + demoBox.take());
            System.out.println("После take() коробка: " + demoBox);
            System.out.println("Теперь коробка пуста? " + demoBox.isEmpty());


        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    //--------------------------------
    */

    //2
    private static void demonstrateMaxSearch(Scanner sc) {

        try {
            System.out.println("Сколько коробок вы хотите создать?");
            System.out.print("Введите количество (от 2 до 10): ");
            int count = getIntInRange(sc, "", 2, 10);

            // Создаем массив для коробок
            Box<? extends Number>[] boxes = new Box[count];

            System.out.println("Создаем коробки:");
            for (int i = 0; i < count; i++) {
                System.out.println("Коробка " + (i + 1));

                System.out.println("Выберите тип числа:");
                System.out.println("1. Целое число");
                System.out.println("2. Десятичное число");

                int choice = getIntInRange(sc, "Ваш выбор (1 или 2): ", 1, 2);

                if (choice == 1) {
                    int value = getIntInput(sc, "Введите целое число: ");
                    Box<Integer> box = new Box<>();
                    box.put(value);
                    boxes[i] = box;
                } else {
                    double value = getDoubleInput(sc, "Введите десятичное число: ");
                    Box<Double> box = new Box<>();
                    box.put(value);
                    boxes[i] = box;
                }

                System.out.println("Создана: " + boxes[i]);
            }

            // Показываем все созданные коробки
            System.out.println("Ваши коробки:");
            for (int i = 0; i < boxes.length; i++) {
                System.out.println((i + 1) + ". " + boxes[i]);
            }

            // Ищем максимум
            System.out.println("Поиск максимального значения");
            try {
                double maxValue = findMaxValue(boxes);
                System.out.println("Максимальное значение: " + maxValue);

                // Показываем, в каких коробках это значение
                System.out.println("Это значение находится в коробках:");
                for (int i = 0; i < boxes.length; i++) {
                    if (!boxes[i].isEmpty() && boxes[i].peek().doubleValue() == maxValue) {
                        System.out.println("Коробка " + (i + 1));
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }


        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }



    //1(3)
    private static void demonstrateComparable(Scanner sc) {
        System.out.println("Демонстрация сравнения объектов");

        try {
            // 1. Создаем двух студентов
            System.out.println("1. Создаем двух студентов:");

            System.out.println("Первый студент:");
            System.out.print("Введите имя: ");
            String name1 = sc.nextLine();
            int grade1 = getIntInRange(sc, "Введите оценку (0-100): ", 0, 100);
            int age1 = getIntInput(sc, "Введите возраст: ");

            System.out.println("Второй студент:");
            System.out.print("Введите имя: ");
            String name2 = sc.nextLine();
            int grade2 = getIntInRange(sc, "Введите оценку (0-100): ", 0, 100);
            int age2 = getIntInput(sc, "Введите возраст: ");

            Student student1 = new Student(name1, grade1, age1);
            Student student2 = new Student(name2, grade2, age2);

            System.out.println("Созданы студенты:");
            System.out.println("1. " + student1);
            System.out.println("2. " + student2);

            // 2. Демонстрируем сравнение по оценкам
            System.out.println("2. Сравнение студентов по оценкам:");
            int result = student1.compare(student2);

            if (result < 0) {
                System.out.println(student1.getName() + " имеет < оценку, чем " + student2.getName());
            } else if (result > 0) {
                System.out.println(student1.getName() + " имеет > оценку, чем " + student2.getName());
            } else {
                System.out.println("Студенты имеют = оценку");
            }
            System.out.println("Результат compare(): " + result);

            // 3. Демонстрируем сравнение по возрасту
            System.out.println("3. Сравнение студентов по возрасту:");
            int ageResult = student1.compareByAge(student2);

            if (ageResult < 0) {
                System.out.println(student1.getName() + " младше, чем " + student2.getName());
            } else if (ageResult > 0) {
                System.out.println(student1.getName() + " старше, чем " + student2.getName());
            } else {
                System.out.println("Студенты = возраста");
            }
            System.out.println("Результат compareByAge(): " + ageResult);

            // 4. Демонстрируем сравнение по имени
            System.out.println("4. Сравнение студентов по имени:");
            int nameResult = student1.compareByName(student2);

            if (nameResult < 0) {
                System.out.println("Имя '" + student1.getName() + "' идет раньше по алфавиту, чем '" + student2.getName() + "'");
            } else if (nameResult > 0) {
                System.out.println("Имя '" + student1.getName() + "' идет позже по алфавиту, чем '" + student2.getName() + "'");
            } else {
                System.out.println("У студентов = имена");
            }
            System.out.println("Результат compareByName(): " + nameResult);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

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

    //4(2)
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


    //Метод, который принимает коробку, извлекает значение и выводит его
    private static int extractAndPrint(Box<Integer> box) {
        if (box.isEmpty()) {
            throw new IllegalStateException("Коробка пуста");
        }
        int value = box.take();
        System.out.println("Внутри метода: извлекли значение " + value);
        return value;
    }

    private static int getIntInRange(Scanner sc, String prompt, int min, int max) {
        while (true) {
            int value = getIntInput(sc, prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Ошибка: число должно быть от " + min + " до " + max);
        }
    }

    private static int getIntInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число");
            }
        }
    }

    //для 2 задачи-------------------------
    public static double findMaxValue(Box<? extends Number>... boxes) {
        if (boxes == null || boxes.length == 0) {
            throw new IllegalArgumentException("Нет коробок для поиска!");
        }

        double max = Double.NEGATIVE_INFINITY;
        boolean found = false;

        for (Box<? extends Number> box : boxes) {
            if (box != null && !box.isEmpty()) {
                double value = box.peek().doubleValue();
                if (value > max) {
                    max = value;
                    found = true;
                }
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Все коробки пустые!");
        }

        return max;
    }

    private static double getDoubleInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число (например: 5.5 или 10)!");
            }
        }
    }


    //------------------------------------------------------------

}