/**
 * This application will handle the the division of fractions by receiving input for a numerator and a denominator from a 
 * user and giving the answer in a double format e.g 4/2 = 2/0. 
 * @author Angie Diaz
 * @version 1.5 09/08/24
 * 10/10 Points: Source code contains program header and comments; code organized and readable
 * 40/40 Points (10 each): Created two text fields (numerator, denominator), a button, and a label
 * 10/10 Points: Arrangement of UI objects (aligned)
 * 10/10 Points: correct text displays in label (e.g. 3/4 = 0.75, 1/3 = 0.333333333333,100/25 = 4.0)
 * 10/10 Points: if a non-number is entered in either text field, a try-catch block handles the exception and displays an appropriate message in that text field 
 * (e.g. “must enter an integer”)
 * 10/10 Points: if zero is entered in the denominator text field, an appropriate error message displays in the text field (e.g. “can not divide by zero”)
 * 10/10 Points: Grade report completed fully and accurately
 * 
 * 
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent; //this will be the event handler 
import javafx.scene.control.TextField;
import java.util.List;
 
public class FractionConverter extends Application 
{
    // run the application
    public static void main(String[] args) 
    {
        try
        {
            // creates Stage, calls the start method
            launch(args);
        }
        catch (Exception error)
        {
            error.printStackTrace();
        }
        finally
        {
            System.exit(0);
        }
    }

    // Application is an abstract class,
    //  requires the method: public void start(Stage s)
    public void start(Stage mainStage) 
    {
        // set the text that appears in the title bar
        mainStage.setTitle("Math is Fun!");
        mainStage.setResizable(false);

        // layout manager: organize window contents
        Pane root = new Pane();
        List<Node> rootList = root.getChildren();

        // Scene: contains window content
        // parameters: layout manager; width window; height window
        Scene mainScene = new Scene(root, 300, 300);
        // attach/display Scene on Stage (window)
        mainStage.setScene( mainScene );

        // create objects displayed in window

        //Create a textField that is able to take USER INPUT from the keyboard 
        TextField numberField1 = new TextField("Enter Numerator: "); //create a textfield that will prompt this question to the user
        numberField1.setLayoutX(50);
        numberField1.setLayoutY(125);
        rootList.add(numberField1); //this adds the textField onto my list 

        //Create a textfield that is able to take a denominator from user input
        TextField numberField2 = new TextField("Enter Denominator: ");
        numberField2.setLayoutX(50);
        numberField2.setLayoutY(160);
        rootList.add(numberField2);

        //Create a new output label to be displayed on the screen 
        Label outputLabel = new Label("Answer: ");
        outputLabel.setLayoutX(50);
        outputLabel.setLayoutY(230);
        rootList.add(outputLabel);

        //create a button object that displays 'calculate'
        Button calculateButton = new Button("Calculate"); //whatever string you pass through the parameter will appear on the button
        calculateButton.setLayoutX(50);
        calculateButton.setLayoutY(190);
        rootList.add(calculateButton); //always remember to add the button to your list
        
        //this is my event handler, this will handle my button
        calculateButton.setOnAction( (ActionEvent event) -> //lamda expression: this shortens the length of code by two lines
            { 
                try{
                    /** 
                     * Video Reference: "JavaFX TextField" 
                     * https://www.youtube.com/watch?v=gN29Y600k5g
                     * Date Video was created: 02/11/2021
                     * this part of the code lines 104-106 implements converting the string to a double with getText() at timestamp[2:46]
                     */
                    //store double currently typed into the TextField object called numberField1
                    double numerator = Double.parseDouble(numberField1.getText()); //this will return the double numerator that is put in by the user 
                    //store double typed into the TextField object called numberField2
                    double denominator = Double.parseDouble(numberField2.getText()); //this will return the double denominator that is put in by the user 

                    //if-else conditon that division by zero is not allowed 
                    if(denominator == 0){
                        outputLabel.setText("CANNOT DIVIDE BY ZERO!!");
                    }else{
                        //this will display the correct format of the math e.g 3/4 = 0.75
                        outputLabel.setText(numberField1.getText() + " / " + numberField2.getText() + " = " + (numerator / denominator));
                    }
                    //catches if input is a non-integer
                }catch(NumberFormatException e){
                    outputLabel.setText("Please input numbers");
                    //catches error besides it being a non-integer
                }catch(Exception e){
                    outputLabel.setText("Error, please try again later :( "); 
                }
            }
        );

        //makes the stage visible
        mainStage.show();
    }
}
