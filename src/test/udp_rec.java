package test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udp_rec {
    static DatagramPacket dp,dp1,dp2;
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket(200);
        InetAddress ip = InetAddress.getByName("192.168.10.6");
        byte[] buf = new byte[1024];
        byte[] buf1 = new byte[1024];
        byte[] buf2 = new byte[1024];
        dp = new DatagramPacket(buf,1024);
        dp1 = new DatagramPacket(buf1,1024);
        dp2 = new DatagramPacket(buf2,1024);
        ds.receive(dp);
//        ds.receive(dp1);
//        ds.receive(dp2);
        String a = new String(dp.getData(),0,dp.getLength());
//        String b = new String(dp1.getData(),0,dp1.getLength());
//        String exp = new String(dp2.getData(),0,dp2.getLength());
        System.out.println(a);
//        switch (exp){
//            case "+" : int add = Integer.parseInt(a)+Integer.parseInt(b);
//                dp = new DatagramPacket(Integer.toString(add).getBytes(),
//                        Integer.toString(add).length(),200);
//                ds.send(dp);
//                break;
//            case "-" : int sub = Integer.parseInt(a)-Integer.parseInt(b);
//                dp = new DatagramPacket(Integer.toString(sub).getBytes(),
//                        Integer.toString(sub).length(),200);
//                ds.send(dp);
//                break;
//            case "*" : int mul = Integer.parseInt(a)*Integer.parseInt(b);
//                dp = new DatagramPacket(Integer.toString(mul).getBytes(),
//                        Integer.toString(mul).length(),200);
//                ds.send(dp);
//                break;
//            case "/" : int div = Integer.parseInt(a)/Integer.parseInt(b);
//                dp = new DatagramPacket(Integer.toString(div).getBytes(),
//                        Integer.toString(div).length(),200);
//                ds.send(dp);
//                break;
//            default:
//                System.out.println("invalid expression from client");
//        }


        ds.close();

    }
}
