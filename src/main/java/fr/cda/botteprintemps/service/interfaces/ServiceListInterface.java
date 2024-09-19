package fr.cda.botteprintemps.service.interfaces;

import java.util.List;

public interface ServiceListInterface<T, L> extends ServiceInterface<T, L>  {

    List<?> list();

}
