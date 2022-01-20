package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Math.cos;

public class World {
    //On créer la variable Liste
    ArrayList<Aeroport> Aeroportliste;

    // Ici on peut avoir 2 méthode distance, on utilisera l'une ou l'autre en fonction des arguments
    public static double distance(double latitude1, double latitude2, double longitude1, double longitude2){
        return Math.pow(latitude2-latitude1,2)+Math.pow((longitude2-longitude1)*cos((latitude1+latitude2)/2),2);
    }


    public double distance (double lat, double longi, Aeroport A){
        return distance(lat, A.getLatitude(), longi, A.getLongitude());
    }

    public ArrayList getList (){
        return Aeroportliste;
    }

    public Aeroport findNearest(double latitude, double longitude) {
        double dist_min = distance(latitude, longitude,Aeroportliste.get(0));

        Aeroport Aeroport_nearest = Aeroportliste.get(0);
        for (Aeroport A : Aeroportliste) {
            double dist = distance(latitude,longitude,A);
            if(dist < dist_min) {

                dist_min = dist;
                Aeroport_nearest = A;
            }
        }
        return Aeroport_nearest;
    }

    public Aeroport findByCode (String code){
        for (Aeroport A : Aeroportliste) {
            if (A.getIATA().equals(code)){
                return A;
            }
        }
        System.out.println("Je n'ai rien trouvé");
       return null;
    }



    public World (String fileName){
        //On allocate la memoire de la list AeroportList
        Aeroportliste = new ArrayList<Aeroport>();

        try{
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();
            while(s!=null){
                s=s.replaceAll("\"","");
//Enleve les guillemets qui separent les champs de donn´ees GPS.

                String fields[]=s.split(",");
// Une bonne id´ee : placer un point d'arret ici pour du debuggage.

                if (fields[1].equals("large_airport")){
// A continuer
                    Aeroportliste.add(new Aeroport(fields[9], fields[2], fields[5], parseDouble(fields[11]), parseDouble(fields[12])));
                }
                s = buf.readLine();
            }
        }
        catch (Exception e){
            System.out.println("Maybe the file isn't there ?");
            System.out.println(Aeroportliste.get(Aeroportliste.size()-1));
            e.printStackTrace();
        }
    }


    public static void main (String args[]) {

        World w = new World("./data/airport-codes_no_comma.csv");
        System.out.println("HelloWorld");

        System.out.println("Found "+w.getList().size()+" airports.");
        Aeroport paris = w.findNearest(48.866,2.316);
        Aeroport cdg = w.findByCode("CDG");
        double distance = w.distance(48.866,2.316,paris.getLongitude(),paris.getLatitude());
        System.out.println(paris);
        System.out.println(distance);
        double distanceCDG = w.distance(2.316,48.866,cdg.getLongitude(),cdg.getLatitude());
        System.out.println(cdg);
        System.out.println(distanceCDG);


        //double distance = w.distance(1);
        System.out.println("Distance : " + distance(1,3,2,4));
    }}