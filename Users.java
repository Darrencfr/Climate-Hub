
package javaproject;

//users class
//to store and retrieve username and password
public class Users{
    private final String userName;
    private final String userPass;
    
    public Users(String userName, String userPass){
        this.userName = userName;
        this.userPass = userPass;
    }
    
    public String getuserName(){
        return userName;
    }
     
    public String getuserPass(){
        return userPass;
    }
       
}
