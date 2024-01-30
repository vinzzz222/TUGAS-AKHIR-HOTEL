package entity;

public class Tamu extends User {
    public String alamat;
    public String noTelp;
    public String pembayaran;



    public Tamu(String kodeadmin, String nama, String alamat, String noTelp , String pembayaran) {
        super(nama,kodeadmin);
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.pembayaran= pembayaran;
    }

    @Override
    public String getNama()
    {
        return nama;
    }

    public String getAlamat()
    {
        return alamat;
    }

    public String getNoTelp()
    {
        return noTelp;
    }
    public String getPembayaran()
    {
        return pembayaran;
    }

    @Override
    public String getKodeadmin()
    {
        return kodeadmin;
    }

}