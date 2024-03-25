package sample;

import javafx.animation.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SelectionSortController {

    public Button startSort,back;
    public Pane bPane;
    private int[] array = {19,24,2,5,9,44,38,11,28,48};
//    private Rectangle rHighlight,yHighlight;
    private int xInc=0,newInc=60;
    private Object[] objects = new Object[10];


    public void startSorting(){
        int aLength = array.length;
        System.out.println();
        System.out.println("Sorted Array: ");
        sSort(array,aLength);
        printArray(array);
    }

    public void generateArray(){
        if(objects[0]!=null){
            for(int x=0;x<10;x++) {
                xInc=0;
                bPane.getChildren().removeAll(objects[x].getRect(),objects[x].getLabe());
            }
        }

        for(int x=0;x<10;x++){
            Rectangle rect = new Rectangle();
            rect.setWidth(35);
            rect.setHeight(5*array[x]);
            rect.setX(175+xInc);
            rect.setY(400-5*array[x]);

//            rHighlight=new Rectangle();
//            rHighlight.setWidth(35);
//            rHighlight.setHeight(5*array[x]);
//            rHighlight.setX(175+xInc);
//            rHighlight.setY(400-5*array[x]);
//            rHighlight.setFill(Color.RED);
//            rHighlight.toFront();
//
//            yHighlight=new Rectangle();
//            yHighlight.setWidth(35);
//            yHighlight.setHeight(5*array[x]);
//            yHighlight.setX(175+xInc);
//            yHighlight.setY(400-5*array[x]);
//            yHighlight.setFill(Color.YELLOW);
//            yHighlight.toFront();
            xInc+=60;

            Label labe = new Label();
            labe.setLayoutX(125+xInc);
            labe.setLayoutY(425);

            labe.setText(toString(array[x]));
            Object obj = new Object(array[x], rect, labe);
//            obj=new Object(array[x],rect,rHighlight,yHighlight,labe);
//            obj.getHighlight(0).setVisible(false);
//            obj.getHighlight(1).setVisible(false);
            objects[x]= obj;
            bPane.getChildren().addAll(objects[x].getRect(),objects[x].getLabe());
//            bPane.getChildren().addAll(objects[x].getRect(),objects[x].getHighlight(0),objects[x].getHighlight(1),objects[x].getLabe());
        }


        System.out.println("Unsorted Array: ");
        printArray(array);
    }

    private String toString(int input){
        return String.valueOf(input);
    }

    private void sSort(int[] array,int cnt){
        int minElmt;
        for(int x=0;x<cnt-1;x++){
            minElmt = x;
            for(int y=x+1;y<cnt;y++){
                if(array[y] < array[minElmt]){
                    minElmt = y;
                }
            }
            swap(array, x, minElmt);
            System.out.println("Left Number: " + x);
            System.out.println("Right Number: " + minElmt);
        }
        swapR2();
    }


    private void swap(int[] array,int first,int second){
        int temp;
        temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private int c=1;
    private void swapR2(){
        for(int x=0;x<3;x++){
            TranslateTransition rectangle1 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition rectangle2 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition label1 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition label2 = new TranslateTransition(Duration.seconds(0.5));

            rectangle1.setNode(objects[x].getRect());
            rectangle2.setNode(objects[x+2].getRect());
            System.out.println("Switching "+objects[x].getLabe().getText()+" with "+objects[x+2].getLabe().getText());
            label1.setNode(objects[x].getLabe());
            label2.setNode(objects[x+2].getLabe());


            rectangle1.setToX(objects[x+2].getRect().getX()-objects[x].getRect().getX());
            if(x==2) {
                rectangle2.setToX(-120);
                label2.setToX(-115);
            }
            else {
                rectangle2.setToX(-objects[x].getRect().getX()+newInc);
                label2.setToX(-objects[x].getLabe().getLayoutX()+newInc+15);
            }
            label1.setToX(objects[x+2].getLabe().getLayoutX()-objects[x].getLabe().getLayoutX());

            rectangle1.setDelay(Duration.seconds(c));
            rectangle2.setDelay(Duration.seconds(c));
            label1.setDelay(Duration.seconds(c));
            label2.setDelay(Duration.seconds(c));

            rectangle1.play();
            rectangle2.play();
            label1.play();
            label2.play();
            c+=1;
            newInc+=60;
            swapObjects(x,x+2);
        }

        for(int y=0;y<1;y++) {
            TranslateTransition r3 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition r4 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition l3 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition l4 = new TranslateTransition(Duration.seconds(0.5));

            r3.setNode(objects[3+y].getRect());
            r4.setNode(objects[7].getRect());
            System.out.println("Switching "+objects[3+y].getLabe().getText()+" with "+objects[7].getLabe().getText());
            l3.setNode(objects[3+y].getLabe());
            l4.setNode(objects[7].getLabe());

            r3.setToX(objects[7].getRect().getX() - objects[3+y].getRect().getX());
            r4.setToX(-objects[3+y].getRect().getX());
            l3.setToX(objects[7].getLabe().getLayoutX()-objects[3+y].getLabe().getLayoutX());
            l4.setToX(-objects[3+y].getLabe().getLayoutX()+10);

            r3.setDelay(Duration.seconds(c));
            r4.setDelay(Duration.seconds(c));
            l3.setDelay(Duration.seconds(c));
            l4.setDelay(Duration.seconds(c));

            r3.play();
            r4.play();
            l3.play();
            l4.play();

            c+=1;
            swapObjects(3+y, 7);
        }

        for(int z=5;z<7;z++) {
            TranslateTransition r3 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition r4 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition l3 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition l4 = new TranslateTransition(Duration.seconds(0.5));

            r3.setNode(objects[z].getRect());
            r4.setNode(objects[z+2].getRect());
            System.out.println("Switching "+objects[z].getLabe().getText()+" with "+objects[z+2].getLabe().getText());
            l3.setNode(objects[z].getLabe());
            l4.setNode(objects[z+2].getLabe());

            if(z==5){
                r3.setToX(objects[z+2].getRect().getX() - 115);
                l3.setToX(objects[z+2].getLabe().getLayoutX() - 125);
            }
            else {
                r3.setToX(120);
                l3.setToX(120);
            }
            if(z==5){
                r4.setToX(245);
                l4.setToX(245);
            }
            else {
                r4.setToX(-120);
                l4.setToX(-120);
            }

            r3.setDelay(Duration.seconds(c));
            r4.setDelay(Duration.seconds(c));
            l3.setDelay(Duration.seconds(c));
            l4.setDelay(Duration.seconds(c));

            r3.play();
            r4.play();
            l3.play();
            l4.play();

            c+=1;
            swapObjects(z, z+2);
        }

        for(int a=7;a<8;a++) {
            TranslateTransition r3 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition r4 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition l3 = new TranslateTransition(Duration.seconds(0.5));
            TranslateTransition l4 = new TranslateTransition(Duration.seconds(0.5));

            r3.setNode(objects[a].getRect());
            r4.setNode(objects[a+1].getRect());
            System.out.println("Switching "+objects[a].getLabe().getText()+" with "+objects[a+1].getLabe().getText());
            l3.setNode(objects[a].getLabe());
            l4.setNode(objects[a+1].getLabe());

            r3.setToX(180);
            r4.setToX(+60);
            l3.setToX(180);
            l4.setToX(+60);

            r3.setDelay(Duration.seconds(c));
            r4.setDelay(Duration.seconds(c));
            l3.setDelay(Duration.seconds(c));
            l4.setDelay(Duration.seconds(c));

            r3.play();
            r4.play();
            l3.play();
            l4.play();

            c+=1;
            swapObjects(a, a+1);
        }
    }

    private void swapObjects(int left,int right){
        Object ihavetoswitch = objects[left];
        objects[left]=objects[right];
        objects[right]=ihavetoswitch;
    }

    private void printArray(int[] arr){
        for(int x=0;x<10;x++){
            System.out.print(arr[x] + " ");
        }
    }

    public void back() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainMenu.fxml"));
        Parent root = loader.load();

        Stage mainStage = new Stage();
        Scene mainScene = new Scene(root);


        mainStage.setScene(mainScene);
        mainStage.setTitle("Sorting Visualization");
        mainStage.show();

        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }
}
