import java.io.IOException;

public class Doc {

    public static void openDoc() {
        String pathDoc="/home/PROJECTS/OLYMP-G/FLASH/INTEL/COMMON/SPO/DOC/";
        String command3 = "pluma " + pathDoc + "readme";
        try {
            Process threadBash = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", command3});
            threadBash.waitFor();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }
}
