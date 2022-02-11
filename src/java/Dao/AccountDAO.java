package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author win
 */
public class AccountDAO  extends BaseDAO implements IAccountDAO{

    @Override
    public Map<String, String> getDisplayNames() {
         Map<String, String> DisplayNames = new HashMap<>();
        try {
            //Set up connection and Sql statement for Querry
            Connection conn = getConnection();
            String sql = "select * from Account";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            //Querry and save in ResultSet
            ResultSet rs = statement.executeQuery();
            
            //Assign data to an arraylist of SubjectBean
            while(rs.next())
            {
                DisplayNames.put(rs.getString("Username"), rs.getString("DisplayName"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return DisplayNames;
    }
    
}
