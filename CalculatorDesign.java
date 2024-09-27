/**
 * 
 * This application will represent the layout of a simple calculator with basic mathematical operators which consist of 19 buttons and 1 textfield. 
 * The application will be resizable when window is resized
 * *@Author Angie Diaz
 * *@Version 3.0 09/14/24
 * 
 * 10/10 Points: Source code contains program header, comments, and grade report; code organized and readable
 * 60/60 Points Total (3 points each): Created 19 buttons and 1 text field.
 * 10/10 Points: Arrangement of UI objects (aligned; arrangement based on standard calculator layout)
 * 10/10 Points: relative button positions do not change when window is resized
 * 10/10 Points: Grade report completed fully and accurately
 * 
 */
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.animation.*;
import javafx.geometry.*;
import java.io.*;
import java.util.*;
import javafx.scene.Scene;

public class CalculatorDesign extends Application{

    //run the application 
    public static void main(String[] args){
        try{
            //create the stage, calls the start method 
            launch(args);
        }catch(Exception error){
            error.printStackTrace();
        }finally{
            System.exit(0);
        }

    }
    //requires the method: public void start(Stage s)
    public void start(Stage mainStage){
        //set the text that appears in the title bar 
        mainStage.setTitle("Calculator Design");
        mainStage.setResizable(true);

        //layout manager: organize window contents
        //vertical box automatically arranges its objects in a vertical box 
        //do not need to set coordinates 
        //Insets allow you to add margins/padding around the objects
        GridPane root = new GridPane(); //initalize 
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);

        //scene: contains window content
        //parameters: layout manager, window width, window height 
        Scene mainScene = new Scene(root, 500, 500);

        //attach/display the scene on stage(window)
        mainStage.setScene(mainScene);
        
        //create a textField
        TextField calcDisplay = new TextField();
        calcDisplay.setEditable(false);
        root.add(calcDisplay, 0, 0, 4, 1); //4 columns are made 

        //to change font size of all elements added to root 
        root.setStyle("-fx-font-size: 20;"); //THIS CONTROLS THE BUTTON SIZE, SO THE BIGGER THE FONT, THE BIGGER THE BUTTON

        //root.setGridLinesVisible(true); //this will result in grid lines to appear in the window; helps to see spacing on layout

        //parameter: object, column # x, row # y
        //these are my button objects (19 buttons)
        Button buttonAC = new Button("AC"); //AC button
        root.add(buttonAC, 0, 1);

        Button buttonClear = new Button("C"); //C button
        root.add(buttonClear, 1, 1);

        Button buttonDel = new Button("\u232B"); //unicode char for Delete button
        root.add(buttonDel, 2,1);

        Button buttonDiv = new Button("\u00F7"); //unicode char for Division button
        root.add(buttonDiv, 3, 1);

        Button buttonSeven = new Button("7"); // 7 button
        root.add(buttonSeven, 0, 2); 

        Button buttonEight = new Button("8"); // 8 button
        root.add(buttonEight, 1, 2);

        Button buttonNine = new Button("9"); // 9 button
        root.add(buttonNine, 2, 2);

        Button buttonTimes = new Button("\u00D7"); //unicode char for Multiplication button
        root.add(buttonTimes, 3, 2); 

        Button buttonFour = new Button("4"); // 4 button
        root.add(buttonFour, 0, 3);

        Button buttonFive = new Button("5"); // 5 button 
        root.add(buttonFive, 1, 3);

        Button buttonSix = new Button("6"); // 6 button
        root.add(buttonSix, 2, 3);

        Button buttonMinus = new Button("\u2212"); //unicode char for Subtraction button
        root.add(buttonMinus, 3, 3);

        Button buttonOne = new Button("1"); // 1 button
        root.add(buttonOne, 0, 4);

        Button buttonTwo = new Button("2"); // 2 button
        root.add(buttonTwo, 1, 4); 

        Button buttonThree = new Button("3"); //3 button
        root.add(buttonThree, 2, 4);

        Button buttonPlus = new Button("+"); //addition button
        root.add(buttonPlus, 3, 4);

        Button buttonZero = new Button("0"); // 0 button
        root.add(buttonZero, 0, 5); 

        Button buttonDec = new Button("."); //decimal point button
        root.add(buttonDec, 1, 5);

        Button buttonEqu = new Button("="); // equal sign button 
        root.add(buttonEqu, 2, 5);

        mainStage.show(); //make all contents visible to the screen 

    }
}
