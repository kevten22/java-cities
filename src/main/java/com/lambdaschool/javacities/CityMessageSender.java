package com.lambdaschool.javacities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
public class CityMessageSender {
    private final RabbitTemplate rt;
    private final CityRepository cityrepos;

    public CityMessageSender(RabbitTemplate rt, CityRepository cityrepos) {
        this.rt = rt;
        this.cityrepos = cityrepos;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
        ArrayList<City> cities = new ArrayList<City>();

        cities.addAll(cityrepos.findAll());

        for(City r: cities){

        }

    }

}
