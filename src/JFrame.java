import javax.swing.*;
import java.awt.*;
import java.io.File;

public class JFrame extends javax.swing.JFrame {
    public static Wait wait;
    private JProgressBar progressBar;

    public JFrame() {
        super("Обновление СПО и ФПО заказа Олимп-Г.");
        setBounds(500,500,770,280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel container = new JPanel(new GridLayout(3,3));

        JButton button1 = new JButton("Прибор 4.09");
        button1.setFont(new Font("Calibri", Font.PLAIN, 20));
        JButton button2 = new JButton("Прибор 6.06");
        button2.setFont(new Font("Calibri", Font.PLAIN, 20));
        JButton button3 = new JButton("Пинг приборов");
        button3.setFont(new Font("Calibri", Font.PLAIN, 20));
        JButton button4 = new JButton("Открыть консоль(и)");
        button4.setFont(new Font("Calibri", Font.PLAIN, 20));
        button4.setToolTipText("Программа откроет консоль и зайдет на выбранный прибор(для запуска требуется mate-terminal)");
        JButton button5 = new JButton("Пересборка ФПО");
        button5.setFont(new Font("Calibri", Font.PLAIN, 20));
        JButton button6 = new JButton("Документация");
        button6.setFont(new Font("Calibri", Font.PLAIN, 20));
        button6.setToolTipText("Небольшая документация к программе(для запуска требуется графический редактор pluma)");
        JButton button7 = new JButton("Номер борта");
        button7.setFont(new Font("Calibri", Font.PLAIN, 20));
        button7.setToolTipText("Замена номера борта в файле реконфигурации прибора 4.09");
        JButton button8 = new JButton("Выполнить команду");
        button8.setFont(new Font("Calibri", Font.PLAIN, 20));
        JButton button9 = new JButton("SP или SHTAT");
        button9.setFont(new Font("Calibri", Font.PLAIN, 20));
        button9.setToolTipText("Перевод приборов на штатную работу или SP");

        progressBar = new JProgressBar(0, 100);
        progressBar.setIndeterminate(true);
        progressBar.setStringPainted(true);
        progressBar.setString("Please, wait...");

        container.add(button1);
        container.add(button2);
        container.add(button3);
        container.add(button4);
        container.add(button5);
        container.add(button6);
        container.add(button7);
        container.add(button8);
        container.add(button9);
        add(container,BorderLayout.CENTER);

        add(progressBar, BorderLayout.SOUTH);
        progressBar.setVisible(false);


        setVisible(true);
        wait = new Wait();

        button1.addActionListener(e -> {
            setVisible(false);
            check("/bin/sshpass");
            ChangePrib changePrib = new ChangePrib(2);
            changePrib.setVisible(true);
        });

        button2.addActionListener(e -> {
            setVisible(false);
            check("/bin/sshpass");
            Prib06 prib06 = new Prib06();
            prib06.setVisible(true);
        });

        button3.addActionListener(e -> {
            new Thread(() -> {
               progressBar.setVisible(true);
               PingHosts pingHosts = new PingHosts("Intel(10.4.6.*)");
               pingHosts.setVisible(true);
               progressBar.setVisible(false);
            }).start();
        });

        button4.addActionListener(e -> {
            setVisible(false);
            check("/bin/sshpass");
            check("/bin/mate-terminal");
            ChangePrib changePrib = new ChangePrib(1);
            changePrib.setVisible(true);
        });

        button5.addActionListener(e -> {
            setVisible(false);
            check("/bin/sshpass");
            Build build = new Build();
            build.setVisible(true);
        });

        button6.addActionListener(e -> {
            setVisible(false);
            check("/bin/pluma");
            Doc.getDoc().openDoc();
            System.exit(0);
        });

        button7.addActionListener(e -> {
            setVisible(false);
            check("/bin/sshpass");
            BortName bortName = new BortName();
            bortName.setVisible(true);
        });

        button8.addActionListener(e -> {
            setVisible(false);
            check("/bin/sshpass");
            ChangePrib changePrib = new ChangePrib(4);
            changePrib.setVisible(true);
        });

        button9.addActionListener(e -> {
            setVisible(false);
            check("/bin/sshpass");
            ChangePrib changePrib = new ChangePrib(3);
            changePrib.setVisible(true);
        });
    }

    public static void check(String str){
        if (new File(str).isFile() == false) {
            JOptionPane.showMessageDialog(null, "В системе отсутствует программа " + str + " !");
            System.exit(0);
        }
    }



}