package fr.cda.trainingharrypotter.service.interfaces;

public interface DTOMapperInterface<T, L> {

    T toObject(L dto);

    L toDTO(T object);

}
