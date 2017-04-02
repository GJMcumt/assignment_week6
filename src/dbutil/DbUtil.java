package dbutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import javax.naming.*;

public class DbUtil {
	private static DataSource dataSource=null;
	
	static {
		try{
			Context initContext = new InitialContext();
            dataSource = (DataSource)initContext.lookup("java:/comp/env/jdbc/online_shop");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection connection=null;
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public static boolean executeUpdate(String sql,Object[] args){
		Connection conn=null;
		PreparedStatement pst=null;
		int rowsCount=0;
		try{
			conn=dataSource.getConnection();
			pst=conn.prepareStatement(sql);
			if(args!=null&args.length>0){
				for(int i=0;i<args.length;i++){
					pst.setObject(i+1, args[i]);
				}
			}
			rowsCount=pst.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rowsCount>0;
	}
	public static ResultSet executeQuery(String sql,Object[] args){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			conn=dataSource.getConnection();
			pst=conn.prepareStatement(sql);
			if(args!=null&args.length>0){
				for(int i=0;i<args.length;i++){
					pst.setObject(i+1, args[i]);
				}
			}
			rs=pst.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return rs;





	}
}
