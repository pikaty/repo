package guide.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {
    private final AppointmentBook appointmentBook;

    @Autowired
    public AppointmentsController(AppointmentBook appointmentBook){
        this.appointmentBook = appointmentBook;
    }

    @RequestMapping(method=RequestMethod.GET)
    public Map<String, Appointment> get() {
        return appointmentBook.getAppointmentsForToday();
    }

    @RequestMapping(value="/{day}", method=RequestMethod.GET)
    public Map<String, Apppointment> getForDay(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date day, Model model){
        return appointmentBook.getAppointmentsForDay(day);
    }

    @RequestMapping(value="/new" , method = RequestMethod.GET)
    public AppointmentForm getNewForm(){
        return new AppointmentForm();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@Valid AppointmentForm appointment, BindingResult result){
        if (result.hasErrors()){
            return "appointments/new";
        }
        appointmentBook.addApointment(appointment);
        return "redirect:appointments";
    }

}
