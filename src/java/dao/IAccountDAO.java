package dao;

import bean.AccountBean;
import java.util.List;
import java.util.Map;

/**
 *
 * @author win
 */
public interface IAccountDAO {

    public Map<String, String> getDisplayNames();//Lisst all and hash Name of Account from database

    public AccountBean getAccountByUsername(String username); // find account by username

    public AccountBean getAccountByMail(String email); //get account from db by checking exist mail;

    public int updateNewPassword(AccountBean account); //update account with AccountBean object as parameter

    public int insertNewAccount(AccountBean account); //insert new account with AccountBean object as parameter
    
    public boolean updateInformation(AccountBean account); //update new information with AccountBean object as parameter
    
    public int totalAccount(); //get total numbers account from user
    
    public int totalAccountSearch(String searchString); //get total numbers accountby search from user
    
    public List<AccountBean> getAllAccount(int pageindex, int pagesize);// get all account from user
    
    public List<AccountBean> getAllAccountBySearch(String searchString, int pageindex, int pagesize);// get all account from user
    
    public void updateStatusAccount(String username, String status); //update status of account with AccountBean object as parameter
    
    public void deleteAccount(String username); //delete account with AccountBean object as parameter

    public void updateStateACcount(AccountBean account); //update state of accountbean in web app
}
