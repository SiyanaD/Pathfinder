package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.data.RouteRepository;
import bg.softuni.pathfinder.model.Picture;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {
    private RouteRepository routeRepository;

    private Random random;
    private ModelMapper modelMapper;
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.random=new Random();
        this.modelMapper=new ModelMapper();

    }

    @Transactional
    public RouteShortInfoDTO getRandomRoute(){

        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount);

        Optional<Route> route = routeRepository.findById(randomId);

        if(route.isEmpty()){
            //throw exception; return empty
        }

      RouteShortInfoDTO dto =  modelMapper.map( route.get(),RouteShortInfoDTO.class);

        Optional<Picture> first = route.get().getPictures().stream().findFirst();
        dto.setImageUrl(first.get().getUrl());

        return dto;
        // Map to DTO
    }
}
