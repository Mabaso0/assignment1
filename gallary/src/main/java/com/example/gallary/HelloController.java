package com.example.gallary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import model.imagee;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }



    private List<imagee> images = new ArrayList<>();
    private List<imagee> getData(){
        List<imagee> images = new ArrayList<>();
        imagee image;

        for (int i = 0; i < 20; i++) {
            image = new imagee();
            image.setImgSrc("../resources/img/.png");
            images.add(image);

        }
        return images;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        images.addAll(getData());

        int colunm = 0;
        int row = 0;

        try {
            for (int i = 0; i < images.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("image.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ImageController imagecontroller = fxmlLoader.getController();
                imagecontroller.setData(images.get(i));

                if (colunm == 3){
                    colunm = 0;
                    row ++;
                }

                grid.add(anchorPane, colunm++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}