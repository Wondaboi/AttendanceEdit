package com.Attendance.Spring.Boot.services;

import java.util.Set;

public interface BaseService<E, ID> {
    E create(E entity);

    E readById(ID id);

    Set<E> readAll();

    E update(E entity);

    void delete(E entity);
}
