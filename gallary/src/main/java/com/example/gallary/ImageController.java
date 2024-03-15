package com.example.gallary;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.imagee;

public class ImageController {

    @FXML
    private ImageView img;

    private imagee image;

    public void setData(imagee image){

        this.image = image;

        Image imagee = new Image(getClass().getResourceAsStream(image.getImgSrc()));
        img.setImage(imagee);

    }

}
