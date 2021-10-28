import java.io.IOException;


public class OpenConsole {

    public static void open(){


        // Список ip-адресов выбранных прибор
        String ip_list = ChangePrib.getIp_list();



        // Пробежка по каждой машине
        for (String ip:ip_list.split(" ")) {

           String commandConsole = "mate-terminal --tab -e \"sshpass -p wizard ssh -X root@" + ip + "\"";
           try {
              Process threadBash = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", commandConsole});
              threadBash.waitFor();
           } catch (IOException e1) {
              e1.printStackTrace();
           } catch (InterruptedException e2) {
              e2.printStackTrace();
           }
        }

    System.exit(0);
    }

}



