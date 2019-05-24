package util;

import DataModel.UserData;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class dataReceiver {
    public static boolean ServerOn = true;//무한 반복쓸려고요
    private dataSender dSend;
    private dataDivisor dDivisor;
    ArrayList<UserData> uData;

                                   //8888              
    public void ReceivingData(DatagramSocket dsoc, DatagramPacket dp){
        uData = new ArrayList<>();
        dSend = new dataSender(dsoc);//dataSender 클래스에 8888포트를 매개변수에 보냄
        dDivisor = new dataDivisor();
        do {
            System.out.println("...On Receiving...");
            try {
 //               System.out.println("..."+InetAddress.getLocalHost().toString()+"..."); 자신의 컴퓨터 이름과 ip를 알아낼 수 있다.
                dp.setData(new byte[6636]);//버퍼에 있는 실제 데이터를 바이트 배열로 설정한다.
                //0:1:님이 입장하였습니다.
                dsoc.receive(dp);//8888포트에 새로운 바이트 형에 데이터를 저장
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
        InetAddress ip = dp.getAddress();//localhost값 127.0.0.1을 가져옴
        int port = dp.getPort();//클라이언트의 임시 포트 값이 듦
                              //0:1:님이 입장하였습니다.
        String Data = new String(dp.getData(), "UTF-8");//String 형으로 형변환 하고, UTF-8롤 한다.
        boolean isFirst = (dDivisor.DataGetCnt(Data) == 0/*true*/);// true/false
        boolean isUserExist = false;//같은 사용자 존재여부
        boolean isSame = true;
        String Name = dDivisor.DataGetName(Data);//1
        while(isSame)
        if (isFirst) {
            for (int i = 0; i < uData.size(); i++) {
                if (uData.get(i).getName().equalsIgnoreCase(Name/*1*/)) {//같은 이름이 있는지 체크
//                    Exist same name
                    System.out.println("...Same User Found...");
                    isUserExist = true;
                    break;
                }
            }
            if (!isUserExist) {//true
                System.out.println("...Make New User...");
                System.out.println(uData.size());
                UserData user = new UserData();
                user.setName(Name);
                user.setIp(ip);//서버주소(localhost)
                user.setPort(port);//클라이언트 임시포트
                uData.add(user);//arraylist에 사용자 정보 추가
//                System.out.println("...Success To Make User...");
//                System.out.println("...Name : "+Name+"...");
//                System.out.println("...Ip : "+ip+"...");
//                System.out.println("...Port : "+port+"...");
                isSame = false;//첫번째 사용자 생성 종료
                SenderThread st = new SenderThread(dSend/*8888*/, uData/*추가한 사용자들*/, Name, "is connected");
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
                        SenderThread st = new SenderThread(dSend/*8888*/, uData/*ArrayList*/, Name/*1*/, "is disconnected");
                        st.start();//run메서드 호출이라고 봐도 무관
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
    public void run() {//thread를 쓸 때는 start를 먼저 해주면 자신이 run메서드만 만들어주면 실행됨
        //super.run();
        System.out.println("...Thread is Running...");
        System.out.println("[..."+Name+" , "+Msg+"...]");
        System.out.println(userData.size());
        for (int i = 0; i < userData.size(); i++){//만약 exit를 눌렀다면 uData의
        	//자료들이 사용자가 삭제됬기 때문에 사라짐
        	//2사용자가 같은 포트 사용하면 값을 보낼 수 없음 
            try {
                System.out.println("userData : "+userData.get(i)/*Arrayㅣist에서 사용함, 값을 더 빨리 찾을 수 있음*/+", Name: "+Name+" Msg: "+Msg+" ip: "+userData.get(i).getIp()+" port: "+userData.get(i).getPort());
                dSender.dataSend(userData.get(i), Name, Msg);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
