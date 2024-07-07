package dev.pdanh.dormmanagement.controller;

import dev.pdanh.dormmanagement.dto.request.GuestCreateRequest;
import dev.pdanh.dormmanagement.dto.request.LeaseCreateRequest;
import dev.pdanh.dormmanagement.dto.response.UserResponse;
import dev.pdanh.dormmanagement.mail.Mail;
import dev.pdanh.dormmanagement.mapper.GuestMapper;
import dev.pdanh.dormmanagement.mapper.LeaseMapper;
import dev.pdanh.dormmanagement.model.Dorm;
import dev.pdanh.dormmanagement.model.Guest;
import dev.pdanh.dormmanagement.model.Room;
import dev.pdanh.dormmanagement.repository.DormRepository;
import dev.pdanh.dormmanagement.repository.GuestRepository;
import dev.pdanh.dormmanagement.repository.LeaseRepository;
import dev.pdanh.dormmanagement.repository.RoomRepository;
import dev.pdanh.dormmanagement.service.GuestService;
import dev.pdanh.dormmanagement.service.LeaseService;
import dev.pdanh.dormmanagement.service.MailSenderService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/guest")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class GuestController {
    GuestMapper guestMapper;
    GuestService guestService;
    GuestRepository guestRepository;
    DormRepository dormRepository;
    LeaseRepository leaseRepository;
    LeaseService leaseService;
    MailSenderService mailSenderService;
    RoomRepository roomRepository;
    private final LeaseMapper leaseMapper;

    @PostMapping("/add/{id}")
    public String addGuest(@ModelAttribute("guestCreateRequest") GuestCreateRequest guest,
                           @ModelAttribute("leaseCreate") LeaseCreateRequest leaseCreateRequest,
                           @RequestParam("roomId") int roomID,
                           @PathVariable int id,
                           HttpSession session, RedirectAttributes redirectAttributes) {
        UserResponse user = (UserResponse) session.getAttribute("user");
        if (user != null) {
        Guest guestCreate = guestMapper.toGuest(guest);
        Guest guestSaved = guestRepository.save(guestCreate);
        leaseCreateRequest.setGuest(guestSaved);
        Room room = roomRepository.findRoomById(roomID);
        room.setStatus(false);
        leaseCreateRequest.setRoom(room);
        roomRepository.save(room);
        leaseRepository.save(leaseMapper.toLease(leaseCreateRequest));
        Dorm dorm = dormRepository.findById(id);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Mail mail = new Mail();
        mail.setTo(guestCreate.getEmail());
        mail.setFrom("qalido.app@gmail.com");
        mail.setSubject("DANG KI THUE TRO THANH CONG");
        mail.setBody("Thank you for choosing my dormitory to rent and live.\n" +
                "Your contract will start at " + format.format(leaseCreateRequest.getStartDate()) + " and end at " + format.format(leaseCreateRequest.getEndDate()) + "\n" +
                "Dorm name : " + dorm.getName() + "\n" +
                "Dorm address: " + dorm.getAddress() + "\n" +
                "Your room: " + leaseCreateRequest.getRoom().getRoomNum() + "\n" +
                "Wish you have a good time in this room.");
        mailSenderService.sendMail(mail);
        redirectAttributes.addFlashAttribute("Guest", guestCreate);
        return "redirect:/dorm/manage/" + id;
    }else{
            redirectAttributes.addFlashAttribute("warning", "You are not logged in.");
            return "redirect:/signin";
        }
    }
}