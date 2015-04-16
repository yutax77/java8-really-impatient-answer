package com.yutax77.java8_ans.chap3.ans14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ans14 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
	Image image = new Image(getClass().getResourceAsStream("../eiffel-tower.jpg"));
	Image edgeImage = LatentImage.from(image)
		.transform(Color::grayscale).transform(ColorTransformer.edgeDetector())
		.toImage();      
	Image blueImage = LatentImage.from(image)
		.transform(Color::brighter).transform(ColorTransformer.blurDetector())
		.toImage();   
	stage.setScene(new Scene(new HBox(
		new ImageView(image),
		new ImageView(edgeImage),
		new ImageView(blueImage))));
	stage.show();
    }
    
    public static void main(String[] args) {
	launch();
    }
}
