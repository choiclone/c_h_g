package DataModel;

import java.net.InetAddress;

public class UserData {//사용자 데이터를 저장함
    private String name;
    private InetAddress ip;
    private int port;
    
    //Ip
    public InetAddress getIp() {
        return ip;
    }
    public void setIp(InetAddress ip) {
        this.ip = ip;
    }
    
    //Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    //Port
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
}
