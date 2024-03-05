package cn.com.wysha;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JPanel contentPane;
    private JPanel dataView;
    private JLabel label;
    private JLabel average;

    public View(String scoreName, String[][] data, Integer averageScore) {
        setTitle(scoreName);
        label.setText("scoreName:" + scoreName);
        average.setText("averageScore:" + averageScore);
        setContentPane(contentPane);
        String[] strings = {"index", "studentName", "scoreValue"};
        JTable jTable = new JTable(data, strings);
        dataView.add(jTable.getTableHeader(), BorderLayout.NORTH);
        dataView.add(new JScrollPane(jTable), BorderLayout.CENTER);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(dim.width / 2, dim.height / 2);
        setLocationRelativeTo(null);
    }
}
