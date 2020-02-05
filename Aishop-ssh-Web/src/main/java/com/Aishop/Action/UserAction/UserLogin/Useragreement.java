package com.Aishop.Action.UserAction.UserLogin;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Useragreement extends ActionSupport implements ServletRequestAware, ServletResponseAware {

    private HttpServletRequest request;
    private HttpServletResponse response;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }


    public List<List<String>> getRecord() {
        List<List<String>> record = new ArrayList<List<String>>();
        try {
            String encoding = "GBK";
            File file = new File("F:\\Aishopssh\\Aishop-ssh-Web\\src\\main\\webapp\\xieyi.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTXT = null;
                while ((lineTXT = bufferedReader.readLine()) != null) {
                    String[] lineString = lineTXT.split("	");
                    List<String> lineList = new ArrayList<String>();
                    for (int i = 0; i < lineString.length; i++) {
                        lineList.add(lineString[i]);
                    }
                    record.add(lineList);
                }
                read.close();
            } else {
                System.out.println("");
            }
        } catch (Exception e) {
            System.out.println("失败");
            e.printStackTrace();
        }
        return record;
    }


}
