/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.User;

/**
 *
 * @author 783856
 */
public class AccountService {
    
    public User login(String s1 , String s2){
       
       User u1 = null;
        
        if(s1.equals("adam") ||s1.equals("betty") && s2.equals("password"))
       {
        
           u1 = new User(s1,null);
       }
        
        return u1;
    }
    
}
