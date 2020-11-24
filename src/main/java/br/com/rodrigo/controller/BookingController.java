package br.com.rodrigo.controller;

import br.com.rodrigo.model.BookingModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@RestController
public class BookingController {

    final static Logger logger = LoggerFactory.getLogger(BookingController.class);

    @GetMapping("/bookings")
    @ResponseBody
    public  String getAll(){
        return "ok";
    }

    @GetMapping(value = "/message", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String message() {

        return "Hello there!";
    }

    @PostMapping("/bookings")
    public ResponseEntity<BookingModel> save( @RequestBody BookingModel bookingModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingModel);
    }

    @PutMapping("bookings/{id}")
    @ResponseBody
    public String update(@RequestBody BookingModel bookingModel) {
        logger.info(MessageFormat.format("Creating Booking in controller: {0}", bookingModel));
        return "Booking created.";
    }
}
