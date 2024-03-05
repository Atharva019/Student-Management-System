package test;
import java.io.*;
import java.net.*;

class UDPClient
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();
        //Client Socket is created

        InetAddress IPAddress = InetAddress.getByName("localhost");
        //Gets the IP Address

        byte[] sendData = new byte[10];
        byte[] sendData2 = new byte[10];
        byte[] receiveData = new byte[10];
        byte[] receiveData2 = new byte[10];

        String sentence = inFromUser.readLine();
        String sentence2 = inFromUser.readLine();

        sendData = sentence.getBytes();
        sendData2 = sentence2.getBytes();
        //sends data

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
        DatagramPacket sendPacket2 = new DatagramPacket(sendData2, sendData2.length, IPAddress, 9876);
        clientSocket.send(sendPacket2);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        DatagramPacket receivePacket2 = new DatagramPacket(receiveData2, receiveData2.length);
        clientSocket.receive(receivePacket2);

        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
    }
}
