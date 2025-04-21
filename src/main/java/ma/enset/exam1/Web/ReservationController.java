package ma.enset.exam1.Web;

import jakarta.validation.Valid;
import ma.enset.exam1.Dao.Entities.Reservation;
import ma.enset.exam1.Dao.Entities.ReservationType;
import ma.enset.exam1.Dao.Repository.ReservationRepository;
import ma.enset.exam1.Dto.ReservationDTO;
import ma.enset.exam1.Service.IReservationService;
import ma.enset.exam1.Service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    //@Autowired
    //private ReservationRepository reservationRepository;

    @Autowired
    private ReservationServiceImpl reservationService;
    @GetMapping("/user/index")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int page,
                        @RequestParam(name = "size",defaultValue = "5") int size,
                        @RequestParam(name = "empNom",defaultValue = "") String empNom){

        Page<Reservation> pageReservation;
        if(!empNom.isEmpty()){
            pageReservation = reservationService.findByEmployeNom(empNom, PageRequest.of(page, size));
        }else{
            pageReservation = reservationService.findAll(PageRequest.of(page, size));
        }
        model.addAttribute("listReservations",pageReservation.getContent());
        model.addAttribute("empNom",empNom);
        model.addAttribute("pages",new int[pageReservation.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "index";
    }
    @GetMapping("/admin/formReservation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showReservationForm(Model model) {
        model.addAttribute("reservationDto", new ReservationDTO());
        model.addAttribute("reservationTypes", ReservationType.values());
        return "formReservation";
    }

    @PostMapping("/admin/saveReservation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String saveReservation(@Valid @ModelAttribute("reservationDto") ReservationDTO reservationDto,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formReservation";
        }

        reservationService.saveReservation(reservationDto);
        return "redirect:/user/index";
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/user/index";
    }
}
