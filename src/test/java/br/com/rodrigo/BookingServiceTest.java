package br.com.rodrigo;

import br.com.rodrigo.model.BookingModel;
import br.com.rodrigo.repository.BookingRepository;
import br.com.rodrigo.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfiguration{
        @Bean
        public BookingService bookingService(){
            return new BookingService();
        }
    }


    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test
    public void bookingTestServiceDaysCalculator(){
        String name = "Rodrigo";
        int days = bookingService.daysCalculatorWithDatabase(name);

        Assertions.assertEquals(days,10);
    }

    @Before
    public void setup(){
        LocalDate checkIn  = LocalDate.parse("2020-11-05");
        LocalDate checkOut = LocalDate.parse("2020-11-15");
        BookingModel model = new BookingModel(1,"Rodrigo",checkIn,checkOut,2);

        Mockito.when(bookingRepository.findByReserveName(model.getReserveName())).thenReturn(java.util.Optional.of(model));
    }
}
