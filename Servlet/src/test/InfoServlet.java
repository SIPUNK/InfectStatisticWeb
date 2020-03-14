package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * 
 * @author 陈朝帏
 * @date: 2020.3.12
 *
 */
public class InfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int[][] number = new int[31][6];
    public InfoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if(method.equals("tu")) {
            try {
                tu(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("crawl")) {
        	try {
                crawl(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @param request
     * @param response
     * @throws Exception 
     */
    private void tu(HttpServletRequest request, HttpServletResponse response)throws Exception {
        String time = request.getParameter("time");
        String[] args = {"list","-log","D:\\eclipse\\workspace\\Servlet\\log\\","-out","D:\\output.txt","-date"
        		,time};
        number = InfectStatistic2.main(args);
        for(int i = 0;i < 31;i++)
        {
        	number[i][5] = number[i][0] + number[i][2] +number[i][3];
        }
        Gson gson = new Gson();
        String json = gson.toJson(number);
        System.out.println(json);
        response.getWriter().write(json);
    }
    
    private void crawl(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	String list = WuhanService.getAreaStat();
    	Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        response.getWriter().write(json);
    }

    private void crawl0(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String list = WuhanService.getgetStatisticsService();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        response.getWriter().write(json);
    }

    private void crawl2(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	String list = WuhanService.getAllHistoryDataService();
    	Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        response.getWriter().write(json);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}