package judge;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserJudge implements UserJudgeImp {
    @Override
    public boolean login(String userName, String password) throws Exception {
        // 读取数据库
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String usrPassword = null;
        String sql = "select * from t_user where username=(?) and password=(?)";
        User usrinfo = null;
        try {
            usrinfo = qr.query(DataSourceUtils.getConnection(), sql,new BeanHandler<>(User.class), userName, password);
            System.out.println(usrinfo);
			if (usrinfo != null) {
				return true;
			}else {
				return false;
			}
        } catch (Exception e) {
            throw e;
        }

//        Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs   = null;
//		try {
//			//1. 得到连接对象
//			conn = JdbcUtils.getConnection();
//
//			String sql = "select * from t_user where username=? and password=?";
//
//			//2. 创建ps对象
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, userName);
//			ps.setString(2, password);
//
//
//			//3. 开始执行。
//			rs = ps.executeQuery();
//
//			//如果能够成功移到下一条记录，那么表明有这个用户。
//			return rs.next();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally {
//			JdbcUtils.closeResource(conn, ps, rs);
//		}
    }
}
