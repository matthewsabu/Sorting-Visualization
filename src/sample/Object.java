package sample;

import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class Object {
    private int data;
    private Rectangle rect;
//    private Rectangle rHigh;
//    private Rectangle yHigh;
    private Label labe;

    public Object(int num, Rectangle r, Label l){
        data=num;
        rect=r;
        labe=l;
    }

//    public Object(int num, Rectangle r, Rectangle rH, Rectangle yH, Label l){
//        data=num;
//        rect=r;
//        rHigh=rH;
//        yHigh=yH;
//        labe=l;
//    }

    public int getData(){
        return data;
    }

    public Rectangle getRect(){
        return rect;
    }

//    public Rectangle getHighlight(int identity){
//        if(identity==0) return rHigh;
//        else return yHigh;
//    }

    public Label getLabe(){
        return labe;
    }
}
