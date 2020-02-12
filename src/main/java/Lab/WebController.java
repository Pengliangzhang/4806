package Lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    private AddressBookRepository bookRepository;
    @Autowired
    private BuddyInfoRepository buddyRepository;
    private AddressBook book = new AddressBook(1);
    @GetMapping("/home")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "homePage"; //view
    }

    @GetMapping("/")
    public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "homePage"; //view
    }

    @GetMapping("/createaddressbook")
    public String createBook (Model model, AddressBookRepository repository){
        this.book = new AddressBook(1);
        model.addAttribute("BookId", book.getId().toString());
        bookRepository.save(book);
        return "AddressBookCreated"; //view
    }

    @GetMapping("/createBuddyInfo")
    public String createBuddy (@RequestParam(name="name", required = true, defaultValue = "john") String name, @RequestParam(name = "phonenum", required = false, defaultValue = "00000000") int num, Model model){
        BuddyInfo buddy = new BuddyInfo(name, num);
        model.addAttribute("name", name);
        model.addAttribute("phoneNum", buddy.getPhoneNum());
        this.book.addBuddyInfo(buddy);
        buddyRepository.save(buddy);
        bookRepository.save(this.book);
        return "BuddyInfoCreated";//view
    }

    @GetMapping ("/getbuddy")
    public String getBuddy (@RequestParam(name="name", required = true) String name, Model model){
        String buddyInfo = "";
        for (BuddyInfo temp: buddyRepository.findByname(name)){
            buddyInfo += temp.toString() + "\n";
        }
        model.addAttribute("buddyInfo", buddyInfo);
        return "BuddyResult";
    }

    @GetMapping ("/getall")
    public String getBuddy (Model model){
        AddressBook book1 = this.bookRepository.findById(1);
        System.out.println("Book ........................................................."+ book1);
//        model.addAttribute("buddyInfo", book1.toString());
        return "BuddyResult";
    }

    @GetMapping("/removebuddy")
    public String removeBuddy (@RequestParam(name ="name", required = true) String name){
        this.book.removeBuddy(name);
        this.bookRepository.save(this.book);
        return "DeletedPage";
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {

        model.addAttribute("buddyObj", new BuddyInfo());
        return "buddySubmit";
    }

    @GetMapping("/hello")
    public String hello(@ModelAttribute BuddyInfo buddyInfo, Model model) {
//        model.addAttribute("buddyObj", new BuddyInfo());

        model.addAttribute("buddyObj", new BuddyInfo());

//        this.book.addBuddyInfo(buddyInfo);
//        buddyRepository.save(buddyInfo);
//        bookRepository.save(this.book);


        return "hello";
    }

    @PostMapping(value = "/json", produces = "application/json")
    @ResponseBody
    public List<BuddyInfo> returnJson(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        System.out.println("New request for JSON");
//        this.book.addBuddyInfo(buddyInfo);
//        buddyRepository.save(buddyInfo);
//        bookRepository.save(this.book);
        AddressBook book1 = this.bookRepository.findById(1);
//        System.out.println("Book: " + book1);

        List<BuddyInfo> list = book.getBuddyList();
        for(BuddyInfo buddy : list){
            System.out.println(buddy);
        }

        return list;
    }

    @PostMapping("/hello")
    public void greetingSubmit(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        model.addAttribute("buddyObj", buddyInfo);
        this.book.addBuddyInfo(buddyInfo);
        buddyRepository.save(buddyInfo);
        bookRepository.save(this.book);

//        return "hello";
    }
}
