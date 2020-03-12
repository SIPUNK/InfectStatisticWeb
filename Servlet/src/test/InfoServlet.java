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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @param request
     * @param response
     */
    private void tu(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
        String time = request.getParameter("time");
        String[] args = {"list","-log","D:\\eclipse\\workspace\\Servlet\\log\\","-out","D:\\output.txt","-date"
        		,time};
        InfectStatistic.main(args);
        Gson gson = new Gson();
        String json = gson.toJson(time);
        System.out.println(json);
        response.getWriter().write(json);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}