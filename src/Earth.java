package src;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.util.Objects;


public class Earth extends Group {





    // Ici on créer un cube au lieu d'une sphere
    // Box sph = new Box();
    Sphere sph = new Sphere();
    PhongMaterial mat = new PhongMaterial();



    public Earth () {
        sph.setRadius(300);
        // sph.setWidth(300);
        // sph.setHeight(300);
        // sph.setDepth(300);






        Image map = new Image("earth_lights_4800.png");
        mat.setDiffuseMap(map);
        sph.setMaterial(mat);


        this.getChildren().add(sph);

        Rotate ry = new Rotate();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long time) {
                //System.out.println("Valeur de time : " + time);

                ry.setAxis(new Point3D(0,1,0));
                // ry.setAxis(Rotate.Y_AXIS);
                //Il faut 0.384 degres de rotation toutes les 16ms afin d'avoir une rotation complete en 15 secondes
                //POUR UN ECRAN 60HZ,
                //Ayant un écran 165hz, il faut saisir la valeur à 0.145

                ry.setAngle(0.145); // A compl´eter
                // sph.rotateProperty().set(sph.getRotate() + 0.01);

                sph.getTransforms().add(ry);
            }
        };

        animationTimer.start();

    }




        public static void main(String args[]) {

            System.out.println("Hello Terre");
        }
    }

