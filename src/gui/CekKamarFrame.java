package gui;


import entity.Kamar;
import entity.Reservasi;
import model.Hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CekKamarFrame extends JFrame {


    CekKamarFrame(){
        super("Kamar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setSize(1104,488);

        JLabel label = new JLabel("Kamar Ready");
        label.setFont(new Font("Serif",Font.BOLD,40));
        label.setBounds(414,45,262,48);

        JTable dataKamar = new JTable();
        TableModel model = createTableModel();
        dataKamar.setModel(model);

        JScrollPane scroll = new JScrollPane(dataKamar);
        scroll.setBounds(32,114,1026,297);

        JButton back = new JButton("BACK");
        back.setBounds(28,24,98,43);

        add(scroll);
        add(label);
        add(back);
        setVisible(true);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuFrame();
            }
        });
    }

    private TableModel createTableModel(){

        Hotel hotelModel = new Hotel();
        ArrayList<Kamar> temp = hotelModel.melihatkamartersedia();

        DefaultTableModel dataKamar = new DefaultTableModel();
        Object[] kolom = {"No","KodeKamar"};
        dataKamar.setColumnIdentifiers(kolom);
        int i =0;
        for (Kamar reservasi : temp) {
            Object[] data = new String[] {
                    String.valueOf(i+1),
                    reservasi.getKodeKamar(),
            };
            i++;
            dataKamar.addRow(data);
        }
        return dataKamar;
    }
}