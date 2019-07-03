package widok;

import model.Student;
import repozytorium.StudentRepozytorium;

import javax.swing.*;
import java.awt.*;

public class WidokOgólny {

    private JFrame frame = new JFrame("E-Dziekanat");
    private GridLayout gridLayout = new GridLayout(2, 2, 12, 12);
    private JButton button = new JButton("Student");
    private JButton button1 = new JButton("Tematy prac magisterskich");
    private JButton button2 = new JButton("Tematy prac inżynierskich");

    public void wybórRoli() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(gridLayout);
        frame.add(button);
        frame.add(button1);
        frame.add(button2);
        frame.setVisible(true);
        button.addActionListener(e -> {
            System.out.println("dupa");
            for(Student st : StudentRepozytorium.znajdźStudentaOPodanymNumerzeAlbumu(12425)){
                System.out.println(st.getImię() + " " + st.getNazwisko());
            }

        });
    }

}
