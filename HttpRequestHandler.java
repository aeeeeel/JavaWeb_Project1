package JavaWeb;
import java.io.IOException;
import java.io.InputStream;
public class HttpRequestHandler{
    public static HttpRequest getRequest(InputStream inputstream){
    //从流中读取请求的报文
    StringBuilder request=new StringBuilder();

    byte[]buf=new byte[1024];
        int len;
        try {
            while (inputstream.available()>0) {
                len=inputstream.read(buf);
                request.append(new String(buf,0,len));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block//应当处理这个异常
            e.printStackTrace();
        }
    //GET / HTTP/1.1 -->请求行
    //HOST: 127.0.0.1:8888 -->首部信息
    //  
    //
    //a=b&&c=d -->实体
    HttpRequest httprequest=new HttpRequest();
    String []headAndBody=request.toString().split("\r\n\r\n");
    //先处理实体
    if(headAndBody[1]!=null&&headAndBody.length>1){
        httprequest.setBody(headAndBody[1]);
    }
    //处理请求行
    String startAndHeader=headAndBody[0];
    String [] startAndHeaders =startAndHeader.split("\r\n");  
    String startLine=startAndHeaders[0];
    String[] startLineElement=startLine.split(" ");
    httprequest.setMethod(startLineElement[0]);
    httprequest.setUri(startLineElement[1]);
    httprequest.setProtocol(startLineElement[2]);  
    //处理首部信息，startAndHeaders除了第一行其余部分
    for(int i=1;i<startAndHeaders.length;i++)
    {
        String header=startAndHeaders[i];
        String[] keyAndValue=header.split(": ");
        httprequest.setHeader(keyAndValue[0],keyAndValue[1]);
    }  
    return httprequest;
}
}