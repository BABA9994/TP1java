package src;

import javafx.application.Application;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class Interface extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        // On créer la fenetre
        primaryStage.setTitle("Hello la Terre");
        Earth earth = new Earth();
        Pane pane = new Pane(earth);
        Scene ihm = new Scene(pane, 1000, 600,true);
        primaryStage.setScene(ihm);
        primaryStage.show();

        // On créer la caméra et faisons les réglages de la cam
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-2000);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        camera.setFieldOfView(35);
        ihm.setCamera(camera);

        final double[] Xclick = new double[1];
        final double[] Yclick = new double[1];
        final double[] Yrelease = new double[1];
        final double[] Xrelease = new double[1];

        // On créer les fonctionnalités de zoom
        ihm.addEventHandler(MouseEvent.ANY, event -> {
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                System.out.println("Clicked on : (" + event.getSceneX()+ ", "+ event.getSceneY()+")");
                Xclick[0] = event.getSceneX();
                Yclick[0] = event.getSceneY();
            }
            if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                System.out.println("Clicked on DRAG : (" + event.getSceneX() + ", " + event.getSceneY() + ")");
                Xrelease[0] = event.getSceneX();
                Yrelease[0] = event.getSceneY();
                double delta_X = Xclick[0] - Xrelease[0];
                double delta_Y = Yclick[0] - Yrelease[0];


                double ancien_z = camera.getTranslateZ();
                double new_z = ancien_z + 0.05*delta_Y - 0.05*delta_X;
                camera.setTranslateZ(new_z);
                        //à vous de completer

            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
