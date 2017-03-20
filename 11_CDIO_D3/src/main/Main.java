package main;

import data.Connector;
import logic.Logic;
import ui.UI;

public class Main {

    public static void main(String[] args) {
        new UI(new Logic(new Connector()));
    }

}