/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.authentication;

import publics.DBUsers;
import publics.Users;

/**
 *
 * @author jpainam
 * created : 01 - Nov - 2013
 * Last modification : 01 - Nov - 2013
 */
public final class SecurityManager {
    public static boolean login(String username, String password) {
        Users user = DBUsers.getData(username);
        //System.out.println(user.toString());
        if(user == null){
            return false;
        }else{
            if(password.equals(user.getPassword()))
                return true;
            else
                return false;
        }
    }
}
