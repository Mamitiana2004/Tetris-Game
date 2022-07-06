package base;
import java.util.Properties;
import java.sql.*;
public class Postgres {
	String user;
	String dateBase;
	String password;
	public Postgres(String u,String db,String mdp)
	{
		user=u;
		dateBase=db;
		password=mdp;
	}

	public Connection connect(){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dateBase,user,password);
 		}
		catch(Exception e){ 
			System.out.println(e.getMessage());
		}
		return con;
	}

	public Statement statement(Connection con)
	{
		Statement stmt=null;
		try{
			stmt=con.createStatement();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return stmt;
	}

	public void debutPartie()
	{
		try{
			Connection con=connect();
			Statement stmt=statement(con);
			String sql="INSERT INTO partie(scorePlayer1,scorePlayer2) VALUES(0,0)";
			ResultSet res= stmt.executeQuery(sql);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}