package net.devstudy.resume.controller;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.repository.storage.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PublicDataController {



    @Autowired
    private ProfileRepository profileRepository;

    /*@RequestMapping(value = "/{uid}",method = RequestMethod.GET)
    public String getProfile(@PathVariable("uid") String uid, Model model){
        String fullName = nameService.convertName(uid);
        model.addAttribute("fullName",fullName);
        return "profile";
    }*/



    @RequestMapping(value = "/{uid}",method = RequestMethod.GET)
    public String getProfile(@PathVariable("uid") String uid, Model model){
        //String fullName = nameService.convertName(uid);
        Profile profile = profileRepository.findByUid(uid);
        if (profile==null){
            return "profile_not_found";
        }
        model.addAttribute("profile",profile);
        return "profile";
    }


    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String getError(){
        return "error";
    }

}
