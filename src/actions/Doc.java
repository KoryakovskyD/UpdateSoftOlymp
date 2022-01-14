package actions;

public class Doc {

    static Doc doc;

    public static Doc getDoc() {
        if (doc==null) doc = new Doc();
        return doc;
    }

    public void openDoc() {
        AppProperties ap = new AppProperties();
        BashCommand.pushCommand(ap.getProp().getProperty("textEditor") +
                " " + ap.getProp().getProperty("docPath") + "/" +
                ap.getProp().getProperty("docName"));
    }
}
