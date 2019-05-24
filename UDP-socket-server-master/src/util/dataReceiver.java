package util;

import DataModel.UserData;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class dataReceiver {
    public static boolean ServerOn = true;
    private dataSender dSend;
    private dataDivisor dDivisor;
    ArrayList<UserData> uData;

    public void ReceivingData(DatagramSocket dsoc, DatagramPacket dp){
        uData = new ArrayList<>();
        dSend = new dataSender(dsoc);
        dDivisor = new dataDivisor();
        do {
            System.out.println("...On Receiving...");
            try {
//                System.out.println("..."+InetAddress.getLocalHost().toString()+"...");
                dp.setData(new byte[6636]);
                dsoc.receive(dp);
                System.out.println("...Data recevied...");
                if (ChkUser(dp)){
                    SenderThread st = new SenderThread(
                            dSend,
                            uData,
                            dDivisor.DataGetName(new String(dp.getData(), "UTF-8")),
                            dDivisor.DataGetMsg(new String(dp.getData(), "UTF-8"))
                    );
                    st.start();
                }
            }catch (IOException e) {
                e.printStackTrace();
                ServerOn = false;
            }
//            System.out.println("[][][][]"+ServerOn);
        }while (ServerOn);
    }

    private boolean ChkUser(DatagramPacket dp) throws UnsupportedEncodingException {
        InetAddress ip = dp.getAddress();
        int port = dp.getPort();
        String Data = new String(dp.getData(), "UTF-8");
        boolean isFirst = (dDivisor.DataGetCnt(Data) == 0);
        boolean isUserExist = false;
        boolean isSame = true;
        String Name = dDivisor.DataGetName(Data);

        while(isSame)
        if (isFirst) {
            for (int i = 0; i < uData.size(); i++) {
                if (uData.get(i).getName().equalsIgnoreCase(Name)) {
//                    Exist same name
                    System.out.println("...Same User Found...");
                    isUserExist = true;
                    break;
                }
            }
            if (!isUserExist) {
                System.out.println("...Make New User...");
                UserData user = new UserData();
                user.setName(Name);
                user.setIp(ip);
                user.setPort(port);
                uData.add(user);
//                System.out.println("...Success To Make User...");
//                System.out.println("...Name : "+Name+"...");
//                System.out.println("...Ip : "+ip+"...");
//                System.out.println("...Port : "+port+"...");
                isSame = false;
                SenderThread st = new SenderThread(dSend, uData, Name, "is connected.");
                st.start();
                return false;
            }else{
                try {
                    System.out.println("...Make User To Choose Other Name...");
                    dSend.backToUser(ip, port);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }else {
            if (dDivisor.DataGetMsg(Data).equalsIgnoreCase("exit")) {
                System.out.println("...An User Exit...");
                for (int i = 0; i < uData.size(); i++) {
                    if (uData.get(i).getName().equalsIgnoreCase(Name)) {
                        uData.remove(i);
                        SenderThread st = new SenderThread(dSend, uData, Name, " is disconnected.");
                        st.start();
                        return false;
                    }
                }
            }
            isSame = false;
        }
        return true;
    }
    /**
     *  Client�뿉�꽌 蹂대궪諛⑹떇
     *  Cnt:UserName:Msg
     */

    /**
     *  Server�뿉�꽌 蹂대궪諛⑹떇
     *  UserName:Msg
     */
}

class SenderThread extends Thread{
    private dataSender dSender;
    private ArrayList<UserData> userData;
    private String Msg, Name;
    SenderThread(dataSender dSender, ArrayList<UserData> userData, String Name, String Msg){
        this.dSender = dSender;
        this.userData = userData;
        this.Name = Name;
        this.Msg = Msg;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("...Thread is Running...");
        System.out.println("[..."+Name+" , "+Msg+"...]");
        for (int i = 0; i < userData.size(); i++){
            try {
                System.out.println("userData : "+userData.get(i)+", Name: "+Name+" Msg: "+Msg+" ip: "+userData.get(i).getIp()+" port: "+userData.get(i).getPort());
                dSender.dataSend(userData.get(i), Name, Msg);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
