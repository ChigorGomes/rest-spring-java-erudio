package br.com.spring.erudio.api_gateway.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMap {

    private static ModelMapper modelMapper = new ModelMapper();


    public static <Source,Destination> Destination parseObject(Source source, Class<Destination> destination) {
        return modelMapper.map(source, destination);
    }


    public static <Source,Destination> List<Destination> ParseListObject(List<Source> source,
                                                                         Class<Destination> destination) {
        return source.stream()
        .map(sourceObject->modelMapper.map(sourceObject, destination))
                .collect(Collectors.toList());

    }
}
