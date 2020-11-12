package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.*;
import java.util.Stack;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Label lblCards;
    @FXML
    private ListView<String> lstSpades;
    @FXML
    private ListView<String> lstHearts;
    @FXML
    private ListView<String> lstClubs;
    @FXML
    private ListView<String> lstDiamonds;

    ObservableList<String> lstSpadesItems = FXCollections.observableArrayList();
    ObservableList<String> lstHeartsItems = FXCollections.observableArrayList(); // добавил
    ObservableList<String> lstClubsItems = FXCollections.observableArrayList();
    ObservableList<String> lstDiamondsItems = FXCollections.observableArrayList();

//    private Stack<CardDeck> deck;

//    public CardDeck getCardFromDeck() {
//        return deck.pop();
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Привязываем коллекции к ListView
        lstSpades.setItems(lstSpadesItems);
        lstHearts.setItems(lstHeartsItems);
        lstClubs.setItems(lstClubsItems);
        lstDiamonds.setItems(lstDiamondsItems);

        // привязали к лейблам инициализацию перетягивания
        lblCards.setOnDragDetected(this::onDragDetected);

        lstSpades.setOnDragOver(this::onListViewDragOver);
        lstHearts.setOnDragOver(this::onListViewDragOver);
        lstClubs.setOnDragOver(this::onListViewDragOver);
        lstDiamonds.setOnDragOver(this::onListViewDragOver);

        // реакция на отпускание мыши
        lblCards.setOnDragDropped(this::onListViewDragDropped);
    }

    // это скопипастили из прошлой реализации
    public void onDragDetected(MouseEvent mouseEvent) {
        Node sourceNode = (Node) mouseEvent.getSource();
        Dragboard db = sourceNode.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString("");
        db.setContent(content);

        mouseEvent.consume();
    }

    //Бросание
    public void onListViewDragOver(DragEvent dragEvent) {
        dragEvent.acceptTransferModes(TransferMode.ANY);
    }

    //Отпускание
    public void onListViewDragDropped(DragEvent dragEvent) {
        // над каким списком отпустили
        ListView<String> targetListView = (ListView) dragEvent.getGestureTarget();

        // с какого лейбла тянули
        Label sourceLabel = (Label) dragEvent.getGestureSource();

        // добавляем текст лейбла в список
        targetListView.getItems().add(sourceLabel.getText());
    }
}
