package com.reservationapp.controller;

import com.reservationapp.payload.BusDto;
import com.reservationapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping("/add")
    public ResponseEntity<BusDto> addBus(@RequestBody BusDto busDto) throws ParseException {

        SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
        Date fromDate=format.parse(busDto.getFromDate());
        Date toDate=format.parse(busDto.getToDate());

        BusDto dto=busService.addBuss(busDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


}
