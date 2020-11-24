package br.com.rodrigo;

import br.com.rodrigo.controller.BookingController;
import br.com.rodrigo.model.BookingModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BookingController()).build();
    }


    @Test
    public void testMessagePage() throws Exception {
        this.mockMvc.perform(get("/message")).andExpect(status().isOk())
                .andExpect(content().string("Hello there!"));
    }

    @Test
    public void bookingTestGetAll() throws  Exception{

        mockMvc.perform(get("/bookings"))
                .andExpect(status().isOk());
    }

    @Test
    public void bookingTestSave() throws Exception {
        objectMapper = new ObjectMapper();
        LocalDate checkIn  = LocalDate.parse("2020-11-05");
        LocalDate checkOut = LocalDate.parse("2020-11-15");

        BookingModel bookingModel = new BookingModel(1,"Rodrigo",checkIn,checkOut,2);

        String jsonDataString = objectMapper.writeValueAsString(bookingModel);

        mockMvc.perform(
                post("/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonDataString))
                .andExpect(status().isCreated());
    }

    @Test
    public void bookingTestUpdate() throws Exception{
        objectMapper = new ObjectMapper();

        int id = 1;
        LocalDate checkIn  = LocalDate.parse("2020-11-05");
        LocalDate checkOut = LocalDate.parse("2020-11-15");

        BookingModel bookingModel = new BookingModel(1,"Rodrigo",checkIn,checkOut,2);

        String jsonDataString = objectMapper.writeValueAsString(bookingModel);
        mockMvc.perform(
                put("/bookings/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonDataString))
                .andExpect(status().is2xxSuccessful());
    }

}
