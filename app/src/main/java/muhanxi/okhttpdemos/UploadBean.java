package muhanxi.okhttpdemos;

/**
 * Created by muhanxi on 17/11/10.
 */

public class UploadBean {


    /**
     * ret_code : 200
     * ret_msg : 上传成功
     * path : /usr/local/apache-tomcat-8.0.36/webapps/Bwei/upload/null
     */

    private int ret_code;
    private String ret_msg;
    private String path;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
