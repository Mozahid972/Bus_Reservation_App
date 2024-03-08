package com.reservationapp.service;

import com.reservationapp.entity.Bus;
import com.reservationapp.entity.Route;
import com.reservationapp.entity.SubRoute;
import com.reservationapp.payload.BusDto;
import com.reservationapp.payload.SubRouteDto;
import com.reservationapp.repository.BusRepository;
import com.reservationapp.repository.RouteRepository;
import com.reservationapp.repository.SubRouteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;


    @Autowired
    private SubRouteRepository subRouteRepository;


   // @Transactional
    public void  addBus(BusDto busDto){

        // Create Route Entity
        Route route = new Route();
        route.setFromLocation(busDto.getRoute().getFromLocation());
        route.setToLocation(busDto.getRoute().getToLocation());
        route.setFromDate(busDto.getRoute().getFromDate());
        route.setToDate(busDto.getRoute().getToDate());
        route.setTotalDuration(busDto.getRoute().getTotalDuration());
        route.setFromTime(busDto.getRoute().getFromTime());
        route.setToTime(busDto.getRoute().getToTime());

        // Save route entity
        Route saveRoute = routeRepository.save(route);

        // Create Bus entity
        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());

        //Associate Bus with route
        bus.setRoute(route);

        //Save Bus entities
        Bus savedBus = busRepository.save(bus);

        Route routeUpdate = routeRepository.findById(saveRoute.getId()).get();
        routeUpdate.setBus(savedBus);
        routeRepository.save(routeUpdate);


        // if there are sub-routes, create and save them
        if (busDto.getSubRoutes() != null && !busDto.getSubRoutes().isEmpty()) {
            for (SubRouteDto subRouteDto : busDto.getSubRoutes()) {
                SubRoute subRoute = new SubRoute();
                subRoute.setFromLocation(subRouteDto.getFromLocation());
                subRoute.setToLocation(subRouteDto.getToLocation());
                subRoute.setFromDate(subRouteDto.getFromDate());
                subRoute.setToDate(subRouteDto.getToDate());
                subRoute.setTotalDuration(subRouteDto.getTotalDuration());
                subRoute.setFromTime(subRouteDto.getFromTime());
                subRoute.setToTime(subRouteDto.getToTime());

                // Associate SubRoute with Route
                subRoute.setRoute(route);

                // Save SubRoute entity
                subRouteRepository.save(subRoute);
            }
        }



    }



}
