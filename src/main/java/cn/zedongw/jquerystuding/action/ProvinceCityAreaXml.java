package cn.zedongw.jquerystuding.action;

import cn.zedongw.jquerystuding.entity.Bean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ProvinceCityArea
 * @Description: 省份城市区域下拉框三级联动
 * @Author ZeDongW
 * @Date 2020/5/5 0005 11:15
 * @Version 1.0
 * @Modified By:
 * @Modified Time:
 **/
public class ProvinceCityAreaXml extends ActionSupport {

    private static final String HUBEI = "湖北";
    private static final String GUANGDONG = "广东";
    private static final String YUNNAN = "云南";
    private static final String WUHAN = "武汉";
    private static final String HUANGGANG = "黄冈";
    private static final String XIANNING = "咸宁";
    private static final String GUANGZHOU = "广州";
    private static final String SHENZHEN = "深圳";
    private static final String KUNMING = "昆明";

    /**
     * 获取request和response对象
     */
    HttpServletRequest req = ServletActionContext.getRequest();
    HttpServletResponse resp = ServletActionContext.getResponse();


    private Bean bean;

    public Bean getBean() {
        return bean;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    /**
     * Description: 根据选择的省份返回城市
     * @methodName: selectProvince
     * @param
     * @throws
     * @return: java.lang.String
     * @author: ZeDongW
     * @date: 2020/5/5 0005 11:37
     */
    public String province(){
        //获取省份
        String province = bean.getProvince();
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='UTF-8'?><root>");
        if (HUBEI.equals(province)){
            sb.append("<city>" + WUHAN + "</city>");
            sb.append("<city>" + HUANGGANG + "</city>");
            sb.append("<city>" + XIANNING + "</city>");
        } else if (GUANGDONG.equals(province)){
            sb.append("<city>" + GUANGZHOU + "</city>");
            sb.append("<city>" + SHENZHEN + "</city>");
        } else if (YUNNAN.equals(province)){
            sb.append("<city>" + KUNMING + "</city>");
        }
        sb.append("</root>");
        writeXml(sb);

        return "success";
    }

    /**
     * Description: 输出XML数据
     * @methodName: writeXml
     * @param sb 1
     * @throws
     * @return: void
     * @author: ZeDongW
     * @date: 2020/6/12 0012 17:27
     */
    private void writeXml(StringBuilder sb) {
        //设置返回格式
        resp.setContentType("text/xml;charset=UTF-8");

        PrintWriter pw = null;

        try {
            pw = resp.getWriter();
            pw.write(sb.toString());
            pw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    /**
     * Description: 根据选择的城市返回地区
     * @methodName: selectCity
     * @param
     * @throws
     * @return: java.lang.String
     * @author: ZeDongW
     * @date: 2020/5/5 0005 11:38
     */
    public String city(){
        //获取城市
        String city = bean.getCity();

        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='UTF-8'?><root>");
        switch (city){
            case WUHAN:
                sb.append("<area>硚口</area>");
                sb.append("<area>江岸</area>");
                sb.append("<area>武昌</area>");
                break;
            case HUANGGANG:
                sb.append("<area>麻城</area>");
                sb.append("<area>红安</area>");
                break;
            case XIANNING:
                sb.append("<area>温泉</area>");
                sb.append("<area>嘉鱼</area>");
                sb.append("<area>通山</area>");
                break;
            case GUANGZHOU:
                sb.append("<area>天河</area>");
                sb.append("<area>番禺</area>");
                break;
            case SHENZHEN:
                sb.append("<area>南山</area>");
                sb.append("<area>保安</area>");
                sb.append("<area>龙岗</area>");
                break;
            case KUNMING:
                sb.append("<area>盘龙</area>");
                sb.append("<area>官渡</area>");
                break;
            default:
                break;
        }
        sb.append("</root>");
        writeXml(sb);

        return "success";
    }

}
