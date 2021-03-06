package net.devstudy.resume.controller;

import net.devstudy.resume.Constants;
import net.devstudy.resume.entity.Profile;

import net.devstudy.resume.service.FindProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;

@Controller
public class PublicDataController {



//    @Autowired
//    private ProfileRepository profileRepository;

    @Autowired
    private FindProfileService findProfileService;

    /*@RequestMapping(value = "/{uid}",method = RequestMethod.GET)
    public String getProfile(@PathVariable("uid") String uid, Model model){
        String fullName = nameService.convertName(uid);
        model.addAttribute("fullName",fullName);
        return "profile";
    }*/



    @RequestMapping(value = "/{uid}",method = RequestMethod.GET)
    public String getProfile(@PathVariable("uid") String uid, Model model){
        //String fullName = nameService.convertName(uid);
        Profile profile = findProfileService.findByUid(uid);
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

    @RequestMapping(value={"/welcome"})
    public String listAll(Model model){
        Page<Profile> profiles = findProfileService.findAll(new PageRequest(0,Constants.MAX_PROFILES_PER_PAGE,new Sort("id")));
        model.addAttribute("profiles",profiles.getContent());
        model.addAttribute("page",profiles);
        return "profiles";

    }



    @RequestMapping(value="/fragment/more",method = RequestMethod.GET)
    public String moreProfiles(
            Model model,
            @PageableDefault(size = Constants.MAX_PROFILES_PER_PAGE)
            @SortDefault(sort = "id")
                    Pageable pageable
    ) throws UnsupportedEncodingException
    {
        Page<Profile> profiles = findProfileService.findAll(pageable);
        model.addAttribute("profiles",profiles.getContent());
        return "fragment/profile-items";

    }

}
