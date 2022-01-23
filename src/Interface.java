package src;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;


public class Interface extends Application {

    static int WIDTH = 1400;
    static int HEIGHT = 800;

    @Override
    public void start(Stage primaryStage) throws Exception{



        // On créer la fenetre
        primaryStage.setTitle("Hello la Terre");
        Earth earth = new Earth();
        Pane pane = new Pane(earth);
        Scene ihm = new Scene(pane, WIDTH, HEIGHT,true);
        primaryStage.setScene(ihm);
        primaryStage.show();

        // On créer la caméra et faisons les réglages de la cam
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setTranslateZ(-2000);
        camera.setNearClip(0.1);
        camera.setFarClip(5000.0);
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
                double new_z = ancien_z + 0.01*delta_Y - 0.01*delta_X;
                camera.setTranslateZ(new_z);
                        //à vous de completer

            }

        });


        // On utilisera le clavier afin de zoomer, les touches fleche du haut, et flèche du bas
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            double ancien_z = camera.getTranslateZ();
            switch (event.getCode()) {
                case DOWN:
                    camera.setTranslateZ(ancien_z-35);
                    break;
                case UP:
                    camera.setTranslateZ(ancien_z+35);
                    break;
            }
        });
        ihm.addEventHandler(MouseEvent.ANY, event -> {
            if (event.getButton()== MouseButton.SECONDARY && event.getEventType()==MouseEvent.MOUSE_CLICKED) {
                PickResult pickResult = event.getPickResult();
                if (pickResult.getIntersectedNode() != null) {
// Code `a compl´eter : on r´ecup`ere le point d'intersection
// Conversion en longitude et lattitude

                    double latitude;
                    double longitude;
                    System.out.println("Coord");
                    Point2D Intersection = pickResult.getIntersectedTexCoord();
                    System.out.println(Intersection);


                    latitude = 2*Math.toDegrees(Math.tan(Math.pow(Math.E,(0.5-Intersection.ZERO.getX())/0.2678)))-90;

                    longitude = 360*Intersection.ZERO.getY()-0.5;

                    System.out.println("Lat");
                    System.out.println(latitude);
                    System.out.println("Long");
                    System.out.println(longitude);

// Recherche dans l'objet w de la classe World de l'a´eroport le plus proche.
// Affichage dans la console
                }}});


    }
    public static void main(String[] args) {
        launch(args);
    }
}
