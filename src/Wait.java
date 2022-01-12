import javax.swing.*;

public class Wait extends javax.swing.JFrame {

    public Wait() {
        super("Please, wait...");
        this.setBounds(650,650,160,30);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        JPanel contents = new JPanel();

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setIndeterminate(true);
        progressBar.setStringPainted(true);
        progressBar.setString("Please, wait...");

        contents.add(progressBar);
        setContentPane(contents);
    }
}
