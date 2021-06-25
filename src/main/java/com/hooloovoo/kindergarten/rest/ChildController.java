package com.hooloovoo.kindergarten.rest;

import com.hooloovoo.kindergarten.domain.database.Child;
import com.hooloovoo.kindergarten.service.ChildService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/child")
public class ChildController {
    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @RequestMapping(value = "{childId}", method = RequestMethod.GET)
    public Child getChild(@PathVariable("childId") Long childId) {
        return childService.getChildById(childId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Child createChild(@RequestBody Child child) {
        return childService.saveChild(child);
    }

}
