package base;
import java.util.Properties;
import java.sql.*;
public class Base {
	String user;
	String dateBase;
	String password;
	public Base(String u,String db,String mdp)
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
			System.out.println(e);
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
			stmt.executeQuery(sql);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int partieEnCours()
	{
		int partie=0;
		try{
			Connection con=connect();
			Statement stmt=statement(con);
			String sql="SELECT max(idPartie) FROM partie";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				partie=rs.getInt(1);

			}

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return partie;
	}

	public void updateScore(int scorePlayer1,int scorePlayer2)
	{
		try{
			Connection con=connect();
			Statement stmt=statement(con);
			String sql="UPDATE partie SET scorePlayer1="+scorePlayer1+", scorePlayer2="+scorePlayer2+" WHERE idPartie="+partieEnCours();
			stmt.executeQuery(sql);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}