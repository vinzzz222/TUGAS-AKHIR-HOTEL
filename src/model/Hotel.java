package model;

import entity.Kamar;
import entity.Reservasi;
import entity.Staff;
import entity.Tamu;
import util.DateString;

import java.util.ArrayList;
public class Hotel {
    public static ArrayList<Kamar> daftarKamar = new ArrayList<>();
    public static ArrayList<Staff> daftarStaff = new ArrayList<>();

    public static ArrayList<Reservasi> daftarReservasi = new ArrayList<>();

    public static void initialData(){
        initalStaff();
        initialKamar();
    }

    public static void initialKamar() {
        daftarKamar.add(new Kamar("1", "Single Bed", 500000, true));
        daftarKamar.add(new Kamar("2", "Single Bed", 500000, true));
        daftarKamar.add(new Kamar("3", "Double Bed", 700000, true));
        daftarKamar.add(new Kamar("4", "Double Bed", 700000, true));
        daftarKamar.add(new Kamar("5", "Double Bed", 700000, true));
    }

    public static void initalStaff() {
        daftarStaff.add(new Staff("kevin", "07503", "111"));
    }

    public static Kamar cariKamar(String kode) {
        for (Kamar kamar : daftarKamar) {
            if (kamar.kodeKamar.equals(kode)) {
                return kamar;
            }
        }
        return null;
    }

    private static void updateStatusKamar(Kamar kamar, boolean status) {
        for (Kamar kamar2 : daftarKamar) {
            if (kamar.kodeKamar.equals(kamar2.kodeKamar)) {
                kamar2.setStatus(status);
                break;
            }
        }
    }

    public static void checkIn(Tamu tamu, Kamar kamar, int malam) {
        Reservasi checkIn = new Reservasi(tamu, kamar, malam);

        updateStatusKamar(kamar, false);

        daftarReservasi.add(checkIn);
    }

    public static int cariReservasibyKodeKamar(String kodeKamar) {
        int i = -1;
        for (Reservasi reservasi : daftarReservasi) {
            i += 1;
            if (reservasi.kamar.kodeKamar.equals(kodeKamar)&&reservasi.tanggalCheckOut.equals("Belum CheckOut")) {
                if (!reservasi.kamar.status) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void checkOut(int indexReservasi) {
        Reservasi reservasi = daftarReservasi.get(indexReservasi);
        reservasi.setTanggalCheckOut(DateString.now());
        Kamar kamar = reservasi.kamar;
        updateStatusKamar(kamar, true);

        daftarReservasi.set(indexReservasi, reservasi);
    }

    public static ArrayList <Kamar>  melihatkamartersedia(){
    ArrayList <Kamar> temp = new ArrayList<Kamar>();
        for (Kamar kamar : daftarKamar){
            if (kamar.isStatus()){
                temp.add(kamar);
            }
        }
        return temp;
    }
}