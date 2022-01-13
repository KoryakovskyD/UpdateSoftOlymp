package lists;

public enum IpListIntel {
    SERVER("Server", "10.4.6.55", "10.3.6.55"),
    DEVICE1("4.09(1) Верх","10.4.6.70", "10.3.6.70"),
    DEVICE2("4.09(1) Низ","10.4.6.71", "10.3.6.71"),
    DEVICE3("4.09(2) Верх","10.4.6.72", "10.3.6.72"),
    DEVICE4("4.09(2) Низ","10.4.6.73", "10.3.6.73"),
    DEVICE5("4.09(3) Верх","10.4.6.74", "10.3.6.74"),
    DEVICE6("4.09(3) Низ","10.4.6.75", "10.3.6.75"),
    DEVICE7("4.09(4) Верх","10.4.6.76", "10.3.6.76"),
    DEVICE8("4.09(4) Низ","10.4.6.77", "10.3.6.77"),
    DEVICE9("6.06","10.3.6.99", "10.3.6.99");


    private final String comment;
    private final String ip;
    private final String secondIp;


    IpListIntel(String comment, String ip, String secondIp) {
        this.comment = comment;
        this.ip = ip;
        this.secondIp=secondIp;
    }

    public String getComment() {
        return comment;
    }

    public String getIp() {
        return ip;
    }

    public String getSecondIp() {
        return secondIp;
    }
}
