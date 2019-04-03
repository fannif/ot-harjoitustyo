
package sudoku.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sudoku.domain.Sudoku;

public class UserInterface extends Application {
    
    /**
     * Method that creates the visual user interface and manages it.
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Sudoku sudoku = new Sudoku();
        sudoku.newSudoku();
        
        BorderPane startLayout = new BorderPane();
        startLayout.setStyle("-fx-background-color: #ffedff");
        
        VBox startMenu = new VBox(30);
        startMenu.setPadding(new Insets(100));
        
        Label welcome = new Label("Welcome!\nWhat would you like to do?");
        Button play = new Button("Play game");
        Button records = new Button("View High Scores");
        
        welcome.setFont(Font.font("Verdana", 20));
        play.setFont(Font.font("Verdana", 20));
        records.setFont(Font.font("Verdana", 20));
        
        startMenu.setAlignment(Pos.CENTER);
        
        startMenu.getChildren().add(welcome);
        startMenu.getChildren().add(play);
        startMenu.getChildren().add(records);
        
        startLayout.setCenter(startMenu);
        
        Scene startScene = new Scene(startLayout, 600, 600);
        
        BorderPane sudokuLayout = new BorderPane();
        
        VBox options = new VBox(10);
        options.setPadding(new Insets(10));
        
        Button back = new Button("Return to start menu");
        Button newSudoku = new Button("Generate new sudoku");
        Button check = new Button("Check my sudoku");
        check.setFont(Font.font("Verdana", 20));
        
        options.getChildren().addAll(back, newSudoku, check);
        
        GridPane sudokuGrid = new GridPane();
        sudokuGrid.setAlignment(Pos.CENTER);
        for (int i=1; i <= 9; i++) {
            for (int j=1; j <= 9; j++) {
                if (sudoku.getValue(i-1, j-1) == 0) {
                    TextArea square = new TextArea();
                    square.setMaxSize(40,40);
                    square.setMinSize(40,40);
                    sudokuGrid.add(square, i, j);
                } else {
                    Label square = new Label(" "+sudoku.getValue(i-1, j-1));
                    square.setMaxSize(40,40);
                    square.setMinSize(40,40);
                    square.setFont(Font.font("Verdana", 20));
                    square.setStyle("-fx-background-color: #eeeeee");
                    sudokuGrid.add(square, i, j);
                }                
            }
        }
        
        sudokuLayout.setCenter(sudokuGrid);
        sudokuLayout.setTop(options);
        sudokuLayout.setStyle("-fx-background-color: #edffff");
        
        Scene sudokuScene = new Scene(sudokuLayout, 600, 600);
        
        play.setOnAction((event) -> {
            primaryStage.setScene(sudokuScene);
        });
        
        back.setOnAction((event) -> {
            primaryStage.setScene(startScene);
        });
        
        
        primaryStage.setScene(startScene);
        primaryStage.show();
    }
    
    
    /**
     * Main method that starts the program.
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
