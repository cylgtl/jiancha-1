package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import freemarker.template.Configuration;


/** 
 * @Description 
 * @ClassName: JeecgInitDB
 * @author tanghan
 * @date 2013-7-19 下午04:24:51  
 */

public class JeecgInitDB {
   
    private static Connection con=null;
    
    
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		if(con == null){
			Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jeecg", "root","root");
		}
		return con;
	}
	
	public static void main(String[] args) throws Exception {
		Configuration cfg = new Configuration();
		String sql1="select * from t_s_attachment";
		String sql2="select * from t_s_base_user";
		String sql3="select * from t_s_depart";
		String sql4="select * from t_s_role";
		String sql5="select * from t_s_user";
		String sql6="select * from t_s_typegroup";
		String sql7 = "select * from t_s_function";
		String sql8 = "select * from t_s_type";
		String sql9 = "select * from t_s_log limit 100";
		String sql10 = "select * from cgform_field where table_id =";  //此处由于需要更具cgform_head生成，故只能单个生成
		String sql11 = "select * from cgform_head ";
        Statement st=null;
        ResultSet rs=null;
	}

}
