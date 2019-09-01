package net.devstudy.resume.service.impl;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.repository.storage.ProfileRepository;
import net.devstudy.resume.service.FindProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindProfileServiceImpl implements FindProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile findById(Long id) {
        return profileRepository.findById(id);

    }

    @Override
    public Profile findByUid(String uid) {
        return profileRepository.findByUid(uid);

    }

    @Override
    public Page<Profile> findAll(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }
}
