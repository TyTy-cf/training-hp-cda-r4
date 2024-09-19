package fr.cda.botteprintemps.service.interfaces;

public interface DTOMapperInterface<T, L> {

    T toObject(L dto);

    L toDTO(T object);

}
