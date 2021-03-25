package com.hooloovoo.kindergarten.rest;

import com.hooloovoo.kindergarten.domain.database.ChildrenGroup;
import com.hooloovoo.kindergarten.service.ChildrenGroupService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/childrenGroup")
public class ChildredGroupController {
    private final ChildrenGroupService childrenGroupService;


    public ChildredGroupController(ChildrenGroupService childrenGroupService) {
        this.childrenGroupService = childrenGroupService;
    }


    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseBody
    public ChildrenGroup saveChildrenGroup(@RequestBody ChildrenGroup childrenGroup){
        return childrenGroupService.saveChildrenGroup(childrenGroup);
    }
}
