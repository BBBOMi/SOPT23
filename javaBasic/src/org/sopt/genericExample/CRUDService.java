package org.sopt.genericExample;

import org.sopt.exceptionExample.InternalServerError;

public interface CRUDService<T> {
    DefaultRes<T> findOne(final int id) throws InternalServerError;
    DefaultRes<T> save(final T t) throws InternalServerError;
    DefaultRes<T> update(final int id, T t) throws InternalServerError;
    DefaultRes<T> delete(final int id) throws InternalServerError;
}
