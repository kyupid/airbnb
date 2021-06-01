package com.team03.airbnb.controller;

import com.team03.airbnb.dao.LocationDAO;
import com.team03.airbnb.dto.HotelCardDTO;
import com.team03.airbnb.dto.HotelCardWithCoordinateDTO;
import com.team03.airbnb.dto.HotelDetailDTO;
import com.team03.airbnb.entity.Location;
import com.team03.airbnb.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private LocationDAO locationDAO;

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Location> findAllLocations(@RequestParam(required = false) Integer limit) {
        List<Location> list = locationDAO.findAll(limit);
        return list;
    }

    @GetMapping("/{locationName}")
    public List<HotelCardDTO> findAllHotelCardsByLcationName(@PathVariable String locationName) {
        List<HotelCardDTO> hotels = hotelService.findAllHotelCardsByLocationName(locationName);
       return hotels;
    }

    @GetMapping("/detail/{id}")
    public HotelDetailDTO findHotelDetailById(@PathVariable Long id) {
        HotelDetailDTO hotelDetailDTO = hotelService.findHotelDetailByID(id);
        return hotelDetailDTO;
    }

    @GetMapping("/coordinate")
    public List<HotelCardWithCoordinateDTO> findHotelsByCoordinate(@RequestParam Double x, @RequestParam Double y, @RequestParam Double zoom) {
        List<HotelCardWithCoordinateDTO> list = hotelService.findHotelsAroundCurrentLocation(x, y, zoom);
       return list;
    }
}