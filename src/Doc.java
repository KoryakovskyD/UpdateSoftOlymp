public class Doc {
    public static void openDoc() {
        String pathDoc="/home/PROJECTS/OLYMP-G/FLASH/INTEL/COMMON/SPO/DOC/";
        BashCommand.pushCommand("pluma " + pathDoc + "readme");
    }
}
