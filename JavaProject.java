
package javaproject;

import java.util.ArrayList;
import java.util.Scanner;


public class JavaProject {
 
    public static void main(String[] args) {
       String userName;
        String userPass;
        String entranceID;
        boolean isAdmin = false;
        boolean exit = false;
        ArrayList<Users> User = new ArrayList<>();
        ArrayList<adminAccess> adminList = initiateAdminAccessList();
        Scanner scanner = new Scanner(System.in);
        application application = new application();
        
        //main page of site
        System.out.println("Welcome to the climate education site");
        
        do{
            System.out.println("Please enter (U=User, A=Admin, R=Register)"); //login in or create a new accout
            entranceID = scanner.nextLine().toUpperCase();
        
            switch(entranceID){
            case "U"://user account login 
                while(true){
                    System.out.println("Enter username(type 0 to exit):");
                    String usernameAuthentication = scanner.nextLine();
                    
                    if(usernameAuthentication.equals("0")){
                        break;
                    }
                         
                    System.out.println("Enter password:");
                    String passwordAuthentication = scanner.nextLine();
                    boolean authenticated = authenticateUser(User, usernameAuthentication, passwordAuthentication);               
                    
                    if (authenticated) {
                        System.out.println("Authentication successful");
                        System.out.println("welcome "+usernameAuthentication);
                        exit = true;
                        break;
                    }
                    else {
                        System.out.println("Authentication failed");
                        System.out.println("Please try again");
                    }  
                    System.out.println("----------------------------------------");
                }     
            break;
            case "A": //admin account login
                while(true){
                    System.out.println("Enter admin name(type 0 to exit):");
                    String adminnameAuthentication = scanner.nextLine();
                    
                    if(adminnameAuthentication.equals("0")){
                        break;
                    }
                         
                    System.out.println("Enter password:");
                    String adminpassAuthentication = scanner.nextLine();
                    boolean authenticated = authenticateAdmin(adminList, adminnameAuthentication, adminpassAuthentication);               
                    
                    if (authenticated) {
                        System.out.println("Authentication successful");
                        System.out.println("welcome "+adminnameAuthentication);
                        isAdmin = true;
                        exit = true;
                        break;
                    }
                    else {
                        System.out.println("Authentication failed");
                        System.out.println("Please try again");
                    }
                    System.out.println("----------------------------------------");
                }   
            break;
            case "R": //register new account
                while(true){
                    System.out.println("Please enter new username(type 0 to exit)");
                    userName = scanner.nextLine();
                    if(userName.equals("0")){
                        break;
                    }
                    else{
                        System.out.println("Please enter a new password");
                        userPass = scanner.nextLine();
                        
                        System.out.println("Thank you registering");
                        User.add(new Users(userName, userPass));
                        System.out.println("----------------------------------------");
                        break;
                    }
                }               
            break; 
            default : System.out.println("invalid Entrance ID");
             }           
        }while(!exit);
        System.out.println("----------------------------------------");
       application.runApplication(isAdmin);
   
    }
    //stored admin account and password
    private static ArrayList<adminAccess> initiateAdminAccessList(){
        ArrayList<adminAccess> adminList = new ArrayList<>();
        adminList.add(new adminAccess("darren", "darren123"));
        adminList.add(new adminAccess("cheah", "cheah123"));
        adminList.add(new adminAccess("zhao", "zhao123"));
        adminList.add(new adminAccess("guan", "guan123"));
        adminList.add(new adminAccess("jing", "jing123"));
        adminList.add(new adminAccess("shi", "shi123"));
        return adminList;
        }
    
        //user account authentication 
        private static boolean authenticateUser(ArrayList<Users> users, String usernameAuthentification, String passwordAuthentification) {
        for (Users user : users) {
            if (user.getuserName().equals(usernameAuthentification) && user.getuserPass().equals(passwordAuthentification)) {
                return true; 
            }
        }
        return false;
        }
        
        //admin account authentication
        private static boolean authenticateAdmin(ArrayList<adminAccess> adminAccessList, String adminnameAuthentification, String adminpassAuthentification) {
        for (adminAccess admin : adminAccessList) {
            if (admin.getadminName().equals(adminnameAuthentification) && admin.getadminPass().equals(adminpassAuthentification)) {
                return true;
            }
        }
        return false;
    }   
}