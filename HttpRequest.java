package JavaWeb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest implements Serializable{
    private static final long serialVersionUid=1L;
    //协议
    private String protocol;
    //请求方式
    private String method;
    //uri
    private String uri;
    //请求头
    private Map<String,String> header=new HashMap<>();
    //请求体
    private String body;
    public String getProtocol() {
        return protocol;
    }
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }
    public String getHeader(String key) {
        return this.header.get(key);
    }
    public void setHeader(String key, String value) {
        this.header.put(key, value);
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    @Override
    public String toString() {
        return "HttpRequest [protocol=" + protocol + ", method=" + method + ", uri=" + uri + ", header=" + header
                + ", body=" + body + "]";
    }
    
    
}