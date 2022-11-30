package service.com.glovoapp.paymentautomationua.annotation;

/**
 * Конвертер данных
 */
public interface IRequestDataConverter<T, R> {
    R convert(T data);
}
