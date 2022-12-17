package project1.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import project1.Model.Teacher;
import project1.Services.TeaService;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeaController {
    private final TeaService TeaAPI;
    @GetMapping("/all")
    public ResponseEntity getAll(){return ResponseEntity.status(200).body(TeaAPI.getAll());}

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Teacher Tea, Errors er){
        if (!er.hasErrors())
        {
            TeaAPI.add(Tea);
            return ResponseEntity.status(201).body("Teacher added successfully");
        }
        else
            return ResponseEntity.status(400).body(er.getFieldError().getDefaultMessage());
    }
    @GetMapping("/getByID/{TeaID}")
    public ResponseEntity getTea(@PathVariable int TeaID){

        if(TeaAPI.isTea(TeaID))
            return ResponseEntity.status(200).body(TeaAPI.getTea(TeaID));
        else
            return ResponseEntity.status(400).body("Teacher doesn't exist");

    }
    @PutMapping("/update/{TeaID}")
    public ResponseEntity updateTea(@PathVariable int TeaID, @RequestBody @Valid Teacher Tea){

        if(TeaAPI.isTea(TeaID))
            return ResponseEntity.status(202).body(TeaAPI.updateTea(Tea));
        else
            return ResponseEntity.status(400).body("Teacher doesn't exist");
    }
    @DeleteMapping("/delete/TeaID")
    public ResponseEntity delTea(@PathVariable int TeaID){

        if(TeaAPI.isTea(TeaID))
            return ResponseEntity.status(202).body(TeaAPI.delTea(TeaID));
        else
            return ResponseEntity.status(400).body("Teacher doesn't exist");
    }

    @GetMapping("/getBySalary/{salary}")
    public ResponseEntity getTea(@PathVariable double salary){

            return ResponseEntity.status(200).body(TeaAPI.getTeaOver(salary));

    }




}
