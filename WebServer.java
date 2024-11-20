package JavaWeb;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public static void main(String[] args)throws Exception {
        //启动服务器
        ServerSocket serverSocket = new ServerSocket(8080);   
        Socket accept=serverSocket.accept();
        //获得输入流
        InputStream inputStream=accept.getInputStream();
        byte[]buf=new byte[1024];
        int len;
        while (inputStream.available()>0) {
            len=inputStream.read(buf);
            System.out.print(new String(buf,0,len));
        }
        inputStream.close();
        accept.close();
    }
}
