package Lab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BuddyInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int phoneNum;
    private String name;
    public BuddyInfo () {}

    public BuddyInfo (String name, int phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public BuddyInfo (Integer id, String name, int phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
        this.id = id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getId (){
        return this.id;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Application.BuddyInfo [id=" + id + ", name=" + name + ", PhoneNum=" + phoneNum + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuddyInfo other = (BuddyInfo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (phoneNum != other.getPhoneNum()){
            return false;
        }
        return true;
    }
}

