package ra.Model.Entity;

public class User {
    private int userID;
    private String userName;
    private String password;
    private String confirmPass;
    private String fullName;
    private boolean userStatus;
    private boolean permission;
    private String email;
    private String phoneNumber;

    public User() {
    }

    public User(int userID,
                String userName,
                String password,
                String confirmPass,
                String fullName,
                boolean userStatus,
                boolean permission,
                String email,
                String phoneNumber) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.confirmPass = confirmPass;
        this.fullName = fullName;
        this.userStatus = userStatus;
        this.permission = permission;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
