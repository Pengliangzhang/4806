package Lab;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook implements Serializable {
    @Id@GeneratedValue
    private Integer id;

    @OneToMany (cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddyList;

    public AddressBook (int id) {
        this.id = id;
        this.buddyList = new ArrayList<BuddyInfo>();
    }

    public AddressBook () {
        this.buddyList = new ArrayList<BuddyInfo>();
    }

    public void addBuddyInfo (BuddyInfo buddy) {
        this.buddyList.add(buddy);
    }
    public void addBuddyInfo (String name, int phoneNum) {
        BuddyInfo buddy = new BuddyInfo(name, phoneNum);
        this.buddyList.add(buddy);
    }

    @Override
    public String toString () {
        String info = "";
        for (BuddyInfo buddy: this.buddyList) {
            info+=("Name: " + buddy.getName() + " ");
            info+=("Phone Number: " + buddy.getPhoneNum() + "  ");
        }
        return info;
    }

    public void printBuddyInfo () {
        for (BuddyInfo buddy: this.buddyList) {
            System.out.println("Name: " + buddy.getName());
            System.out.println("Phone Number: " + buddy.getPhoneNum());
        }
    }

    public void removeBuddy (String name){
        for (BuddyInfo buddy: this.buddyList){
            if (buddy.equals(name)){
                this.buddyList.remove(buddy);
            }
        }
    }

    public void setId (Integer index) {
        this.id = index;
    }

    public Integer getId (){
        return this.id;
    }

    public boolean isEmpty () {
        return this.buddyList.size()==0;
    }
}
