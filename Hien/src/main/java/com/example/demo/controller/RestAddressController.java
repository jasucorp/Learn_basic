package com.example.demo.controller;

//import com.example.demo.repository.AddressRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class RestAddressController {
//    @Autowired
//    AddressRepository addressRepository;
//
//    @GetMapping("/{level}")
//    public Response<List<AddressDto>> getCustomer(@PathVariable(value = "level") Integer level)  {
//        List<AddressDto> list = addressRepository
//                .findAllByLevel(level)
//                .stream()
//                .parallel()
//                .map(AddressDto::new)
//                .collect(Collectors.toList());
//
//        return new Response<>(list);
//    }
}
