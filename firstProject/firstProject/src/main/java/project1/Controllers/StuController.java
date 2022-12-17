package project1.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import project1.Model.Student;
import project1.Services.StuService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StuController {

    private final StuService stuAPI;

    @GetMapping("/all")
    public ResponseEntity getAll(){return ResponseEntity.status(200).body(stuAPI.getAll());}

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Student stu, Errors er){
        if (!er.hasErrors())
        {
            stuAPI.add(stu);
            return ResponseEntity.status(201).body("Student added successfully");
        }
        else
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
    }
    @GetMapping("/getByID/{stuID}")
    public ResponseEntity getStu(@PathVariable int stuID){

        if(stuAPI.isStu(stuID))
            return ResponseEntity.status(200).body(stuAPI.getStu(stuID));
        else
            return ResponseEntity.status(400).body("Student doesn't exist");

    }
    @GetMapping("/getByName/{stuName}")
    public ResponseEntity getStuByName(@PathVariable String stuName){

            return ResponseEntity.status(200).body(stuAPI.getStuByName(stuName));

    }
    @PutMapping("/update/{stuID}")
    public ResponseEntity updateStu(@PathVariable int stuID, @RequestBody @Valid Student stu){

        if(stuAPI.isStu(stuID))
            return ResponseEntity.status(202).body(stuAPI.updateStu(stu));
        else
            return ResponseEntity.status(400).body("Student doesn't exist");
    }
    @DeleteMapping("/delete/{stuID}")
    public ResponseEntity delStu(@PathVariable int stuID){

        if(stuAPI.isStu(stuID))
            return ResponseEntity.status(202).body(stuAPI.delStu(stuID));
        else
            return ResponseEntity.status(400).body("Student doesn't exist");
    }

    @GetMapping("/getByMajor/{stuMajor}")
    public ResponseEntity getStu(@PathVariable String stuMajor){

        if(stuAPI.isMajor(stuMajor))
            return ResponseEntity.status(200).body(stuAPI.getStuMajoredIn(stuMajor));
        else
            return ResponseEntity.status(400).body("Student doesn't exist");

    }

    @GetMapping("/getByAge/{age}")
    public ResponseEntity getStuByAge(@PathVariable int age){

        return ResponseEntity.status(200).body(stuAPI.getStuOver(age));

    }




}
