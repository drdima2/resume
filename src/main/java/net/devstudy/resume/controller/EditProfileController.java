package net.devstudy.resume.controller;

import net.devstudy.resume.form.SkillForm;
import net.devstudy.resume.repository.storage.ProfileRepository;
import net.devstudy.resume.repository.storage.SkillCategoryRepository;
import net.devstudy.resume.service.EditProfileService;
import net.devstudy.resume.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class EditProfileController {

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;



    @Autowired
    private EditProfileService editProfileService;


    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String getEditProfile(){
        return "edit";
    }

    @RequestMapping(value = "/edit/skills",method = RequestMethod.GET)
    public String getEditSkills(Model model){
        SkillForm skillForm = new SkillForm(editProfileService.listSkills(SecurityUtil.getCurrentIdProfile()));
        model.addAttribute("skillForm",skillForm);
        return gotoSkillsJSP(model);
    }

    @RequestMapping(value = "/edit/skills",method = RequestMethod.POST)
    public String saveEditSkills(@Valid @ModelAttribute("skillForm") SkillForm form, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return gotoSkillsJSP(model);
        }
        //TODO Update skills
        editProfileService.updateSkills(SecurityUtil.getCurrentIdProfile(),form.getItems());
        return "redirect:/mike-ross";
    }



    private String gotoSkillsJSP(Model model) {
        model.addAttribute("skillCategories",editProfileService.listSkillCategories());
        return "edit/skills";
    }

}
