/*
 * CopyRight © 2018, LOTFI BOUKHEMERRA.
 * All rights reserved.
 * Apache License
 * Version 2.0, January 2004
 * http://www.apache.org/licenses/
 */
package pkg;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * 
 * @author BOUKHEMERRA Lotfi.
 * @Version 1.0
 * @repository https://github.com/LotfiBoukhemerra
 * @JDK 1.8
 */
public class Main extends Application {

    private double initX;
    private double initY;
    private List<ImageView> ClockHandsIcon;
    private Timeline timeUpdater;
    Calendar c;

    @Override
    public void start(Stage stage) throws Exception {
        WidgetVersions widgetVersions = new WidgetVersions();

        Group root = new Group();

        ClockHandsIcon = new ArrayList<>();

        Label contextMenuLabel = new Label();
        contextMenuLabel.setBackground(Background.EMPTY);
        contextMenuLabel.setPrefSize(192.0, 192.0);
        contextMenuLabel.setLayoutX(0);
        contextMenuLabel.setLayoutY(0);

        ContextMenu contextMenu = new ContextMenu();
        MenuItem about = new MenuItem("About");
        about.setDisable(true);
        MenuItem minimize = new MenuItem("Minimize");
        Menu style = new Menu("style");
        MenuItem iceCream = new MenuItem("IceCream");
        MenuItem lollipop = new MenuItem("lollipop");
        MenuItem oreo = new MenuItem("Oreo");
        Menu other = new Menu("other");
        MenuItem highlight = new MenuItem("highlight");
        MenuItem light = new MenuItem("light");        
        other.getItems().addAll(highlight, light);
        style.getItems().addAll(iceCream, lollipop, oreo, other);
        MenuItem exit = new MenuItem("Exit");
        
        minimize.setOnAction((event) -> {
           stage.setIconified(true);
        });
        
        lollipop.setOnAction((event) -> {
            if (stage.getIcons() != widgetVersions.src[0][0]) {
                stage.getIcons().add(widgetVersions.src[0][0]);
                for (int i = 0; i < 4; i++) {
                    ClockHandsIcon.get(i).setImage(widgetVersions.src[0][i + 1]);
                }//end for
                c = Calendar.getInstance();
                ClockHandsIcon.get(3).setRotate(6 * c.get(Calendar.SECOND));
            }// end if
        });
        oreo.setOnAction((event) -> {
            if (stage.getIcons() != widgetVersions.src[1][0]) {
                stage.getIcons().add(widgetVersions.src[1][0]);
                for (int i = 0; i < 4; i++) {
                    ClockHandsIcon.get(i).setImage(widgetVersions.src[1][i + 1]);
                }//end for
            }//end if
        });
        
        iceCream.setOnAction((event) -> {
            if (stage.getIcons() != widgetVersions.src[2][0]) {
                stage.getIcons().add(widgetVersions.src[2][0]);
                for (int i = 0; i < 4; i++) {
                    ClockHandsIcon.get(i).setImage(widgetVersions.src[2][i + 1]);
                }//end for
                c = Calendar.getInstance();
                ClockHandsIcon.get(3).setRotate(6 * c.get(Calendar.SECOND));
            }//end if
        });
        
        highlight.setOnAction((event) -> {
            ClockHandsIcon.get(0).setImage(widgetVersions.HIGHLIGHT_BG);
        });
        
        light.setOnAction((event) -> {
            ClockHandsIcon.get(0).setImage(widgetVersions.LIGHT_BG);
        });
        
        exit.setOnAction((event) -> {
            Platform.exit();// GUI
            System.exit(0);// JVM
        });
        contextMenu.getItems().addAll(minimize, about, style, exit);
        contextMenuLabel.setContextMenu(contextMenu);

        ImageView background = new ImageView();
        ImageView hour_hand = new ImageView();
        ImageView minute_hand = new ImageView();
        ImageView second_hand = new ImageView();

        ClockHandsIcon.add(background);
        ClockHandsIcon.add(hour_hand);
        ClockHandsIcon.add(minute_hand);
        ClockHandsIcon.add(second_hand);
        ClockHandsIcon.forEach((t) -> {
            t.setFitHeight(192.0);
            t.setFitWidth(192.0);
        });
        for (int i = 0; i < 4; i++) {
            ClockHandsIcon.get(i).setImage(widgetVersions.src[0][i + 1]);
        }

        root.getChildren().addAll(background, hour_hand, minute_hand, second_hand, contextMenuLabel);

        c = Calendar.getInstance();
        second_hand.setRotate(6 * c.get(Calendar.SECOND));
        minute_hand.setRotate(6 * c.get(Calendar.MINUTE));
        hour_hand.setRotate(30 * (c.get(Calendar.HOUR)));

        Scene scene = new Scene(root, 192.0, 192.0, Color.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.setOnMousePressed(e -> {
            initX = e.getScreenX() - stage.getX();
            initY = e.getScreenY() - stage.getY();

        });
        scene.setOnMouseReleased(e -> {
            stage.setOpacity(1);
        });
        scene.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {
                stage.setIconified(true);
            }
        });

        scene.setOnMouseDragged(e -> {
            stage.setX(e.getScreenX() - initX);
            stage.setY(e.getScreenY() - initY);
            stage.setOpacity(0.7);
        });
        
        stage.setScene(scene);
        stage.sizeToScene();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.getIcons().add(widgetVersions.src[0][0]);
        stage.show();

        timeUpdater = new Timeline(new KeyFrame(Duration.seconds(1.0), (ActionEvent e) -> {
            c = Calendar.getInstance();
            if (second_hand.getImage() != null) {
                second_hand.setRotate(6 * c.get(Calendar.SECOND));
            }
            minute_hand.setRotate(6 * c.get(Calendar.MINUTE));
            hour_hand.setRotate(30 * (c.get(Calendar.HOUR)));

        }));
        timeUpdater.setCycleCount(Animation.INDEFINITE);
        timeUpdater.play();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
