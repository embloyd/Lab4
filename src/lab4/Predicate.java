package lab4;

//интерфейс для проверки условий
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T value);
}