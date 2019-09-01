package net.devstudy.resume.service.impl;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.entity.Skill;
import net.devstudy.resume.entity.SkillCategory;
import net.devstudy.resume.form.SignUpForm;
import net.devstudy.resume.repository.storage.ProfileRepository;
import net.devstudy.resume.repository.storage.SkillCategoryRepository;
import net.devstudy.resume.service.EditProfileService;
import net.devstudy.resume.exception.CantCompleteClientRequestException;
import net.devstudy.resume.util.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

@Service
public class EditProfileServiceImpl implements EditProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EditProfileServiceImpl.class);

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;



    @Value("${generate.uid.suffix.length}")
    private int generateUidSuffixLength;

    @Value("${generate.uid.max.try.count}")
    private int maxTryCountToGenerateUid;

    private String generateUidAlphabet;


    @Override
    @Transactional
    public Profile createNewProfile(SignUpForm signUpForm) {
        Profile profile = new Profile();
        profile.setUid(generateProfileUid(signUpForm));
        profile.setFirstName(DataUtil.capitalizeName(signUpForm.getFirstName()));
        profile.setLastName(DataUtil.capitalizeName(signUpForm.getLastName()));
        profile.setPassword(signUpForm.getPassword());
        profile.setCompleted(false);
        profileRepository.save(profile);

        return null;
    }

    private String generateProfileUid(SignUpForm signUpForm) throws  CantCompleteClientRequestException{
        String baseUid = DataUtil.generateProfileUid(signUpForm);
        String uid = baseUid;
        for (int i = 0; profileRepository.countByUid(uid)>0 ; i++) {
            uid = DataUtil.regenerateUidWithRandomSuffix(baseUid, generateUidAlphabet, generateUidSuffixLength);
            if (i>=maxTryCountToGenerateUid){
                throw new CantCompleteClientRequestException("Can't generate unique uid for profile: " + baseUid + ": maxTryCountToGenerateUid detected");
            }
        }
        return uid;
    }

    @Override
    public List<Skill> listSkills(long idProfile) {
        return  profileRepository.findById(idProfile).getSkills();
        //Profile profile =  profileRepository.findById(idProfile);
        //return null;

    }

    @Override
    public List<SkillCategory> listSkillCategories() {
        return  skillCategoryRepository.findAll(new Sort("id"));


    }

    @Override
    @Transactional
    public void updateSkills(long idProfile, List<Skill> updateData) {
        Profile profile = profileRepository.findOne(idProfile);
        if (CollectionUtils.isEqualCollection(updateData,profile.getSkills())){
            LOGGER.debug("Profile skills: nothing to update");
            return;
        }
        else{
            profile.setSkills(updateData);
            profileRepository.save(profile);
        }
    }
}
