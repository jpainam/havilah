package publics;

/**
 *
 * @author jpainam
 */
public class Users{
    private int iduser;
    private String login;
    private String password;
    private String profile;
    
    public Users(int id, String login, String password, String profile){
        this.iduser = id;
        this.login = login;
        this.password = password;
        this.profile = profile;
    
    }
    public Users(){}
    
    public Users(String login, String password){
        this.login = login;
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String s){
        this.password = s;
    }

    @Override
    public String toString() {
        return "Users{" + "Login=" + login + ", password=" + password + '}';
    }
    
}