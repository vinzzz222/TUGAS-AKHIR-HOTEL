package entity;

public class Kamar {
    public String kodeKamar;
    public String jenisKamar;

    public boolean isStatus() {
        return status;
    }

    public int hargaPerMalam;
    public boolean status;


    public Kamar(String kodeKamar, String jenisKamar, int hargaPerMalam, boolean status) {
        this.kodeKamar = kodeKamar;
        this.jenisKamar = jenisKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.status = status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public String getKodeKamar()
    {
        return kodeKamar;
    }

    public String getJenisKamar()
    {
        return jenisKamar;
    }


}