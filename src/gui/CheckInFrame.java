package gui;

import controller.Login;
import entity.Kamar;
import entity.Tamu;
import model.Hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckInFrame extends JFrame {

    CheckInFrame() {
        super("Menu Check In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(662, 486);

        JLabel label = new JLabel("Check IN");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setBounds(328, 22, 130, 36);

        JLabel nama = new JLabel("Nama");
        nama.setFont(new Font("Serif", Font.BOLD, 25));
        nama.setBounds(27, 75, 69, 30);

        JLabel kodeadmin = new JLabel("Kode.admin");
        kodeadmin.setFont(new Font("Serif", Font.BOLD, 25));
        kodeadmin.setBounds(27, 122, 150, 30);

        JLabel telp = new JLabel("No.Telp");
        telp.setFont(new Font("Serif", Font.BOLD, 25));
        telp.setBounds(27, 169, 91, 30);

        JLabel alamat = new JLabel("Alamat");
        alamat.setFont(new Font("Serif", Font.BOLD, 25));
        alamat.setBounds(27, 216, 82, 30);

        JLabel kodeKamar = new JLabel("Kode Kamar");
        kodeKamar.setFont(new Font("Serif", Font.BOLD, 25));
        kodeKamar.setBounds(27, 263, 143, 30);

        JLabel malam = new JLabel("Brp Malam");
        malam.setFont(new Font("Serif", Font.BOLD, 25));
        malam.setBounds(27, 310, 126, 30);

        JLabel pembayaran = new JLabel("Via Pembayaran");
        pembayaran.setFont(new Font("Serif", Font.BOLD, 25));
        pembayaran.setBounds(27, 357, 171, 30);

        JTextField namaTF = new JTextField();
        namaTF.setFont(new Font("Serif", Font.PLAIN, 22));
        namaTF.setBounds(178, 77, 430, 30);

        JTextField kodeadminTF = new JTextField(Login.staffLogged.kodeadmin);
        kodeadminTF.setFont(new Font("Serif", Font.PLAIN, 22));
        kodeadminTF.setBounds(178, 124, 430, 30);

        JTextField telpTF = new JTextField();
        telpTF.setFont(new Font("Serif", Font.PLAIN, 22));
        telpTF.setBounds(178, 171, 430, 30);

        JTextField alamatTF = new JTextField();
        alamatTF.setFont(new Font("Serif", Font.PLAIN, 22));
        alamatTF.setBounds(178, 218, 430, 30);

        JTextField kodeTF = new JTextField();
        kodeTF.setFont(new Font("Serif", Font.PLAIN, 22));
        kodeTF.setBounds(178, 265, 430, 30);

        JTextField malamTF = new JTextField();
        malamTF.setFont(new Font("Serif", Font.PLAIN, 22));
        malamTF.setBounds(178, 312, 430, 30);

        JTextField pembayaranTF = new JTextField();
        pembayaranTF.setFont(new Font("Serif", Font.PLAIN, 22));
        pembayaranTF.setBounds(178, 359, 430, 30);

        JButton back = new JButton("BACK");
        back.setFont(new Font("Serif", Font.BOLD, 20));
        back.setBounds(27, 407, 95, 41);

        JButton confirm = new JButton("CONFIRM");
        confirm.setFont(new Font("Serif", Font.BOLD, 20));
        confirm.setBounds(470, 407, 138, 41);

        add(label);
        add(nama);
        add(kodeadmin);
        add(telp);
        add(alamat);
        add(kodeKamar);
        add(malam);
        add(pembayaran);
        add(namaTF);
        add(kodeadminTF);
        add(telpTF);
        add(alamatTF);
        add(kodeTF);
        add(malamTF);
        add(pembayaranTF);
        add(back);
        add(confirm);

        setVisible(true);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuFrame();
            }
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = namaTF.getText();
                String kodeadmin = kodeadminTF.getText();
                String telp = telpTF.getText();
                String alamat = alamatTF.getText();
                String kode = kodeTF.getText();
                String pembayaran = pembayaranTF.getText();
                int malam = Integer.parseInt(malamTF.getText());
                Kamar cariKamar = Hotel.cariKamar(kode);
                if (cariKamar != null) {
                    if (!cariKamar.isStatus()) {
                        JOptionPane.showMessageDialog(null, "Kamar <" + kode + "> Sudah Di Booking", "Warning", JOptionPane.WARNING_MESSAGE);
                        dispose();
                        new CheckInFrame();
                    } else {
                        cariKamar.setStatus(false);
                        Tamu tamu = new Tamu(kodeadmin, nama, telp, alamat , pembayaran);
                        Hotel.checkIn(tamu, cariKamar, malam);
                        JOptionPane.showMessageDialog(null, "Kamar <" + kode + "> Berhasil Di Pesan", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new CheckInFrame();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Kamar <" + kode + "> Tidak Ditemukan", "Warning", JOptionPane.WARNING_MESSAGE);
                    dispose();
                    new CheckInFrame();
                }
            }
        });
    }
}
