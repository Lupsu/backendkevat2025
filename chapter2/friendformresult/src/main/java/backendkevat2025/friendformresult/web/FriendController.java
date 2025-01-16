package backendkevat2025.friendformresult.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backendkevat2025.friendformresult.domain.Friend;

@Controller
public class FriendController {

    @RequestMapping(value="/add", method = RequestMethod.GET)
	public String addFriendForm(Model model) {
		model.addAttribute("friend", new Friend());
		return "friendform";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
	public String addFriendSubmit(@ModelAttribute Friend frnd, Model model) {
		new Friend(frnd.getFirstName(), frnd.getLastName());
		model.addAttribute("friend", frnd);
		return "result";
    }

	@RequestMapping(value="/friends", method = RequestMethod.GET)
	public String showFriends(Model model) {
		model.addAttribute("friendsList", Friend.getFriendsList());
		return "friendlist";	
	}
}