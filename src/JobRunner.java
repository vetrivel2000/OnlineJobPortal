import logical.LogicalLayer;
import pojo.Applicant;
import pojo.Company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class JobRunner {
    static ArrayList<Applicant> applicants= new ArrayList<>();
    static ArrayList<Company> companies= new ArrayList<>();
    static LogicalLayer logical= new LogicalLayer();
    static  Scanner scan = new Scanner(System.in);
    static int postId=1;
    public static void main(String[] args)
    {
        int option;
        do {
            System.out.println("1.ApplicantSignUp\n2.CompanySignUp\n3.ApplicantLogin\n4.CompanyLogin\n5.Exit");
            option=scan.nextInt();
            switch (option)
            {
                case 1:
                {
                    System.out.println("Enter name");
                    String name = scan.next();
                    System.out.println("Enter email");
                    String email=scan.next();
                    System.out.println("Enter password");
                    String passWord=scan.next();
                    System.out.println("Enter cgpa");
                    float cgpa=scan.nextFloat();
                    System.out.println("Enter interested field");
                    String field=scan.next();
                    Applicant applicant= new Applicant();
                    applicant.setName(name);
                    applicant.setUserName(email);
                    applicant.setPassWord(passWord);
                    applicant.setCgpa(cgpa);
                    applicant.setField(field);
                    applicants.add(applicant);
                    System.out.println("Successful");
                    logical.storeIntoApplicantMap(applicant);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter companyName");
                    String companyName=scan.next();
                    scan.nextLine();
                    System.out.println("Enter Required Role");
                    String roleName=scan.next();
                    System.out.println("Enter numberOf vacancies");
                    int numberOfVacancies=scan.nextInt();
                    System.out.println("Enter mobileNumber");
                    String mobileNumber=scan.next();
                    System.out.println("Enter eligible cgpa");
                    float cgpa = scan.nextFloat();
                    System.out.println("Enter user name");
                    String userName=scan.next();
                    System.out.println("Enter password");
                    String passWord=scan.next();
                    Company company = new Company();
                    company.setCompanyName(companyName);
                    company.setRoleName(roleName);
                    company.setNumberOfVacancies(numberOfVacancies);
                    company.setRequiredCgpa(cgpa);
                    company.setMobileNumber(mobileNumber);
                    company.setPassWord(passWord);
                    company.setUserName(userName);
                    company.setPostId(postId);
                    postId++;
                    companies.add(company);
                    System.out.println("Successfully registered and Posted the Job");
                    logical.storeIntoCompanyHashMap(company);
                    logical.storeToRoleData(company);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter userName");
                    String userName= scan.next();
                    System.out.println("Enter password");
                    String passWord= scan.next();
                    HashMap<String ,Applicant> applicantData= logical.getApplicantHashMap();
                    Applicant applicant=applicantData.get(userName);
                    String originalPassWord=applicant.getPassWord();
                    if(!(passWord.equals(originalPassWord)))
                    {
                        System.out.println("Check credentials");
                        return;
                    }
                    System.out.println("SuccessfullyLoggedIn");
                    jobSearch(userName);
                    break;
                }
                case 4:
                {
                    System.out.println("Enter userName");
                    String userName= scan.next();
                    System.out.println("Enter password");
                    String passWord= scan.next();
                    HashMap<String ,Company> companyData = logical.getCompanyHashMap();
                    Company company= companyData.get(userName);
                    String originalPassWord=company.getPassWord();
                    if(!(passWord.equals(originalPassWord)))
                    {
                        System.out.println("Check credentials");
                        return;
                    }
                    System.out.println("SuccessfullyLoggedIn");
                    postNewJob(userName);
                    break;
                }
            }
        }while (option<5);
    }
    public static void jobSearch(String userName)
    {
        System.out.println("Enter the interested field");
        String field=scan.next();
        HashMap<String,HashMap<Integer,Company>> roleData= logical.getRoleData();
        HashMap<Integer,Company> companies=roleData.get(field);
        System.out.println("The search results are");
        System.out.println(companies);
        System.out.println("Enter the post Id");
        int id = scan.nextInt();
        Company company=companies.get(id);
        if(company.getNumberOfVacancies()==0)
        {
            System.out.println("NoVacancy");
            return;
        }
        HashMap<String ,Applicant> applicantData= logical.getApplicantHashMap();
        Applicant applicant=applicantData.get(userName);
        float cgpa=applicant.getCgpa();
        if(cgpa< company.getRequiredCgpa())
        {
            System.out.println("You are not eligible for apply this job:");
            return;
        }
        System.out.println("SuccessFully applied");
    }
    public static void postNewJob(String userName)
    {
        HashMap<String ,Company> companyData = logical.getCompanyHashMap();
        Company company= companyData.get(userName);
        Company company1=new Company();
        company1.setPostId(postId);
        postId++;
        company1.setCompanyName(company.getCompanyName());
        company1.setMobileNumber(company.getMobileNumber());
        company1.setRequiredCgpa(company.getRequiredCgpa());
        company1.setUserName(company.getUserName());
        company1.setPassWord(company.getPassWord());
        System.out.println("Enter the role you want");
        String role=scan.next();
        System.out.println("Enter the numberOf vacancies");
        int numberOfVacancies=scan.nextInt();
        company1.setRoleName(role);
        company1.setNumberOfVacancies(numberOfVacancies);
        logical.storeIntoCompanyHashMap(company1);
        logical.storeToRoleData(company1);
        System.out.println("Successfully posted");
    }
}
