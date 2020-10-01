package com.acme.homemade.demo.controller;

import com.acme.homemade.demo.domain.model.UserNoChef;
import com.acme.homemade.demo.domain.service.UserNoChefService;
import com.acme.homemade.demo.resource.SaveUserNoChefResource;
import com.acme.homemade.demo.resource.UserNoChefResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserNoChefController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserNoChefService userNoChefService;

    @GetMapping("/userNoChefs")
    public Page<UserNoChefResource> getAllUserNoChef(Pageable pageable) {
        Page<UserNoChef> userNoChef = userNoChefService.getAllUserNoChef(pageable);
        List<UserNoChefResource> resources = userNoChef.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }


    private UserNoChef convertToEntity(SaveUserNoChefResource resource) {
        return mapper.map(resource, UserNoChef.class);
    }

    private UserNoChefResource convertToResource(UserNoChef entity) {
        return mapper.map(entity, UserNoChefResource.class);
    }
}
