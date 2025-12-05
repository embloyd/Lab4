package lab4;
/*
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
*/


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