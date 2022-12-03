package lab8_progra1_josebendana;

public class Superheroe {
    public String heroe;
    public String real;
    public String city;
    public String fran;

    public Superheroe(String heroe, String real, String city, String fran) {
        this.heroe = heroe;
        this.real = real;
        this.city = city;
        this.fran = fran;
    }

    public String getHeroe() {
        return heroe;
    }

    public void setHeroe(String heroe) {
        this.heroe = heroe;
    }

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFran() {
        return fran;
    }

    public void setFran(String fran) {
        this.fran = fran;
    }

    @Override
    public String toString() {
        return "" + "Nombre de super héroe: " + heroe + "\nNombre real : " + real + "\nCiudad de origen : " + city + "\nFranquicia: " + fran;
    }
    
    
}
