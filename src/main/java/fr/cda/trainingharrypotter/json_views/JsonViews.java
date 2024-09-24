package fr.cda.trainingharrypotter.json_views;

public class JsonViews {

    public interface HouseMinimalView {}
    public interface HouseListView extends HouseMinimalView {}
    public interface HouseShowView extends HouseMinimalView {}

    public interface StudentMinimalView {}
    public interface StudentListView extends StudentMinimalView {}
    public interface StudentShowView extends StudentMinimalView {}

}
