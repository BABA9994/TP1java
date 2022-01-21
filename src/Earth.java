package src;
import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

public class Earth extends Group {

    // Ici on créer un cube au lieu d'une sphere
    // Box sph = new Box();
    Sphere sph = new Sphere();
    Rotate rotate = new Rotate();
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
                System.out.println("Valeur de time : " + time);
                ry.setAngle(10); // A compl´eter
                ry.setPivotX(0);
                ry.setPivotY(0);
                sph.getTransforms().add(ry);
            }
        };

        animationTimer.start();

    }




        public static void main(String args[]) {

            System.out.println("Hello Terre");
        }
    }

