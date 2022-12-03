package org.sojuton.skeleton.controller;

import lombok.RequiredArgsConstructor;
import org.sojuton.skeleton.service.SkeletonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skeleton")
@RequiredArgsConstructor
public class SkeletonController {

    private final SkeletonService skeletonService;

    @GetMapping
    public String test() {
        return skeletonService.test();
    }
}
