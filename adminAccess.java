
package javaproject;

//adminAccess class
//to store and retrieve admin name and password
public class adminAccess {
    private final String adminName;
    private final String adminPass;

    public adminAccess(String adminName, String adminPass) {
        this.adminName = adminName;
        this.adminPass = adminPass;
    }

    public String getadminName() {
        return adminName;
    }

    public String getadminPass() {
        return adminPass;
    }
}
