package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyWindow extends JFrame{
    public MyWindow()
    {
        //Задание:
        //Создать окно для клиентской части чата (большое текстовое поле для отображения переписки,
        // однострочное текстовое поле для ввода сообщений, кнопка для отсылки сообщений).
        //Сообщение должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter.
        //"Отправленное" сообщение должно появиться в большом текстовом поле.
        //Решнение(выполнено самостоятельно):

        setBounds(300,300,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setVisible(true);

        JTextField jt=new JTextField();
        add(jt,BorderLayout.SOUTH);
        jt.grabFocus();
        JButton jb=new JButton("OK");
        jb.setAlignmentX(JComponent.RIGHT_ALIGNMENT);

        JPanel bottom=new JPanel();
        bottom.setLayout(new GridLayout());
        bottom.add(jt);
        bottom.add(jb);
        add(bottom, BorderLayout.SOUTH);

        JTextArea jtBig=new JTextArea();
        jtBig.setEditable(false);
        JScrollPane js=new JScrollPane(jtBig);
        add(js,BorderLayout.CENTER);

        jb.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               jtBig.append(jt.getText());
               jtBig.setLineWrap(true);
               jtBig.append("\n");
               jt.setText(null);
           }
       });

        jt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtBig.append(jt.getText());
                jtBig.setLineWrap(true);
                jtBig.append("\n");
                jt.setText(null);
            }
        });
    }
}
