package com.mycompany.garcia_cutillas_franciscojose_actut04.repository;

import java.util.List;

/**
 *
 * @author Fran
 */
public interface Repository<T> {

    public void save(T t);

    public List<T> findAll();

    public T findOneById(int id);

}
