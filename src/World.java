package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Math.cos;

public class World {
    //On créer la variable Liste
    ArrayList<Aeroport> Aeroportliste;


    public double distance (double latitude1, double latitude2, double longitude1, double longitude2){
        double distance = (latitude1 - latitude2) + ((longitude1-longitude2)*cos((latitude2+latitude1)/2));
        return distance;
    }

    public double distance (double lat, double longi, Aeroport A){
        return distance(lat, A.getLatitude(), longi, A.getLongitude());
    }

    public Aeroport FindNearest() {
        for (Aeroport A : Aeroportliste) {
            distance()
        }

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
                    Aeroport NouveauAeroport = new Aeroport(fields[9], fields[2], fields[5], parseDouble(fields[11]), parseDouble(fields[12]));
                    Aeroportliste.add(NouveauAeroport);
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


    public static void main (String args[]){

        World w = new World("./data/airport-codes_no_comma.csv");
        System.out.println("HelloWorld");
        System.out.println(w);


    }
}
