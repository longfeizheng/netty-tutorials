package com.niocoder.iosocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created on 2018/6/26.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class Server {

    private ServerSocket serverSocket;

    public Server(int port){
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口："+port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart(){
        try {
            Socket client = serverSocket.accept();
            new ClientHandler(client).start();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务端异常");
        }
    }
}
