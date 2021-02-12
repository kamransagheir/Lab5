package addressbook; 

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "addressBook")
    private List<BuddyInfo> buddies;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public AddressBook(Long id) {
        this.id = id;
        this.buddies = new ArrayList<BuddyInfo>();
    }

    public AddressBook(){
    	this.buddies = new ArrayList<BuddyInfo>();
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }


    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    public List<BuddyInfo> getBuddies(){
        return buddies;
    }

	public boolean removeBuddy(BuddyInfo buddy) {
		if (buddies.size() == 0) {
			return false;
		}
		else {
			for(int i =0; i < buddies.size(); i++) {
				if(buddies.get(i).getName().equals(buddy.getName())){
					buddies.remove(i);
				}
			}
		}
		return true;
	}

    public Long getId() {
        return id;
    }

    public BuddyInfo getBuddy(String name) {
        for (BuddyInfo buddy: buddies) {
            if (buddy.getName().equals(name)) {
            	return buddy;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String returnValue = "";
        for (BuddyInfo buddy: buddies) {
            returnValue += buddy.toString() + "\n";
        }
        return returnValue;
    }

    public List<BuddyInfo> getBuddiesInAddressbook() {
		return buddies;
	}
    
}
