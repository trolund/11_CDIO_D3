package data;

public class Data implements IData {

    private final Connector connector;

    public Data() {
        this.connector = Connector.getInstance();
    }

}