package com.froyo.service.controller.geospatial;

import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("geospatial")
public class GeospatialRestController {

    @GetMapping("testPointSpringFramework")
    public Point testPointSpringFramework() {

        Point point = new Point(0.0, 0.0);
        return point;
    }

}
