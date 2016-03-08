package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MacLap on 3/8/16.
 */

@Controller
public class MicroblogSpringController {

    @Autowired
    MessageRepository messages;

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("messages", messages.findAll());
        return "home";
    }

    @RequestMapping(path="/add-message", method = RequestMethod.POST)
    public String addMessage(String messageText){
        Message message = new Message(messageText);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path="/delete-message", method=RequestMethod.POST)
    public String deleteMessage(int messageId) {
        messages.delete(messageId);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.GET)
    public String updateMessage(Model model, int updateId) {
        Message message = messages.findOne(updateId);
        model.addAttribute("message", message);
        return "edit";
    }

    @RequestMapping(path="/edit-message", method=RequestMethod.POST)
    public String editMessage(int messageId, String newMessage) {
        Message message = messages.findOne(messageId);
        message.text = newMessage;
        messages.save(message);
        return "redirect:/";
    }
}
