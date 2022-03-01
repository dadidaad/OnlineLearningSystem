package Dao;

import Bean.AccountBean;
import java.util.Map;

/**
 *
 * @author win
 */
public interface IAccountDAO {

    public Map<String, String> getDisplayNames();//Lisst all and hash Name of Account from database

    public AccountBean getAccountByUsername(String username); // find account by username

    public AccountBean getAccountByMail(String email); //find account by mail;

    public boolean updateNewPassword(AccountBean account); //update account with AccountBean object as parameter

    public boolean insertNewAccount(AccountBean account); //insert new account with AccountBean object as parameter
    
    public boolean updateInformation(AccountBean account); //update new information with AccountBean object as parameter

}
