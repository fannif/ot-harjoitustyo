
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sudoku.domain.Sudoku;

public class UserInterface extends Application {
    
    private TextArea[][] squaresToFill = new TextArea[9][9];
    
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
                    squaresToFill[i-1][j-1] = new TextArea();
                    TextArea square = new TextArea();
                    square.setMaxSize(40,40);
                    square.setMinSize(40,40);
                    square.setFont(Font.font("Verdana", 20));
                        
                    int row = i-1;
                    int column = j-1;
                        
                    square.textProperty().addListener((change, from, to) -> {
                        squaresToFill[row][column].setText(to);
                    });
                        
                    sudokuGrid.add(square, i, j);
                } else {
                    Label square = new Label(" "+sudoku.getValue(i-1, j-1));
                    square.setMaxSize(40,40);
                    square.setMinSize(40,40);
                    square.setFont(Font.font("Verdana", 20));
                    if ((i < 4 && j < 4) || (i > 6 && j > 6) || (i > 6 && j < 4) || (i < 4 && j > 6) || ((i < 7 && i > 3) && (j < 7 && j > 3))) {
                        square.setStyle("-fx-background-color: #fefeee");
                    } else {
                        square.setStyle("-fx-background-color: #eeefef");
                    }
                    square.setTextAlignment(TextAlignment.CENTER);
                    square.setWrapText(true);
                    sudokuGrid.add(square, i, j);
                    squaresToFill[i-1][j-1] = new TextArea(""+sudoku.getValue(i-1, j-1));
                }                
            }
        }
        
        
        Label timeUsed = new Label();
        Label correct = new Label();
        correct.setFont(Font.font("Verdana", 20));
        
        HBox sudokuTop = new HBox(10);
        sudokuTop.setPadding(new Insets(10));
        sudokuTop.getChildren().addAll(options, correct);
                        
        sudokuLayout.setCenter(sudokuGrid);
        sudokuLayout.setTop(sudokuTop);
        sudokuLayout.setRight(timeUsed);
        sudokuLayout.setStyle("-fx-background-color: #edffff");
        
        Scene sudokuScene = new Scene(sudokuLayout, 600, 600);
        
        BorderPane recordsLayout = new BorderPane();
        
        VBox highScores = new VBox(10);
        highScores.setPadding(new Insets(10));
        
        Button back2 = new Button("Return to start menu");
        Label recordsTitle = new Label("Here are the current high scores");
        recordsTitle.setFont(Font.font("Verdana", 18));
        highScores.getChildren().add(recordsTitle);
        
        for (int i = 0; i < 10; i++) {
            Label record = new Label((i+1) + ". ");
            // Here add also the info from dao list
            // related to index i
            record.setFont(Font.font("Verdana", 14));
            highScores.getChildren().add(record);
        }
        
        recordsLayout.setCenter(highScores);
        recordsLayout.setTop(back2);
        recordsLayout.setStyle("-fx-background-color: #ffffed");
        
        Scene recordsScene = new Scene(recordsLayout, 600, 600);
        
        play.setOnAction((event) -> {
            primaryStage.setScene(sudokuScene);
        });
        
        back.setOnAction((event) -> {
            correct.setText("");
            primaryStage.setScene(startScene);
        });
        
        
        // TextAreas corresponding to the labels too
        // This way we can just check them all
        
        newSudoku.setOnAction((event) -> {
            sudoku.newSudoku();
            for (int i=1; i <= 9; i++) {
                for (int j=1; j <= 9; j++) {
                    if (sudoku.getValue(i-1, j-1) == 0) {
                        TextArea square = new TextArea();
                        square.setMaxSize(40,40);
                        square.setMinSize(40,40);
                        square.setFont(Font.font("Verdana", 20));
                        
                        int row = i-1;
                        int column = j-1;
                        
                        square.textProperty().addListener((change, from, to) -> {
                            squaresToFill[row][column].setText("" + to);
                        });
                        
                        sudokuGrid.add(square, i, j);
                    } else {
                        Label square = new Label(" "+sudoku.getValue(i-1, j-1));
                        square.setMaxSize(40,40);
                        square.setMinSize(40,40);
                        square.setFont(Font.font("Verdana", 20));
                        if ((i < 4 && j < 4) || (i > 6 && j > 6) || (i > 6 && j < 4) || (i < 4 && j > 6) || ((i < 7 && i > 3) && (j < 7 && j > 3))) {
                            square.setStyle("-fx-background-color: #fefeee");
                        } else {
                            square.setStyle("-fx-background-color: #eeefef");
                        }
                        square.setTextAlignment(TextAlignment.CENTER);
                        square.setWrapText(true);
                        sudokuGrid.add(square, i, j);
                        squaresToFill[i-1][j-1] = new TextArea(""+sudoku.getValue(i-1, j-1));
                    }                
                }
            }
            correct.setText("");
            primaryStage.setScene(sudokuScene);
        });
        
        check.setOnAction((event) -> {
            boolean correctSudoku = true;
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    String answer = squaresToFill[i][j].getText();
                    if (answer.matches("1|2|3|4|5|6|7|8|9")) {
                        sudoku.setValue(i, j, Integer.parseInt(answer));
                    } else {
                        correctSudoku = false;
                        break;
                    }
                }
            }
            
            boolean[][] correctSquares = sudoku.checkSudoku();
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (!correctSquares[i][j]) {
                        correctSudoku = false;
                    }
                }
            }
            if (!correctSudoku) {
                correct.setText("Your sudoku is incorrect");
            } else {
                correct.setText("Correct!");
            }
            // Show text incorrect or correct
            // Later add the possibility to save score
        });
        
        records.setOnAction((event) -> {
            primaryStage.setScene(recordsScene);
        });
        
        back2.setOnAction((event) -> {
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
