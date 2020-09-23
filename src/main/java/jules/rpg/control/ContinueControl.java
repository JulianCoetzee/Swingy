package jules.rpg.control;

import jules.rpg.view.ViewContinue;

public class ContinueControl {
    
    private ViewContinue view;
    
    public ContinueControl(ViewContinue view) {
        this.view = view;
    }
    
    public void onClickLoad(String name) {
        view.loadChar();
    }

    public void onClickDel(String name) {
        view.delChar();
    }

    public void onClickBack() {
        view.retreat();
    }  
}