package gui;

import entity.Reservasi;
import model.Hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservasiFrame extends JFrame {

    ReservasiFrame() {
        super("Reservasi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(1104, 550);

        JLabel label = new JLabel("List Reservasi");
        label.setFont(new Font("Serif", Font.BOLD, 40));
        label.setBounds(414, 45, 262, 48);

        JTable dataKamar = new JTable();
        TableModel model = createTableModel();
        dataKamar.setModel(model);

        JScrollPane scroll = new JScrollPane(dataKamar);
        scroll.setBounds(32, 114, 1026, 297);

        JButton back = new JButton("BACK");
        back.setBounds(28, 24, 98, 43);

        JButton cancelReservation = new JButton("Cancel Reservation");
        cancelReservation.setBounds(28, 417, 200, 43);

        add(scroll);
        add(label);
        add(back);
        add(cancelReservation);
        setVisible(true);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuFrame();
            }
        });

        cancelReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = dataKamar.getSelectedRow();
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(null,
                            "apakah anda yakin membatalkan reservasi?",
                            "konfirmasi",
                            JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {

                        Hotel.daftarReservasi.remove(selectedRow);


                        dataKamar.setModel(createTableModel());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "pilih reservasi yang akan dibatalkan",
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private TableModel createTableModel() {
        DefaultTableModel dataKamar = new DefaultTableModel();
        Object[] kolom = {"NO", "KodeKamar", "JenisKamar", "kodeadmin", "Nama", "No.Telp", "Alamat", "Pembayaran","CheckIn", "Malam", "CheckOut",};
        dataKamar.setColumnIdentifiers(kolom);
        int i = 0;
        for (Reservasi reservasi : Hotel.daftarReservasi) {
            Object[] data = new String[]{
                    String.valueOf(i + 1),
                    reservasi.kamar.getKodeKamar(),
                    reservasi.kamar.getJenisKamar(),
                    reservasi.tamu.getKodeadmin(),
                    reservasi.tamu.getNama(),
                    reservasi.tamu.getNoTelp(),
                    reservasi.tamu.getAlamat(),
                    reservasi.tamu.getPembayaran(),
                    reservasi.tanggalCheckIn,
                    String.valueOf(reservasi.malam),
                    reservasi.tanggalCheckOut,
            };
            i++;
            dataKamar.addRow(data);
        }
        return dataKamar;
    }
}
