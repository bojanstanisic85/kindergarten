package com.hooloovoo.kindergarten.rest;

import com.hooloovoo.kindergarten.domain.database.ChildrenGroup;
import com.hooloovoo.kindergarten.service.ChildrenGroupService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/childrenGroup")
public class ChildrenGroupController {
    private final ChildrenGroupService childrenGroupService;


    public ChildrenGroupController(ChildrenGroupService childrenGroupService) {
        this.childrenGroupService = childrenGroupService;
    }


    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseBody
    public ChildrenGroup saveChildrenGroup(@RequestBody ChildrenGroup childrenGroup){
        return childrenGroupService.saveChildrenGroup(childrenGroup);
    }

    //TODO get za svu djecu
    //TODO istesitrati da li radi kreiranje childredGrupa za svu djecu koja  se proslijede sa FE-a
}
