
/**
 * Application will create a center label stating which quadrant(UR,LR,UL,LL) the user's mouse clicked on
 *
 * @author Angie Diaz
 * @version 1.0 08.31.2024
 * 
 * 10/10 Points: Source code contains program header and comments; code organized and readable; does not include extraneous code, import statements, etc.
 * 10/10 Points: created Label in center of screen 
 * 10/10 Points: text appears in Label when mouse is clicked
 * 60/60 Points (4 cases, worth 15 points each): correct text appears in Label when clicking in each corner
 * 10/10 Points: Grade report completed fully and accurately
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class CornerClicker extends Application{
    public static void main(String [] args){
        try{
            launch(args); //create the stage, calls the start method 
        }
        catch(Exception error){
            error.printStackTrace();
        }finally{
            System.exit(0);
        }

    }

    public void start(Stage mainStage){
        //layout manager: this will organize the contents in window
        mainStage.setTitle("CornerClicker"); //title for window
        mainStage.setResizable(false);

        //Pane root = new Pane(); 
        /**
         * Citation: 
         * Line 53: StackPane
         * YouTube Video: "JavaFX Java GUI Tutorial - 1 - Creating a Basic Window" by thenewboston
         * Date of access: 08/31/2024
         * Date of video: 03/04/2015
         * Use: It showed me how to center the label using the StackPane()
         */
        StackPane root = new StackPane(); //initilaize the pane first: StackPane: this automatically centers
        List<Node> rootList = root.getChildren(); 

        //create scene for window 
        //@parameters width and height of the window
        Scene mainScene = new Scene(root,360,360); //window size

        //attach the scene on the stage
        mainStage.setScene(mainScene);

        //creating labels to be displayed
        Label messageLabel = new Label("Click Anywhere");

        //messageLabel.setLayoutX(100); //don't need if i use stackpane because of automatic center 
        //messageLabel.setLayoutY(100); //don't need if i use stackpane because of automatic center 
        rootList.add(messageLabel);

        //will only activate if the window has focus
        //will run when user decides to click into the scene
        mainScene.setOnMousePressed(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    double getCoordinate = event.getX();
                    double getCoordinate2 = event.getY();
                    //if statement that states the quadrant where the user has clicked
                    if(getCoordinate >180 && getCoordinate2 <180){ //condition for Top-right
                        messageLabel.setText("Upper Right or Top Right");

                    }else if(getCoordinate < 180 && getCoordinate2 > 180){ //condition for Bottom-left
                        messageLabel.setText("Lower Left or Bottom-left");
                    }else if(getCoordinate >=180 && getCoordinate2 >=180){ //condition for Bottom-right
                        messageLabel.setText("Lower Right or Bottom-Right");
                    }else{
                        messageLabel.setText("Upper Left or Top-Left"); //condition for Top-left
                    }

                }

            }
        );
        mainStage.show(); //reveals everything onto my scene

    }
}

