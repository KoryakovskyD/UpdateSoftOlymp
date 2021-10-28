public enum DeviceIp {
    SERVER("Server", "10.4.6.55", "10.3.6.55"),
    DEVICE1("4.09(1) Верх","10.4.6.70", "10.3.6.70"),
    DEVICE2("4.09(1) Низ","10.4.6.71", "10.3.6.71"),
    DEVICE3("4.09(2) Верх","10.4.6.72", "10.3.6.72"),
    DEVICE4("4.09(2) Низ","10.4.6.73", "10.3.6.73"),
    DEVICE5("4.09(3) Верх","10.4.6.74", "10.3.6.74"),
    DEVICE6("4.09(3) Низ","10.4.6.75", "10.3.6.75"),
    DEVICE7("4.09(4) Верх","10.4.6.76", "10.3.6.76"),
    DEVICE8("4.09(4) Низ","10.4.6.77", "10.3.6.77"),
    DEVICE9("6.06","10.3.6.99"),
    RIO1("16E01-00", "10.4.6.1"),
    RIO2("16E01-01", "10.4.6.3"),
    RIO3("16E01-02", "10.4.6.5"),
    RIO4("16E01-03", "10.4.6.7"),
    RIO5("16E01-04", "10.4.6.9"),
    RIO6("16E01-05", "10.4.6.11"),
    RIO7("13KL01-00", "10.4.6.13"),
    RIO8("13KL01-01", "10.4.6.14"),
    RIO9("16E03-00", "10.4.6.15"),
    RIO10("16E03-01", "10.4.6.17"),
    RIO11("16E04-00", "10.4.6.19"),
    RIO12("16E04-01", "10.4.6.21"),
    RIO13("16E05-00", "10.4.6.23"),
    RIO14("16D06-00", "10.4.6.25"),
    RIO15("16E07-00", "10.4.6.37"),
    RIO16("16E08-00", "10.4.6.33"),
    RIO17("16E08-01", "10.4.6.35");


    private final String comment;
    private final String ip;
    private final String secondIp;

    DeviceIp(String comment, String ip) {
        this.comment = comment;
        this.ip = ip;
        secondIp="";
    }

    DeviceIp(String comment, String ip, String secondIp) {
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
