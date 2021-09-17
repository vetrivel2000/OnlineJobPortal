package logical;

import pojo.Applicant;
import pojo.Company;

import java.util.ArrayList;
import java.util.HashMap;

public class LogicalLayer {
    HashMap<String, Applicant> applicantHashMap=new HashMap<>();
    HashMap<String, Company> companyHashMap= new HashMap<>();
    HashMap<String, HashMap<Integer,Company>> roleData= new HashMap<>();
    HashMap<Integer,Company> details;
    public void storeIntoApplicantMap(Applicant applicant)
    {
        applicantHashMap.put(applicant.getUserName(), applicant);
    }
    public void storeIntoCompanyHashMap(Company company)
    {
        companyHashMap.put(company.getUserName(), company);
    }
    public void storeToRoleData(Company company)
    {
        details= roleData.get(company.getRoleName());
        if(details==null)
        {
            details=new HashMap<>();
        }
        details.put(company.getPostId(),company);
        roleData.put(company.getRoleName(),details);
    }
    public HashMap<String, Applicant> getApplicantHashMap() {
        return applicantHashMap;
    }

    public HashMap<String, Company> getCompanyHashMap() {
        return companyHashMap;
    }

    public HashMap<String, HashMap<Integer ,Company>> getRoleData() {
        return roleData;
    }
}
