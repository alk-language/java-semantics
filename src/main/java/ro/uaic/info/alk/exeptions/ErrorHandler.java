package ro.uaic.info.alk.exeptions;

public interface ErrorHandler<T>
{
    ErrorHandler<Integer> TO_INTERNAL = (e) -> {
        throw new InternalException(e);
    };

    T handle(Exception e);
}
