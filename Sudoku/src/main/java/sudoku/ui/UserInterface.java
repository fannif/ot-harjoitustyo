
package sudoku.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserInterface extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
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
        
        GridPane sudoku = new GridPane();
        sudoku.setAlignment(Pos.CENTER);
        for (int i=1; i <= 9; i++) {
            for (int j=1; j <= 9; j++) {
                Button button = new Button();
                button.setMaxSize(40,40);
                button.setMinSize(40,40);
                sudoku.add(button, i, j);
            }
        }
        
        sudokuLayout.setCenter(sudoku);
        sudokuLayout.setTop(options);
        sudokuLayout.setStyle("-fx-background-color: #e5a52b");
        
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
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
