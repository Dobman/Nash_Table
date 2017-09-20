package Controllers;


import Database.ConnectionDB;
import Nash.Nash;
import Nash.PushNash;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import Nash.NashDBDao;
public class PushController {

    @FXML
    HBox bbHbox;
    @FXML
    HBox positionHbox;
    @FXML
    private GridPane grid;
    @FXML
    private HBox navigation;
    public List<String> newNashTable;
    private ToggleGroup groupBb = new ToggleGroup();
    private ToggleGroup groupPosition = new ToggleGroup();
    NashDBDao nashDBDao = new NashDBDao();
    Button countButton = new Button("Zlicz!");
    Button sendButton = new Button("Zapisz");
    Button findButton = new Button("Pokaż tabele");
    public static final  String[] cardTabel = {
            "AA" , "AKs" , "AQs" , "AJs" , "A10s" , "A9s" , "A8s" , "A7s" , "A6s" , "A5s" , "A4s" , "A3s" , "A2s" ,
            "AKo" , "KK" , "KQs" , "KJs" , "K10s" , "K9s" , "K8s" , "K7s" , "K6s" , "K5s" , "K4s" , "K3s" , "K2s" ,
            "AQo" , "KQo" , "QQ" , "QJs" , "Q10s" , "Q9s" , "Q8s" , "Q7s" , "Q6s" , "Q5s" , "Q4s" , "Q3s" , "Q2s" ,
            "AJo" , "KJo" , "QJo" , "JJ" , "J10s" , "J9s" , "J8s" , "J7s" , "J6s" , "J5s" , "J4s" , "J3s" , "J2s" ,
            "A10o" , "K10o" , "Q10o" , "J10o" , "1010" , "109s" , "108s" , "107s" , "106s" , "105s" , "104s" , "103s" , "102s" ,
            "A9o" , "K9o" , "Q9o" , "J9o" , "109o" , "99" , "98s" , "97s" , "96s" , "95s" , "94s" , "93s" , "92s" ,
            "A8o" , "K8o" , "Q8o" , "J8o" , "108o" , "98o" , "88" , "87s" , "86s" , "85s" , "84s" , "83s" , "82s" ,
            "A7o" , "K7o" , "Q7o" , "J7o" , "107o" , "97o" , "87o" , "77" , "76s" , "75s" , "74s" , "73s" , "72s" ,
            "A6o" , "K6o" , "Q6o" , "J6o" , "106o" , "96o" , "86o" , "76o" , "66" , "65s" , "64s" , "63s" , "62s" ,
            "A5o" , "K5o" , "Q5o" , "J5o" , "105o" , "95o" , "85o" , "75o" , "65o" , "55" , "54s" , "53s" , "52s" ,
            "A4o" , "K4o" , "Q4o" , "J4o" , "104o" , "94o" , "84o" , "74o" , "64o" , "54o" , "44" , "43s" , "42s" ,
            "A3o" , "K3o" , "Q3o" , "J3o" , "103o" , "93o" , "83o" , "73o" , "63o" , "53o" , "43o" , "33" , "32s" ,
            "A2o" , "K2o" , "Q2o" , "J2o" , "102o" , "92o" , "82o" , "72o" , "62o" , "52o" , "42o" , "32o" , "22",
    };
    private static  final String[] positions = {
            "UTG", "UTG +1", "UTG +2", "MP1" ,"MP2", "MP3", "CO", "BTN", "SB", "BB"
    };

    public void initialize () {

        createTableButtons();
        navigation.getChildren().addAll(countButton);
        navigation.getChildren().addAll(sendButton);
        navigation.getChildren().addAll(findButton);
        countButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try (Connection connection = ConnectionDB.getConnection();
                     PreparedStatement statement = connection.prepareStatement("ADD_PUSH_NASH")) {
                    statement.setString(1,"a");
                    statement.setString(2,"a");
                    statement.setInt(3,4);
                    statement.setString(4,"sdfsdsfd");
                    int result = statement.executeUpdate();

                    if (result != 1) {
                        throw new RuntimeException("Execute update returned " + result);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        });
        sendButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                List<String> list = getNashBtn();
                Nash nash = new PushNash(
                        (String)groupPosition.getSelectedToggle().getUserData(),
                        (Integer)groupBb.getSelectedToggle().getUserData(),
                       list
                );

                nashDBDao.addNash(nash);
               // tu uruchom metode dodania do bazyNash.NashDBDao
            }
        });

        findButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        createBB();
        createPosition();

    }





    public List<String> getNashBtn(){
        List<Node> buttons = grid.getChildren();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < buttons.size()-1; i++) {
            if ((Integer) buttons.get(i).getUserData() == 1) {
                list.add(buttons.get(i).getId());
                System.out.println(buttons.get(i).getId());
            }
        }
        return list;
    }

    private void createBB (){
        for(int i = 1; i <= 20; i++){
            RadioButton radioButton = new RadioButton();
            radioButton.setId(String.valueOf(i));
            radioButton.setUserData(i);
            radioButton.setToggleGroup(groupBb);
            radioButton.setText(String.valueOf(i));
            System.out.println(radioButton.getText());
            System.out.println(radioButton.getId());
            bbHbox.getChildren().addAll(radioButton);

        }
    }
    private void createPosition(){
        for(int i = 0; i <= 9; i++){
            RadioButton radioButton = new RadioButton();
            radioButton.setId(positions[i]);
            radioButton.setUserData(positions[i]);
            radioButton.setToggleGroup(groupPosition);
            radioButton.setText(positions[i]);
            System.out.println(radioButton.getText());
            System.out.println(radioButton.getId());
            positionHbox.getChildren().addAll(radioButton);
        }
    }



    private void createTableButtons() {
        int count = 0;
        for (int i = 0; i < 13; i++) {

            for (int j = 0; j < 13; j++) {
                Button button = new Button();
                button.setText(cardTabel[count]);
                button.setStyle("-fx-font-size: 8px");
                button.setId(cardTabel[count]);
                button.setPrefSize(35, 35);
                button.setMaxSize(35, 35);
                button.setUserData(0);

               button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                   @Override
                   public void handle(MouseEvent mouseEvent) {
                       if(mouseEvent.getClickCount()%2 != 0){
                           button.setStyle("-fx-background-color: lightblue;-fx-font-size: 8px;   ");
                           button.setUserData(1);
                           System.out.println(button.getUserData());
                       }
                       else {
                           button.setStyle("-fx-background-color: darkgrey ; -fx-font-size: 8px");
                           button.setUserData(0);
                           System.out.println(button.getUserData());
                       }
                   }
               });

                grid.add(button, j, i);
                count++;

            }

        }

    }
    public List<String> getNewNashTable() {
        return newNashTable;
    }

}