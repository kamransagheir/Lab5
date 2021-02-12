package addressbook;

import addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class addressBookController {

    @Autowired
    AddressBookRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        AddressBook book = new AddressBook();
        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }

    @PostMapping("/")
    public String addBuddy(@ModelAttribute BuddyInfo buddy, Model model) {
        AddressBook book  = repository.findById(new Long(1)).orElse(new AddressBook());
        book.addBuddy(buddy);
        buddy.setAddressBook(book);
        repository.save(book);

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }
    @PostMapping("/remove")
    public String removeBuddy(@ModelAttribute BuddyInfo buddy, Model model) {
        AddressBook book  = repository.findById(new Long(1)).orElse(new AddressBook());
        book.removeBuddy(buddy);
        buddy.setAddressBook(book);
        repository.save(book);
        
        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }
    

}
