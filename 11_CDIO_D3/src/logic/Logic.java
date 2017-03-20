package logic;

import data.Connector;

public class Logic implements ILogic {

    private final Connector conn;

    public Logic(Connector conn) {
        this.conn = conn;
    }

}