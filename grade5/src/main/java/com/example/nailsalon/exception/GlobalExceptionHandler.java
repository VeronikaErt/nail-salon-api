package com.example.nailsalon.exception;
import io.swagger.v3.oas.annotations.Hidden; import jakarta.servlet.http.HttpServletRequest; import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.time.*; import java.util.*;
@RestControllerAdvice @Hidden public class GlobalExceptionHandler {
 private Map<String,Object> body(HttpStatus s,String msg,HttpServletRequest r){return Map.of("timestamp",Instant.now().toString(),"status",s.value(),"error",s.getReasonPhrase(),"message",msg,"path",r.getRequestURI());}
 @ExceptionHandler(NoSuchElementException.class) ResponseEntity<?> notFound(NoSuchElementException e,HttpServletRequest r){return ResponseEntity.status(404).body(body(HttpStatus.NOT_FOUND,e.getMessage(),r));}
 @ExceptionHandler({IllegalArgumentException.class,IllegalStateException.class}) ResponseEntity<?> bad(RuntimeException e,HttpServletRequest r){return ResponseEntity.badRequest().body(body(HttpStatus.BAD_REQUEST,e.getMessage(),r));}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<?> validation(MethodArgumentNotValidException e,HttpServletRequest r){Map<String,String> errors=new LinkedHashMap<>(); e.getBindingResult().getFieldErrors().forEach(x->errors.put(x.getField(),x.getDefaultMessage())); Map<String,Object> b=new LinkedHashMap<>(body(HttpStatus.BAD_REQUEST,"Ошибка валидации",r)); b.put("fields",errors); return ResponseEntity.badRequest().body(b);}
 @ExceptionHandler(Exception.class) ResponseEntity<?> generic(Exception e,HttpServletRequest r){return ResponseEntity.status(500).body(body(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),r));}
}
