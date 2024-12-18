package com.financeModule.CRUD.Controller;


import com.financeModule.CRUD.Services.ResourceService;
import com.financeModule.CRUD.model.Project;
import com.financeModule.CRUD.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/getAllResources")
    public ResponseEntity<List<Resource>> getAllResources() {
        return resourceService.getAllResources();
    }


}
