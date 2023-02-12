package database.repository;

import java.util.Optional;

public interface CrudRepository <K,E> {
    Optional<E> getByID(K id);
    void deleteEntity(E entity);
}
