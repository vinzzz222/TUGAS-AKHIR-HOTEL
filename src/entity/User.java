package entity;

public abstract class User {
   public String nama;
    public String kodeadmin;

    public User(String nama,String kodeadmin) {
        this.nama = nama;
        this.kodeadmin= kodeadmin;
    }
    public abstract String getNama();

    public abstract String getKodeadmin();

}