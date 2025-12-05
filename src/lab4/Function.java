package lab4;

//интерфейс для преобразования значений
@FunctionalInterface
public interface Function<T, P> {
    P apply(T value);
}