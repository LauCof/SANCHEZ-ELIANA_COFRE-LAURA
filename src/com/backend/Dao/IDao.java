package com.backend.Dao;

import java.util.List;

public interface IDao<T> {

    T registrar ( T t);

    List<T> listarTodos();
}
