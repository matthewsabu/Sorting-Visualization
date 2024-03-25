package sample;

import javafx.animation.TranslateTransition;
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

public class BubbleSortController {

    public Button back;
    public Pane bPane;
    private int[] array = {19,28,11,23,42,7,34,38,4,25};
    private int xInc=0,newInc=60;
    private Object[] objects = new Object[10];

    public void startSorting(){
        int length = array.length;
        System.out.println("Unsorted Array: ");
        printArray(array);
        bSort(length);
        System.out.println();
        System.out.println("Sorted Array: ");
        printArray(array);
    }

    private void bSort(int length){
        for(int x=0; x < length; x++){
            for(int y=1; y < (length-x); y++){
                if(array[y-1] > array[y]){
                    swap(array,y-1,y);
                    swapRecs(y-1,y);
                }
            }
            newInc+=60;
        }
    }

    private void swap(int[] array,int first,int second){
        int temp;
        temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public void generateArray(){
        if(objects[0]!=null) {
            for (int x = 0; x < 10; x++) {
                xInc = 0;
                newInc = 60;
                bPane.getChildren().removeAll(objects[x].getRect(), objects[x].getLabe());
            }
        }
        for(int x=0;x<10;x++) {
            Rectangle rect = new Rectangle();
            rect.setWidth(35);
            rect.setHeight(5 * array[x]);
            rect.setX(175 + xInc);
            rect.setY(400 - 5 * array[x]);

            xInc+=60;

            Label labe = new Label();
            labe.setLayoutX(125+xInc);
            labe.setLayoutY(425);

            labe.setText(toString(array[x]));
            Object obj = new Object(array[x], rect, labe);

            objects[x]= obj;
            bPane.getChildren().addAll(objects[x].getRect(),objects[x].getLabe());
        }
    }

    private int c=1;
    private void swapRecs(int x,int y){
        TranslateTransition r1 = new TranslateTransition(Duration.seconds(0.5));
        TranslateTransition r2 = new TranslateTransition(Duration.seconds(0.5));
        TranslateTransition l1 = new TranslateTransition(Duration.seconds(0.5));
        TranslateTransition l2 = new TranslateTransition(Duration.seconds(0.5));

        r1.setNode(objects[x].getRect());
        r2.setNode(objects[y].getRect());
        l1.setNode(objects[x].getLabe());
        l2.setNode(objects[y].getLabe());

        r1.setToX(objects[y].getRect().getX() - objects[x].getRect().getX()-(newInc-60));
        r2.setToX(-newInc);
        l1.setToX(objects[y].getRect().getX() - objects[x].getRect().getX()-(newInc-60));
        l2.setToX(-newInc);

        r1.setDelay(Duration.seconds(c));
        r2.setDelay(Duration.seconds(c));
        l1.setDelay(Duration.seconds(c));
        l2.setDelay(Duration.seconds(c));

        r1.play();
        r2.play();
        l1.play();
        l2.play();
        c += 1;
        swapObjects(x, y);
    }

    private void swapObjects(int left,int right){
        Object ihavetoswitch = objects[left];
        objects[left]=objects[right];
        objects[right]=ihavetoswitch;
    }

    private String toString(int input){
        return String.valueOf(input);
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
