package cn.zedongw.jquerystuding.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName UserAction
 * @Description: 用户Action
 * @Author ZeDongW
 * @Date 2020/6/12 0012 10:57
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class UserAction extends ActionSupport {

    /**
     * Description: 检查用户是否注册
     * @methodName: checkUser
     * @param
     * @throws
     * @return: java.lang.String
     * @author: ZeDongW
     * @date: 2020/6/12 0012 10:58
     */
    public String checkUser(){

        String userName1 = "呵呵";
        String passWord1 = "123";

        //获取request对象
        HttpServletRequest req = ServletActionContext.getRequest();

        //获取response对象
        HttpServletResponse resp = ServletActionContext.getResponse();

        //获取用户名密码
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");

        String path = "../images/MsgSent.gif";

        if (userName1.equals(userName) && passWord1.equals(passWord)){
            path = "../images/MsgError.gif";
        }

        PrintWriter pw = null;

        try {
            pw = resp.getWriter();
            pw.write(path);
            pw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        return SUCCESS;
    }
}
