package servlet;

import judge.StuJudge;
import judge.StuJudgeImp;
import judge.UserJudge;
import judge.UserJudgeImp;
import model.Student;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //向客户端输出内容
        PrintWriter pw = resp.getWriter();
        boolean isSuccess = false;
        UserJudgeImp stuJudge = new UserJudge();
        try {
            isSuccess = stuJudge.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        // 读取数据库
//        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
//        String usrPassword = null;
//        String sql = "select * from t_user where username=(?)";
//        User usrinfo = null;
//        try {
//            usrinfo = qr.query(sql, username, new BeanHandler<>(User.class));
//            System.out.println(usrinfo);
//            usrPassword = usrinfo.getPassword();
//        } catch (Exception e) {
//            e.printStackTrace();
//            pw.write("查无此人..");
//            return;
//        }

        // 校验
        if (isSuccess) {
            System.out.println("登录r成功");
            StuJudgeImp stuJudge1 = new StuJudge();
            try {
                List<Student> list = stuJudge1.findAll();
                //2. 先把这个集合存到作用域中。
                req.getSession().setAttribute("list", list);

                //2. 重定向
                resp.sendRedirect("stu_list.jsp");

            } catch (Exception e) {
                e.printStackTrace();
                pw.write("wuwuwu..");
                return;
            }
        }else {
            pw.write("login failed..");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
