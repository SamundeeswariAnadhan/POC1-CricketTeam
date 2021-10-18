package iplTeamspack;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class iplJavaClass {
	
	 static final String DB_URL = "jdbc:mysql://localhost:3306/ipl";
	    static final String USER ="chami";
	    static final String PASS ="1234";
		private static Readable line;


	    public static void main(String[] args) throws SQLException, IOException {


	        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	             Statement stmt = conn.createStatement();

	        ) {
	        	String Team_ID = null;
	        	String Team_Name = null;
	        	String Player_Name=null;
	        	
	        	System.out.println("Successfully connected");
	            Scanner input = new Scanner(new File("C:\\Users\\s.anandhan\\Desktop\\Cricket_Players.txt"));
	            
	            while(input.hasNextLine())
	            {
	            
	            	String line;
		        	line = input.nextLine();
	            	 
	            	
	            
	            try(Scanner data =new Scanner(line))
	            {
	            	if(data.hasNext())
	            	{
	            		Team_ID = data.next();
	            		System.out.println("Team id "+Team_ID);
	            		
	            	}
	            	
	            	if(data.hasNext()) {
	            		Team_Name=data.next();
	            		System.out.println("team name " +Team_Name);
	            	}
	            	if(data.hasNext())
	            	{
	            		Player_Name=data.next();
	            		System.out.println("player name "+Player_Name);
	            	}
	            }
	            catch(Exception e)
	            {
	            	e.printStackTrace();
	            }
	            String sql = "INSERT INTO ipl_teams(Team_ID,Team_Name,Player_Name)values('" +Team_ID + "','" + Team_Name + "','" +Player_Name + "')";
	            stmt.executeUpdate(sql);
	        }
	            String sql="Select * from ipl_teams";
	            ResultSet rst=stmt.executeQuery(sql);
	            ArrayList<String> arr=new ArrayList<String>();
	            
	            while(rst.next())
	            {
	            	String player=rst.getString("Player_Name");
	            	arr.add(player);
	            	
	            }
	            
	            rst.close();
	            for(int i =0; i<arr.size();i++)
	            {
	            System.out.println("Enter the "+arr.get(i)+" Score : ");
                Scanner sc = new Scanner(System.in);
            	String score =sc.next();
            	Statement stm = conn.createStatement();
                sql = "Update ipl_teams set Player_Score ='"+score+"' where Player_Name='"+arr.get(i)+"'";
                stm.executeUpdate(sql);
	            }
	            
	            javaWrite jw= new javaWrite();
	            jw.writeToFile();
	            
	            
	            
}
}
}
