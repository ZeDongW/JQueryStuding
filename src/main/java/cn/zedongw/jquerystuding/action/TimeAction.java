package cn.zedongw.jquerystuding.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TimeAction
 * @Description: 获取当前时间
 * @Author ZeDongW
 * @Date 2020/6/11 0011 9:51
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class TimeAction extends ActionSupport {

    /**
     * Description: 获取当前时间
     * @methodName: getNowTime
     * @param
     * @throws
     * @return: java.lang.String
     * @author: ZeDongW
     * @date: 2020/6/11 0011 10:11
     */
    public String getNowTime(){
        HttpServletResponse resp = ServletActionContext.getResponse();

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter pw = null;
        try {
            pw = resp.getWriter();
            pw.write(new SimpleDateFormat("yyyy年MM月dd HH:mm:ss").format(new Date()));
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流对象不为空
            if (pw != null) {
                //关闭流对象
                pw.close();
            }
        }

        return null;
    }
}
