package br.com.spring.erudio.api_gateway.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ModelMap {

    private static ModelMapper modelMapper = new ModelMapper();


    public static <O,D> D parseObject(O source, Class<D> D) {
        return modelMapper.map(source, D);
    }


    public static <O,D> List<D> ParseListObject(List<O> source, Class<D> D) {
        List<D> destinations = new ArrayList<>();
        source.stream().map(o->modelMapper.map(o, D)).forEach(destinations::add);

        return destinations;
    }
}
