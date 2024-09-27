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
import java.io.File;
import java.io.PrintWriter;

/**
 * This event Reminder application will contain 4 text fields, 4 labels and one button. This will be used to save information regarding an event. The information will be
 * as follows: event name, date and time, location, and description. If any of the textFields are empty, then it won't create a file onto the person's system, but an alertbox
 * will appear that data has to be in the textfield. If all textFields have data available then it will save a file onto the system. 
 * @author Angie Diaz
 * @version 3.0 09/20/24
 * 
 * 12/12 Points: Source code contains program header and comments; code organized and readable
 * 18/18 Points Each (2 points each, 9 total): Created 4 labels, 4 text fields, and 1 button
 * 20/20 Points: Label/TextField/Button objects aligned as described, contain relevant text
 * 20/20 points (5 points each, 4 total): Alert box appears on button click if any fields are blank, and describe the missing data
 * (e.g. if the text field for location is empty, display “Please enter a location for this event.”)
 * 10/10 Points: FileChooser appears on button click only when all text fields have data
 * 10/10 Points: Data written to text file in format shown above
 * 10/10 Points: Grade report completed fully and accurately
 * 
 *   JavaFX API: https://openjfx.io/javadoc/11/
 *   
 */ 
public class EventReminder extends Application 
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
        mainStage.setTitle("Event Reminder");
        mainStage.setResizable(false);

        // layout manager: organize window contents
        GridPane grid = new GridPane();

        // add padding/margin around layout manager
        grid.setPadding( new Insets(16) );
        // add space between objects in layout manager
        grid.setVgap(10);
        grid.setHgap(10);
        // set alignment of objects in layout manager (default: Pos.TOP_LEFT)
        grid.setAlignment( Pos.CENTER );
        // set font size of objects
        grid.setStyle(  "-fx-font-size: 24;"  );

        // Scene: contains window content
        // parameters: layout manager; width window; height window
        Scene mainScene = new Scene(grid, 600, 600);
        // attach/display Scene on Stage (window)
        mainStage.setScene( mainScene );

        //***Custom Code below*** 

        //create labels and textfields for event, date and time, location and description
        Label eventLabel = new Label("Event Name");
        TextField eventField = new TextField();

        Label DateLabel = new Label("Date and Time");
        TextField dateField = new TextField();

        Label locationLabel = new Label("Location");
        TextField locationField = new TextField();

        Label descriptionLabel = new Label("Description");
        TextField descriptionField = new TextField();

        //create button 
        Button saveButton = new Button("Save Reminder");

        //now have the button become clickable: interactive with the user
        saveButton.setOnAction((ActionEvent event) ->
            {
                try
                {

                    //if-else conditions if any of the textFields are empty it will produce an alertBox when button is clicked
                    if(eventField.getText().isEmpty()) //if eventField is empty
                    {
                        Alert fileAlert = new Alert(AlertType.ERROR);
                        fileAlert.setContentText("Please enter an event name for this event.");
                        fileAlert.showAndWait();
                    }else if(dateField.getText().isEmpty()) //if dateField is empty
                    {
                        Alert fileAlert = new Alert(AlertType.ERROR);
                        fileAlert.setContentText("Please enter a date and time for this event.");
                        fileAlert.showAndWait();
                    }else if(locationField.getText().isEmpty()) //if locationField is empty 
                    {
                        Alert fileAlert = new Alert(AlertType.ERROR);
                        fileAlert.setContentText("Please enter a location for this event.");
                        fileAlert.showAndWait();
                    }else if(descriptionField.getText().isEmpty()) //if descriptionField is empty
                    {
                        Alert fileAlert = new Alert(AlertType.ERROR);
                        fileAlert.setContentText("Please enter a description for this event.");
                        fileAlert.showAndWait();
                    }
                    //File is made with PrintWriter
                    //a file chooser opens a driectory browsing window
                    //(similar to File Explorer on Windows or Finder on Mac
                    // allows you to specify the location and name of a file
                    else 
                    {
                        FileChooser fileChooser = new FileChooser();

                        //note: showSaveDialog creates a brand new file
                        File textFile = fileChooser.showSaveDialog(mainStage);
                        PrintWriter printFile = new PrintWriter(textFile);
                        printFile.println("Event Name: " + eventField.getText()); //this grabs the text from the eventField
                        printFile.println("Date and Time: " + dateField.getText()); //grabs the text from the dateField
                        printFile.println("Location: " + locationField.getText()); //grabs the text from the locationField
                        printFile.println("Description: " + descriptionField.getText()); //grabs the text from the descriptionField
                        printFile.close(); //prevents any corruption to file
                    }

                }
                catch(Exception error)
                {
                    error.printStackTrace();
                    System.exit(0);
                }

            }
        );
        //setting the object and then x and y which represents the columns and the rows
        grid.add(eventLabel, 0, 0);
        grid.add(eventField, 1, 0);
        grid.add(DateLabel, 0, 1);
        grid.add(dateField,1, 1 ); 
        grid.add(locationLabel, 0, 2);
        grid.add(locationField, 1, 2);
        grid.add(descriptionLabel, 0, 3);
        grid.add(descriptionField, 1, 3);
        grid.add(saveButton, 1, 4);

        //make it visible in window
        mainStage.show();
    }
}

