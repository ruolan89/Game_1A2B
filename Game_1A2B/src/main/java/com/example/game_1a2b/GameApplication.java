package com.example.game_1a2b;

import com.example.game_1a2b.model.Game;
import com.example.game_1a2b.model.Guess;
import com.example.game_1a2b.model.SecretNumber;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class GameApplication extends Application {
    private Button startGameBtn;
    private Button quitBtn;
    private Button submitBtn;
    private Button clearBtn;
    private Button zeroBtn;
    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;
    private Button fourBtn;
    private Button fiveBtn;
    private Button sixBtn;
    private Button sevenBtn;
    private Button eightBtn;
    private Button nineBtn;
    private Text history;
    private TextField inputTF;
    private Game game;
    private SecretNumber secretNumber;
    private VBox historyVbox;
    private Text message;
    @Override
    public void start(Stage stage) throws Exception {
        startGameBtn = new Button("Start");
        quitBtn = new Button("Quit");

        zeroBtn = new Button("0");
        oneBtn = new Button("1");
        twoBtn = new Button("2");
        threeBtn = new Button("3");
        fourBtn = new Button("4");
        fiveBtn = new Button("5");
        sixBtn = new Button("6");
        sevenBtn = new Button("7");
        eightBtn = new Button("8");
        nineBtn = new Button("9");
        clearBtn = new Button("Clear");

        submitBtn = new Button("Check");
        inputTF = new TextField();
        message = new Text();

        history = new Text("History");

        HBox hBox = new HBox(startGameBtn,quitBtn);
        hBox.setPadding(new Insets(10, 0, 0, 10));
        hBox.setSpacing(10);

        HBox hBox2 = new HBox(inputTF,submitBtn,message);
        hBox2.setPadding(new Insets(10, 0, 0, 10));
        hBox2.setSpacing(10);
        inputTF.setPrefWidth(100);
        inputTF.setEditable(false);
        inputTF.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 4) {
                inputTF.setText(oldValue);
            }
        });
        message.setFill(Color.RED);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 0, 0, 10));

        gridPane.add(zeroBtn,0,1);
        gridPane.add(oneBtn,1,1);
        gridPane.add(twoBtn,2,1);
        gridPane.add(threeBtn,3,1);

        gridPane.add(fourBtn,0,2);
        gridPane.add(fiveBtn,1,2);
        gridPane.add(sixBtn,2,2);
        gridPane.add(sevenBtn,3,2);

        gridPane.add(eightBtn,0,3);
        gridPane.add(nineBtn,1,3);
        gridPane.add(clearBtn,2,3);
        gridPane.setColumnSpan(clearBtn,2);
        clearBtn.setPrefWidth(60);

        startGameBtn.setOnAction(event -> clickStartBtnEvent());
        quitBtn.setOnAction(event -> Platform.exit());

        submitBtn.setOnAction(actionEvent -> clickCheckBtnEvent(inputTF.getText()));

        zeroBtn.setOnAction(actionEvent -> clickNumberEvent(zeroBtn));
        oneBtn.setOnAction(actionEvent -> clickNumberEvent(oneBtn));
        twoBtn.setOnAction(actionEvent -> clickNumberEvent(twoBtn));
        threeBtn.setOnAction(actionEvent -> clickNumberEvent(threeBtn));
        fourBtn.setOnAction(actionEvent -> clickNumberEvent(fourBtn));
        fiveBtn.setOnAction(actionEvent -> clickNumberEvent(fiveBtn));
        sixBtn.setOnAction(actionEvent -> clickNumberEvent(sixBtn));
        sevenBtn.setOnAction(actionEvent -> clickNumberEvent(sevenBtn));
        eightBtn.setOnAction(actionEvent -> clickNumberEvent(eightBtn));
        nineBtn.setOnAction(actionEvent -> clickNumberEvent(nineBtn));
        clearBtn.setOnAction(actionEvent -> clickClearBtnEvent());

        HBox hBoxHistory = new HBox(history);
        hBoxHistory.setAlignment(Pos.CENTER);

        historyVbox = new VBox();
        historyVbox.setSpacing(10);
        historyVbox.setAlignment(Pos.CENTER);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(historyVbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(270);

        VBox root = new VBox(hBox,hBox2,gridPane,hBoxHistory,scrollPane);

        Scene scene = new Scene(root, 400,500);

        stage.setScene(scene);
        stage.setTitle("1A2B");
        stage.show();
    }

    private void clickCheckBtnEvent(String text) {
        if (Objects.isNull(game)){
            message.setText("Please Start a Game");
            return;
        }
        if (text.length()<4){
            message.setText("The Answer Requires 4 Digits");
            return;
        }
        if (game.isEnd()){
            return;
        }
        Guess guess = new Guess(text);
        guess.feedBack(secretNumber);
        game.updateHistory(guess);
        displayHistory(guess);
        inputTF.setText("");
        System.out.println(secretNumber);
    }

    private void displayHistory(Guess guess) {
        String text = guess.getGuess() + "    " + guess.getFeedback();
        Text historyT = new Text(text);
        historyVbox.getChildren().add(historyT);
    }

    private void clickStartBtnEvent() {
        //clear textField and history
        inputTF.setText("");
        message.setText("");
        historyVbox.getChildren().clear();

        //create new game
        secretNumber = new SecretNumber(4);
        secretNumber.createNumbers();
        game = new Game(secretNumber);
        System.out.println(game.getSecret().getSecretNumber());
    }

    private void clickNumberEvent(Button button){
        inputTF.setText(inputTF.getText()+button.getText());
    }
    public void clickClearBtnEvent(){
        inputTF.setText("");
    }
    public static void main(String[] args) {
        launch(args);
    }
}
