package com.sheikhimtiaz.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketClient {
    static InetAddress host;
    private static final int PORT = 9876;

    public static void run() throws IOException, ClassNotFoundException, InterruptedException {
        RequestObject requestObject = new RequestObject();
        requestObject.managerName= "PrimeCalculationManager";
        requestObject.method="findPrimes";
//        String[] methodParams = {"10", "1000000","200","50000"};
        String[] methodParams = {"10", "1000000","200","50000"};
        for (int i = 0; i < 4; i++) {
            requestObject.args = new HashMap<>();
            requestObject.args.put("n", methodParams[i]);
            // opening new socket for every request here. we can also send multiple requests with one socket.
            Socket socket = new Socket("localhost", PORT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(requestObject);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            String message = (String) objectInputStream.readObject();
            System.out.println("Message from server: " + message);
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
            Thread.sleep(100);
        }
    }
}

class RequestObject implements Serializable {
    public String managerName;
    public String method;
    public Map<String, String> args;

    @Override
    public String toString() {
        return "RequestObject{" +
                "managerName='" + managerName + '\'' +
                ", method='" + method + '\'' +
                ", args=" + args +
                '}';
    }
}
