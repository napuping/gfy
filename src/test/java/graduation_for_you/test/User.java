
package graduation_for_you.test;

public class User {
    
    private String id;
    private String name;
    
    private Address address;
    
    
    public Address getAddress() {
        return address;
    }

    
    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
    }
    

}
