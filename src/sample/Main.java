package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Main extends Application {

  public static final String URL =
    //"https://bitdash-a.akamaihd.net/content/MI201109210084_1/m3u8s/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.m3u8";
    "https://trinity-lh.akamaihd.net/i/TTPrimary_d@68975/master.m3u8";

  @Override
  public void start(Stage primaryStage) throws Exception {

    Media media = new Media(URL);

    MediaPlayer player = new MediaPlayer(media);
    player.setAutoPlay(true);

    MediaView mediaView = new MediaView();
    mediaView.setMediaPlayer(player);
    mediaView.setOnError(event -> {
      event.getMediaError().printStackTrace();
    });

    StackPane parent = new StackPane(mediaView);
    parent.setOnMouseClicked(event -> {
      player.stop();
      player.play();
    });

    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(parent, 300, 275));
    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }

}
