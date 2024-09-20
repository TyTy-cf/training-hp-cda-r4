package fr.cda.botteprintemps.service.interfaces;

public interface ServiceInterface<T, L, C, U> {

    T create(C o);

    T update(U o, L id);

    void delete(T o);

    T findOneById(L id);

}
