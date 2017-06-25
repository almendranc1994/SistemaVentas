
package Connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectDB {
    Connection myConn = null;
    private Statement myStmt = null;
    //ResultSet myRs = null;
	
    String user = "root";
    String pass = "almendra1994";
    
    public Statement getMyStmt() {
        return myStmt;
    }

    public void setMyStmt(Statement myStmt) {
        this.myStmt = myStmt;
    }
    
    public void dbConnect() throws SQLException {
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_ventas", user, pass);
            myStmt = myConn.createStatement();                        
        }
        catch (Exception exc){
            exc.printStackTrace();			
        }	
        finally{  
//            if(myRs != null)
//                    myRs.close();
            if(getMyStmt() != null)
                    getMyStmt().close();
            if(myConn != null)
                    myConn.close();
        }
    }
    
//    public static void main(String[] args) throws SQLException{
//        ConnectDB db = new ConnectDB();
//        db.dbConnect();
//        
//    }   
}
