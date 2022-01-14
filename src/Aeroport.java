package src;
public class Aeroport {

    private String IATA;
    private String Name;
    private String country;
    private double latitude;
    private double longitude;

    public Aeroport(String IATA, String Name, String country, double latitude, double longitude) {
        this.IATA = IATA;
        this.Name = Name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }




    public String GetIATA() {
        return IATA;
    }

    public double getLatitude() {
        return latitude;
    }

    public double GetLongitude() {
        return longitude;
    }


    @Override
    public String toString() {
        return "Aeroport" +
                "IATA='" + IATA + '\'' +
                ", Name='" + Name + '\'' +
                ", country='" + country + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }

    public static void main (String args[]){
        System.out.println("Hello world");
        System.out.println("Hello world2");

        Aeroport Aeroport1 = new Aeroport("CDG","Charles de Gaule","FRANCE", 5, 5);
        System.out.println(Aeroport1);

        }




}
