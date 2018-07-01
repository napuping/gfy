
package graduation_for_you.test;

public class Address {
    
    private String aid;
    private String aname;
    
    public String getAid() {
        return aid;
    }
    
    public void setAid(String aid) {
        this.aid = aid;
    }
    
    public String getAname() {
        return aname;
    }
    
    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Address [aid=" + aid + ", aname=" + aname + "]";
    }
    
   
}
