package fr.cda.trainingharrypotter.service.interfaces;

import java.util.List;

public interface ServiceListInterface<T, ID, C, U> extends ServiceInterface<T, ID, C, U>  {

    List<?> list();

}
