package tests_delete_when_deploy;

/**
 * Created by Win81 on 4/26/2015.
 */
public class User_Mapping {
    private int id;
    private String name;
    private String username;
    private String email;
    private User_Address_Mapping address;
    private User_Geo_Mapping geo;
    private String phone;
    private String website;
    private User_Company_Mapping company;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User_Address_Mapping getAddress() {
        return address;
    }

    public void setAddress(User_Address_Mapping address) {
        this.address = address;
    }

    public User_Geo_Mapping getGeo() {
        return geo;
    }

    public void setGeo(User_Geo_Mapping geo) {
        this.geo = geo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public User_Company_Mapping getCompany() {
        return company;
    }

    public void setCompany(User_Company_Mapping company) {
        this.company = company;
    }

}
