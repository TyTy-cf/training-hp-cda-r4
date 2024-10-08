package fr.cda.trainingharrypotter.service.interfaces;

public interface ServiceInterface<T, ID, C, U> {

    T create(C o);

    T update(U o, ID id);

    void delete(ID id);

    T findOneById(ID id);

}
