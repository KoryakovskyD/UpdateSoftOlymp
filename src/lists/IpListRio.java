package lists;

public enum IpListRio {
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

    IpListRio(String comment, String ip) {
        this.comment = comment;
        this.ip = ip;
    }

    public String getComment() {
        return comment;
    }

    public String getIp() {
        return ip;
    }

}

