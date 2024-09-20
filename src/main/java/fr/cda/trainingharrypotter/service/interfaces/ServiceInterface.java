package fr.cda.trainingharrypotter.service.interfaces;

public interface ServiceInterface<T, L, C, U> {

    T create(C o);

    T update(U o, L id);

    void delete(T o);

    T findOneById(L id);

}
