
/**
 * This application uses at least once these shapes and styling--rectangle, oval, polygon, text, color,and gradient. The image below displays a house 
 * made up of the shapes detailed earlier and a sun in the sky with a blue gradient sky. The image contains the text 'Home Sweet Home'. 
 *
 * @Angie Diaz
 * @version 5.0 09/22/24
 * 
 *15/15 Points: Source code contains program header and comments; code organized and readable
 *60/60 Points (10 points each): used at least one of each of the following: rectangle, oval, polygon, text, color, gradient.
 *15/15 Points: your image displays a high level of creativity and effort (yes, this is subjective)
 *10/10 Points: Grade report completed fully and accurately
 *  
 *  
 */
import javafx.application.*;
import javafx.stage.*;
import javafx.stage.FileChooser.*;
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

/**
 *   
 *   JavaFX API: https://openjfx.io/javadoc/11/
 */ 
public class CanvasPainting extends Application 
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
        mainStage.setTitle("My Home");
        mainStage.setResizable(false);

        // layout manager: organize window contents
        VBox root = new VBox();
        List<Node> rootList = root.getChildren();

        // add padding/margin around layout manager
        root.setPadding(new Insets(16));
        root.setSpacing(16);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-font-size: 24;");

        // Scene: contains window content
        Scene mainScene = new Scene(root, 800, 600);
        mainStage.setScene(mainScene);

        // custom application code below -------------------

        // a Canvas object allows you to draw lines, shapes, text, etc.
        Canvas canvas = new Canvas(700, 500); // smaller canvas than the window
        rootList.add(canvas);

        // GraphicsContext class has methods to draw on a Canvas object
        GraphicsContext context = canvas.getGraphicsContext2D();

        // Draw gradient sky (blue to light blue)
        //a gradient is a transition between two or more colors
        //first step: define a series of 'stops': colors to be used at different postions along a line
        //stops will reach up to 1.00
        //Parameters for start location
        //(x1, y1) start location
        //(x2, y2) end location
        //true parameter: is proportional to the shape which the gradient fills
        //0 to 1 ratio 
        //those postions dictate the width of the colors: if you change the points 
        LinearGradient skyGradient = new LinearGradient(
                0, 0, 0, 1, true,
                CycleMethod.NO_CYCLE, 
                new Stop(0, Color.BLUE), 
                new Stop(1, Color.LIGHTBLUE)
            );
        context.setFill(skyGradient);
        context.fillRect(0, 0, 700, 250); 

        // Draw grass 
        context.setFill(Color.FORESTGREEN);
        context.fillRect(0, 250, 700, 250); // fill the bottom half for the grass

        // Oval used here: Draw sun
        context.setFill(Color.YELLOW);
        context.fillOval(300, 50, 100, 100); // sun in the middle

        // Rectangle used here: Draw house (rectangle)
        context.setFill(Color.ROSYBROWN);
        context.fillRect(200, 300, 300, 150); // house base

        //Polygon used here: Draw roof (triangle)
        // to draw a polygon with vertices at (x1,y1), (x2,y2), (x3,y3), ...
        // need array of x-coordinates { x1, x2, x3, ... }
        // need array of y-coordinates { y1, y2, y3, ... }
        // example: triangle with vertices (300,50), (350,100), (250,150)
        double[] xCoordinatesRoof = {200, 350, 500};
        double[] yCoordinatesRoof = {300, 200, 300};
        context.setFill(Color.SADDLEBROWN);
        context.fillPolygon(xCoordinatesRoof, yCoordinatesRoof, 3);

        // Rectangle used here: Draw door
        context.setFill(Color.SIENNA);
        context.fillRect(325, 375, 50, 75);

        // Oval used here: Draw windows
        context.setFill(Color.YELLOW);
        context.fillOval(240, 330, 50, 70); // left window (oval)
        context.fillOval(410, 330, 50, 70); // right window (oval)

        // Drawing the text "Home sweet Home"
        context.setFill(Color.PERU);
        context.setFont(new Font("COMIC SANS MS", 36));
        context.fillText("Home Sweet Home", 200, 480);

        // custom application code above -------------------

        // after adding all content, make the Stage visible
        mainStage.show();
    }
}

