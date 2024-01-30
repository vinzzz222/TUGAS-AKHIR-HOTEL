package entity;

import util.DateString;
public class Reservasi {
    public Tamu tamu;
    public Kamar kamar;
    public int malam;

    public String tanggalCheckIn;
    public String tanggalCheckOut="Belum CheckOut";


    public Reservasi(Tamu tamu, Kamar kamar, int malam) {
        this.tamu = tamu;
        this.kamar = kamar;
        this.malam = malam;
        this.tanggalCheckIn = DateString.now();
    }
    public void setTanggalCheckOut(String tanggalCheckOut)
    {
        this.tanggalCheckOut = tanggalCheckOut;
    }

}