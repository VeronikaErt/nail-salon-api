package com.example.nailsalon.controller;
import com.example.nailsalon.entity.Appointment;
import com.example.nailsalon.repository.AppointmentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@Tag(name="Appointment", description="Записи клиентов. Все операции требуют JWT.")
@SecurityRequirement(name="bearerAuth")
public class AppointmentController {
 private final AppointmentRepository repo;
 public AppointmentController(AppointmentRepository repo){this.repo=repo;}
 @Operation(summary="Получить список", description="Возвращает все записи сущности.")
 @GetMapping public List<Appointment> all(){return repo.findAll();}
 @Operation(summary="Получить по ID", description="Возвращает одну запись. Если ID не найден, возвращается 404.")
 @GetMapping("/{id}") public Appointment one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new java.util.NoSuchElementException("Запись не найдена: "+id));}
 @Operation(summary="Создать", description="Создаёт новую запись с проверкой Bean Validation.")
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Appointment create(@Valid @RequestBody Appointment value){return repo.save(value);}
 @Operation(summary="Изменить", description="Полностью обновляет запись по ID после валидации.")
 @PutMapping("/{id}") public Appointment update(@PathVariable Long id,@Valid @RequestBody Appointment value){ if(!repo.existsById(id)) throw new java.util.NoSuchElementException("Запись не найдена: "+id); value.getClass(); try{var f=value.getClass().getDeclaredField("id"); f.setAccessible(true); f.set(value,id);}catch(Exception e){throw new RuntimeException(e);} return repo.save(value);}
 @Operation(summary="Удалить", description="Удаляет запись по ID и возвращает 204.")
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){if(!repo.existsById(id)) throw new java.util.NoSuchElementException("Запись не найдена: "+id); repo.deleteById(id);}
}
