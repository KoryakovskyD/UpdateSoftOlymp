public class OpenConsole {
    public void open(){
        // Список ip-адресов выбранных прибор
        String ip_list = ChangePrib.getIp_list();

        // Пробежка по каждой машине
        for (String ip:ip_list.split(" ")) {
            BashCommand.pushCommand("mate-terminal --tab -e \"sshpass -p wizard ssh -X root@" + ip + "\"");
        }
    System.exit(0);
    }
}



