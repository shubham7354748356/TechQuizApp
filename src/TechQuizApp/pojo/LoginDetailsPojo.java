/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TechQuizApp.pojo;

/**
 *
 * @author india
 */
public class LoginDetailsPojo
{

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public LoginDetailsPojo(String name, String password, String user_type) {
        this.name = name;
        this.password = password;
        this.user_type = user_type;
    }
    private String name;
    private String password;
    private String user_type;
    public LoginDetailsPojo()
    {
        
    }
    
}
