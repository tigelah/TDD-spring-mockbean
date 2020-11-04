package br.com.rodrigo.service;

import br.com.rodrigo.model.BookingModel;
import br.com.rodrigo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Period;
import java.util.Optional;

public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public int daysCalculatorWithDatabase(String name) {

        Optional<BookingModel> model = bookingRepository.findByReserveName(name);
        return Period.between(model.get().getCheckIn(),model.get().getCheckOut()).getDays();
    }
}
