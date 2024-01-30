package entity;

public class Staff extends User {

    public String password;

    public Staff(String nama, String kodeadmin, String password) {
        super(nama,kodeadmin);
        this.password = password;
    }

    @Override
    public String getNama()
    {
        return nama;
    }

    @Override
    public String getKodeadmin()
    {
        return null;
    }

}