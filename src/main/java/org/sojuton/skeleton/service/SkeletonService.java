package org.sojuton.skeleton.service;

import lombok.RequiredArgsConstructor;
import org.sojuton.skeleton.model.dao.SkeletonDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkeletonService {

    private final SkeletonDao skeletonDao;

    public String test() {
        return skeletonDao.test();
    }

}
