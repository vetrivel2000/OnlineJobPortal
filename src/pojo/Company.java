package pojo;

public class Company {
    private String companyName;
    private String RoleName;
    private int numberOfVacancies;
    private String mobileNumber;
    private float requiredCgpa;
    private String userName;
    private String passWord;
    private int postId;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public int getNumberOfVacancies() {
        return numberOfVacancies;
    }

    public void setNumberOfVacancies(int numberOfVacancies) {
        this.numberOfVacancies = numberOfVacancies;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public float getRequiredCgpa() {
        return requiredCgpa;
    }

    public void setRequiredCgpa(float requiredCgpa) {
        this.requiredCgpa = requiredCgpa;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", RoleName='" + RoleName + '\'' +
                ", numberOfVacancies=" + numberOfVacancies +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", requiredCgpa=" + requiredCgpa +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", postId=" + postId +
                '}';
    }
}
