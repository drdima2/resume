package net.devstudy.resume.service;

import net.devstudy.resume.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindProfileService {
    Profile findById(Long id);
    Profile findByUid(String uid);



    Page<Profile> findAll(Pageable pageable);
}
