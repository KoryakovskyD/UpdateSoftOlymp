import java.io.IOException;

public class BashCommand {
    public static void pushCommand(String command) {
        try {
            Process threadBash = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", command});
            threadBash.waitFor();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }
}
