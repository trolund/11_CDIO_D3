package ui;

import logic.ILogic;

public class UI implements IUI {

    private final ILogic logic;

    public UI(ILogic logic) {
        this.logic = logic;
    }

}