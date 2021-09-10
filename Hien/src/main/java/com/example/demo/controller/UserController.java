package com.example.demo.controller;


import com.example.demo.Response;
import com.example.demo.constants.ErrorCodeEnum;
import com.example.demo.dto.AchivementDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.*;
import com.example.demo.repository.AchivementRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.annotation.Documented;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

import static com.example.demo.constants.ErrorCodeEnum.USER_EXIST;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AchivementRepository achivementRepository;

    @Autowired
    private EntityManager manager;

    @GetMapping("/check-duplicate/")
    public Response<Boolean> CheckUserExist(@RequestBody String phone){
        String sqli = "SELECT entity FROM User entity";

        String whereClause = " WHERE (1=1)";

        whereClause += " AND entity.phone LIKE :phone ";

        sqli += whereClause;

        Query query1 = manager.createQuery(sqli, User.class);

        query1.setParameter("phone", "%" + phone + "%");

        if (query1.getResultList().size() > 0){
            return new Response<>(true);
        } else {
            return new Response<>(false);
        }

    }
    //get list cus
    @GetMapping
    public List<UserDto> getAllUser()
    {
        return userRepository.findAll()
                .stream()
                .parallel()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }



    //get cus
    @GetMapping("/{id}")
    public Response<UserDto> getUser(@PathVariable(value = "id") Long id) throws Exception {
        Optional<User> userOptional = userRepository.findById(id);

        User user = null;
        if(!userOptional.isPresent()){
            return new Response<>(ErrorCodeEnum.NOT_FOUND);
        } else {
            user = userOptional.get();
        }

        UserDto userDto = new UserDto(user);


        return new Response<>(userDto);
    }



    public static int checkMail(String str) {
        int f = 0;

        try {
            String pt = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
            Pattern p = Pattern.compile(pt);
            Matcher m = p.matcher(str);
            if(m.matches()) f=1;
        }catch(PatternSyntaxException e) {
            f=-1;
            e.getMessage();  //thong bao nhung ko hien ra man hinh
        }finally {
            if(f==-1) {
                System.out.println("Sai cu phap!");
            }
            if(f==0) {
                System.out.println("Khong dung dinh dang");
            }
        }

        return f;
    }


    //creat cus
    @PostMapping()
    public Response<UserDto> createUser(@RequestBody UserDto userDto)
    {
        if(userDto.getRole().getName().equals("tutor") ){
            User entity = new User();
            entity.setUsername(userDto.getUsername());

            if(checkMail(userDto.getEmail()) == 1){
                entity.setEmail(userDto.getEmail());
            }
            else {
                return new Response<>(ErrorCodeEnum.BAD_FORMAT);
            }

            entity.setPassword(userDto.getPassword());
            entity.setBirthday(userDto.getBirthday());
            entity.setGender(userDto.getGender());
            entity.setAddress(userDto.getAddress());
            entity.setPhone(userDto.getPhone());

            Tutor tutor = new Tutor();
            tutor.setKnowledge(userDto.getKnowledge());
            tutor.setSchool(userDto.getSchool());
            tutor.setExperience(userDto.getExperience());

            List<Achivement> achivements = new ArrayList<>();
            List<AchivementDto> achivementDtos = userDto.getTutor().getAchivement();
            if(achivementDtos != null && achivementDtos.size() > 0){
                List<Achivement> achivementList = achivementRepository.findAll();
                Map<Long, Achivement> achivementMap = new HashMap<>();
                achivementList.parallelStream().forEach(item -> achivementMap.put(item.getId(), item));

                for(AchivementDto achivementDto: achivementDtos){
                    Achivement achivement = achivementMap.get(achivementDto.getId());
                    achivements.add(achivement);

                    achivement.setTutor(tutor);
                }
            }

            tutor.setAchivement(achivements);
            tutor.setSubjectname(userDto.getSubjectname());
            tutor.setUser(entity);

            Role role = roleRepository.findById(userDto.getRole().getId()).get();

//            Achivement achivement = achivementRepository.findById(tutorDto.getAchivement().getId().get());

            entity.setRole(role);

            entity.setTutor(tutor);
            if(!CheckUserExist(userDto.getPhone()).getData()){
                User user = userRepository.save(entity);
                return new Response<>(ErrorCodeEnum.DONE);
            } else {
                return new Response<>(ErrorCodeEnum.USER_EXIST);
            }
        }

        if(userDto.getRole().getName().equals("student") ){
            User entity = new User();
            entity.setId(userDto.getId());
            entity.setUsername(userDto.getUsername());

            if(checkMail(userDto.getEmail()) == 1){
                entity.setEmail(userDto.getEmail());
            }
            else {
                return new Response<>(ErrorCodeEnum.BAD_FORMAT);
            }
            entity.setPassword(userDto.getPassword());
            entity.setBirthday(userDto.getBirthday());
            entity.setGender(userDto.getGender());
            entity.setAddress(userDto.getAddress());
            entity.setPhone(userDto.getPhone());

            Student student = new Student();
            student.setKnowledge(userDto.getKnowledge());
            student.setSchool(userDto.getSchool());

            student.setUser(entity);
            entity.setStudent(student);

            User user = userRepository.save(entity);
//            if(userDto.getPhone().equals(user.getPhone())){
//
//            }

//            user = userRepository.save(entity);

        }
        if(userDto.getId() != null){
            return new Response<>(ErrorCodeEnum.CREATE_MUST_NOT_HAVE_ID);
        };

        return null;
    }

//    @PutMapping("/{id}")
//    public Response<CustomerDto> updateCustom(@PathVariable Long id, @RequestBody CustomerDto customerdetail){
//        Optional<Customer> customerOptional = customerRepository.findById(id);
//
//        Customer customer = null;
//        if(!customerOptional.isPresent()){
//            return new Response<>(ErrorCodeEnum.CUSTOMER_NOT_FOUND);
//        } else {
//            customer = customerOptional.get();
//        }
//
//        if(customerdetail.getUsername() != null && !customerdetail.getUsername().equals(customer.getUsername()))
//            customer.setUsername(customerdetail.getUsername());
//
//        if(customerdetail.getPassword() != null && !customerdetail.getPassword().equals(customer.getPassword()))
//            customer.setPassword(customerdetail.getPassword());
//
//        if(customerdetail.getEmail() != null && !customerdetail.getEmail().equals(customer.getEmail()))
//            customer.setEmail(customerdetail.getEmail());
//
//        Customer entity = customerRepository.save(customer);
//
//        return new Response<>(new CustomerDto(entity));
//    }
//
//    //delete cus
//    @DeleteMapping("/{id}")
//    public Response<CustomerDto> deleteEmployee(@PathVariable Long id){
//        Optional<Customer> customerOptional = customerRepository.findById(id);
//
//        Customer customer = null;
//        if(!customerOptional.isPresent()){
//            return new Response<>(ErrorCodeEnum.CUSTOMER_NOT_FOUND);
//        } else {
//            customer = customerOptional.get();
//           customerRepository.delete(customer);
//
//           return new Response<>(ErrorCodeEnum.DELETE_COMPLETE);
//        }
//
//    }
//
//    //delete all cus
//    @DeleteMapping
//    public Response<CustomerDto> deleteAllEmployee()
//    {
//         customerRepository.deleteAll();
//        return new Response<>(ErrorCodeEnum.DELETE_COMPLETE);
//
//    }



}






















//        Map<String, Boolean> response = new HashMap<>();    <Map<String, Boolean>>
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
