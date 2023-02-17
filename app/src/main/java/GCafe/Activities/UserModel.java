package GCafe.Activities;

public class UserModel {
    private String userName;
    private String userPhoneNumber;
    private String userAdmissionNumber;
    private String setTime;

    public UserModel(String userName, String userPhoneNumber, String userAdmissionNumber) {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAdmissionNumber = userAdmissionNumber;
        this.setTime = setTime;
    }

    public UserModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAdmissionNumber() {
        return userAdmissionNumber;
    }

    public void setUserAdmissionNumber(String userAdmissionNumber) {
        this.userAdmissionNumber = userAdmissionNumber;
    }

    public String getSetTime() {
        return setTime;
    }

    public void setSetTime(String setTime) {
        this.setTime = setTime;
    }
}
