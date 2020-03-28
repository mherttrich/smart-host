package com.smarthost.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
@RestController
public class RoomController {

    @GetMapping("/booking")
    public List<String> booking() {

    return Collections.singletonList("hallo");
    }

}
