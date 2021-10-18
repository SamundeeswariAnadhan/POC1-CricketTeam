package iplTeamspack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class javaWrite {
	static final String DB_URL = "jdbc:mysql://localhost:3306/ipl";
    static final String USER ="chami";
    static final String PASS ="1234";
	


    public static void writeToFile() throws SQLException, IOException {


        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();

      ){
        	String sql="select * from ipl_teams where Team_ID='T1' ORDER BY Player_Score";
            ResultSet rst=stmt.executeQuery(sql);
            BufferedWriter bf=new BufferedWriter(new FileWriter("C:\\Users\\s.anandhan\\Desktop\\scoreWrite.txt"));
            while(rst.next())
            {
            	String line=rst.getString(1)+" ";
            	 line+=rst.getString(2)+ " ";
            	 line+=rst.getString(3)+ " ";
            	 line+= rst.getString(4)+ "\n";
            	 bf.write(line);
            	 
            }
            sql="select * from ipl_teams where Team_ID='T2' ORDER BY Player_Score";
            rst=stmt.executeQuery(sql);
            
            while(rst.next())
            {
            	String line=rst.getString(1)+" ";
            	 line+=rst.getString(2)+ " ";
            	 line+=rst.getString(3)+ " ";
            	 line+= rst.getString(4)+ "\n";
            	 bf.write(line);
            	 
            }
            sql="select * from ipl_teams where Team_ID='T3' ORDER BY Player_Score";
            rst=stmt.executeQuery(sql);
            
            while(rst.next())
            {
            	String line=rst.getString(1)+" ";
            	 line+=rst.getString(2)+ " ";
            	 line+=rst.getString(3)+ " ";
            	 line+= rst.getString(4)+ "\n";
            	 bf.write(line);
            	 
            }bf.close();
        }
        }
}
