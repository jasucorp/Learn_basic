package com.example.demo.controller;

import com.example.demo.Response;
import com.example.demo.constants.ErrorCodeEnum;
import com.example.demo.dto.ClassroomDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Classroom;
import com.example.demo.model.User;
import com.example.demo.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/classrooms")

public class ClassController {

    @Autowired
    private ClassroomRepository classroomRepository;

    @GetMapping
    public List<ClassroomDto> getAllClass()
    {
        return classroomRepository.findAll()
                .stream()
                .parallel()
                .map(ClassroomDto::new)
                .collect(Collectors.toList());
    }



    //get class
    @GetMapping("/{id}")
    public Response<ClassroomDto> getClass(@PathVariable(value = "id") Long id) throws Exception {
        Optional<Classroom> classOptional = classroomRepository.findById(id);

        Classroom classroom = null;
        if(!classOptional.isPresent()){
            return new Response<>(ErrorCodeEnum.NOT_FOUND);
        } else {
            classroom = classOptional.get();
        }

        ClassroomDto classroomDto = new ClassroomDto(classroom);


        return new Response<>(classroomDto);
    }

}
