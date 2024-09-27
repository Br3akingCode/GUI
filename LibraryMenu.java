
/**
 * This application creates a library menu that has two main menus (Search and Library Information) on the menuBar. The window contains a label in the center
 * that tells the user to select an item. 
 * The search menu contains 3 menus within it and those menus contain sub-menus. The library Information menu contains 2 menus within it. Each sub-menu and menus within 
 * library information are clickable. Once menuItems are clicked, the label in the center will change to display the MenuItem that was selected.
 * 
 * @author Angie Diaz
 * @version 4.0 09/21/24
 *  20/20 Points: Source code contains program header and comments; code organized and readable.
 *  36/36 Points (2 points each, 18 total): Correctly added MenuBar, Menus, and MenuItems, with correct text/nesting.
 *  10/10 Points: Label appears in center of window.
 *  24/24 Points (2 points each, 12 total): Clicking on a MenuItem displays corresponding text in the label in the center of the window.
 *  10/10 Points: Grade report completed fully and accurately
 *  
 */
import javafx.stage.*;
import javafx.stage.FileChooser.*;
import javafx.scene.*;
import javafx.scene.canvas.*; 
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
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
import javafx.scene.input.*;
import javafx.application.*;

public class LibraryMenu extends Application{
    public static void main(String[] args){
        try{
            launch(args);
        }catch(Exception error){
            error.printStackTrace();
        }finally{
            System.exit(0);
        }
    }

    public void start(Stage mainStage){
        mainStage.setTitle("Library Menu");
        mainStage.setResizable(false);

        //layout manager
        BorderPane root = new BorderPane();
        root.setStyle("-fx-font-size: 24;");

        //scene contain the window content 
        Scene mainScene = new Scene(root, 600, 600);
        mainStage.setScene(mainScene);

        Label centerLabel = new Label("Please select an item");
        centerLabel.setAlignment(Pos.CENTER);
        root.setCenter(centerLabel);

        //MenuBar: contain all the menu objects 
        MenuBar menuBar = new MenuBar();
        root.setTop(menuBar);
        Menu menuSearch = new Menu("Search"); //Search Menu

        //add this menu to the list of menus managed by the menu bar 
        //think of menus as folders 
        menuBar.getMenus().add(menuSearch); //add menuSearch to my root

        Menu menuLib = new Menu("Library Information");
        //we are adding a menu to the menuBar
        menuBar.getMenus().add(menuLib); //this is the equivalent adding the menu so it can show or adding a button to a root list 

        //menu is like a folder that you can contain more menus or menu items 
        //menu item is an object that you can click on or select
        //contains menuItems for Library Information menu
        MenuItem hoursItem = new MenuItem("Hours and Location");
        MenuItem jobItem = new MenuItem("Employment Opportunities");

        //add menuItems to the Library Information Menu
        menuLib.getItems().add(hoursItem); 
        menuLib.getItems().add(jobItem);

        //create a sub menu within the BookMenu 
        Menu bookMenu = new Menu("Books");
        MenuItem titleItem = new MenuItem("Title");
        MenuItem authorItem = new MenuItem("Author");
        MenuItem subjectItem = new MenuItem("Subject");
        MenuItem callItem = new MenuItem("Call Number");

        //add MenuItems to bookMenu 
        bookMenu.getItems().add(titleItem);
        bookMenu.getItems().add(authorItem);
        bookMenu.getItems().add(subjectItem);
        bookMenu.getItems().add(callItem);

        //add all submenus to main menu searchMenu
        menuSearch.getItems().add(bookMenu);

        //create a sub menu within movieMenu
        Menu movieMenu = new Menu("Movies"); //create menu movieMenu
        MenuItem nameItem = new MenuItem("Title"); //crete submenu for title
        MenuItem actorItem = new MenuItem("Actor"); //create submenu for actor
        MenuItem directorItem = new MenuItem("Director"); //create submenu for director 

        movieMenu.getItems().add(nameItem);
        movieMenu.getItems().add(actorItem);
        movieMenu.getItems().add(directorItem);

        //add movieMenu onto menuSearch
        menuSearch.getItems().add(movieMenu); 

        //create a sub menu within musicMenu
        Menu musicMenu = new Menu("Music");
        MenuItem artistItem = new MenuItem("Artist/Band"); //create sub menu for artist
        MenuItem albumItem = new MenuItem("Album"); //create submenu for album
        MenuItem songItem = new MenuItem("Song"); //create submenu for song

        musicMenu.getItems().add(artistItem); //add artist as submenu
        musicMenu.getItems().add(albumItem); //add album as submenu
        musicMenu.getItems().add(songItem); //add song as submenu

        menuSearch.getItems().add(musicMenu); //add all submenus in musicMenu under menuSearch menu

        //add functionality to MenuItems (when clicked) 
        //functionality to MenuItems in bookMenu
        //ActionEvents is to make things clickable
        titleItem.setOnAction((ActionEvent event) -> 
        {
            centerLabel.setText("'Title' has been selected.");
        }
        );
        authorItem.setOnAction((ActionEvent event) ->
        {
            centerLabel.setText("'Author' has been selected.");
        }
        );
        
        subjectItem.setOnAction((ActionEvent event)->
        {
            centerLabel.setText("'Subject' has been selected.");
        }
        );
        callItem.setOnAction((ActionEvent event)->
        {
            centerLabel.setText("'Call Number' has been selected.");
        }
        );
        //functionality to menuItems in movieMenu
        nameItem.setOnAction((ActionEvent event)->
        {
            centerLabel.setText("'Title' has been selected.");
        }
        );
        actorItem.setOnAction((ActionEvent event)->
        {
            centerLabel.setText("'Actor' has been selected.");
        }
        );
        directorItem.setOnAction((ActionEvent event)->
        {
            centerLabel.setText("'Director' has been selected.");
        }
        );
        //functionality to menuItems in musicMenu
        artistItem.setOnAction((ActionEvent event)->
        {
            centerLabel.setText("'Artist/Band' has been selected.");
        }
        );
        albumItem.setOnAction((ActionEvent event)->
        {
            centerLabel.setText("'Album' has been selected.");
        }
        );
        songItem.setOnAction((ActionEvent event)->
        {
            centerLabel.setText("'Song' has been selected");
        }
        );
        //functionality to menuItems in menuLib
        hoursItem.setOnAction((ActionEvent event)->
        {
            centerLabel.setText("'Hours and Location' has been selected.");
        }
        );
        jobItem.setOnAction((ActionEvent event)->
        {
            centerLabel.setText("'Employment Opportunities' has been selected.");
        }
        );
        //make it visible onto window
        mainStage.show();

    }
}