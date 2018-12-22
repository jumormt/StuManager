package judge;

import model.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StuJudge implements StuJudgeImp {
    @Override
    public List<Student> findAll() throws Exception {
        QueryRunner qrr = new QueryRunner(DataSourceUtils.getDataSource());
        String sqll = "select * from t_stu";
        List<Student> st = null;
		try {
			st = qrr.query(DataSourceUtils.getConnection(), sqll, new BeanListHandler<>(Student.class));
			return st;
		} catch (Exception e) {
			throw e;
		}

//        Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs   = null;
//        List<Student> list = new ArrayList<Student>();
//
//		//1. 得到连接对象
//		conn = JdbcUtils.getConnection();
//
//		String sql = "select * from t_stu";
//
//		ps = conn.prepareStatement(sql);
//
//		rs = ps.executeQuery();
//
//
//		//数据多了，用对象装， 对象也多了呢？ 用集合装。
//		while (rs.next()) { //10 次 ，10个学生
//
//			Student stu = new Student();
//
//			stu.setId(rs.getInt("id"));
//			stu.setAge(rs.getInt("age"));
//			stu.setName(rs.getString("name"));
//			stu.setGender(rs.getString("gender"));
//			stu.setAddress(rs.getString("address"));
//
//			list.add(stu);
//
//		}
//
//
//		JdbcUtils.closeResource(conn, ps, rs);
//
//
//		return list;
    }
}
