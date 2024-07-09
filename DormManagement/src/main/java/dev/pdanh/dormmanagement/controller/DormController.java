package dev.pdanh.dormmanagement.controller;

import dev.pdanh.dormmanagement.dto.request.DormCreateRequest;
import dev.pdanh.dormmanagement.dto.request.GuestCreateRequest;
import dev.pdanh.dormmanagement.dto.request.LeaseCreateRequest;
import dev.pdanh.dormmanagement.dto.request.RoomCreateRequest;
import dev.pdanh.dormmanagement.dto.response.DormResponse;
import dev.pdanh.dormmanagement.dto.response.GuestResponse;
import dev.pdanh.dormmanagement.dto.response.UserResponse;
import dev.pdanh.dormmanagement.mapper.DormMapper;
import dev.pdanh.dormmanagement.mapper.RoomMapper;
import dev.pdanh.dormmanagement.mapper.UserMapper;
import dev.pdanh.dormmanagement.model.*;
import dev.pdanh.dormmanagement.repository.DormRepository;
import dev.pdanh.dormmanagement.repository.GuestRepository;
import dev.pdanh.dormmanagement.repository.LeaseRepository;
import dev.pdanh.dormmanagement.repository.RoomRepository;
import dev.pdanh.dormmanagement.service.DormService;
import dev.pdanh.dormmanagement.service.LeaseService;
import dev.pdanh.dormmanagement.service.RoomService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;

@Controller
@RequestMapping("/dorm")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DormController {
    DormRepository dormRepository;
    DormService dormService;
    UserMapper userMapper;
    RoomService roomService;
    DormMapper dormMapper;
    RoomRepository roomRepository;
    LeaseRepository leaseRepository;
    RoomMapper roomMapper;
    LeaseService leaseService;
    GuestRepository guestRepository;

    @PostMapping("/create")
    public String createDorm(@ModelAttribute("dormCreateRequest") DormCreateRequest request, Model model, HttpSession session) {
        User user = userMapper.toUser((UserResponse) session.getAttribute("user"));
        request.setUser(user);
        Dorm dorm = dormRepository.save(dormMapper.toDorm(request));

        for (int i = 1; i <= request.getNumberRoom(); i++) {
            RoomCreateRequest request1 = new RoomCreateRequest();
            request1.setDorm(dorm);
            request1.setStatus(true);
            request1.setRoomNum(i);
            roomService.createRoom(request1);
        }

        return "redirect:/admin/manage";
    }

    @GetMapping("/manage/{id}")
    public String manageDorm(Model model, @PathVariable int id) {
        Dorm findDorm = dormService.findDormById(id);
        if (findDorm == null) {
            model.addAttribute("nodormfound", "No dorm found by ID");
            return "Frontend-Dorm/dorm-manage";
        } else {
            GuestResponse guest = (GuestResponse) model.asMap().get("guest");
            GuestCreateRequest request = new GuestCreateRequest();
            LeaseCreateRequest leaseCreateRequest = new LeaseCreateRequest();
            model.addAttribute("leaseCreate", leaseCreateRequest);
            model.addAttribute("guestCreateRequest", request);
            model.addAttribute("dormfound", findDorm);
            List<Room> rooms = roomService.getAll(findDorm);
            model.addAttribute("listroom", rooms);
            List<Lease> leaseList = leaseRepository.findAll();

            if (!leaseList.isEmpty()) {
                Hashtable<Room, Guest> roomGuestHashtable = new Hashtable<>();
                leaseList.forEach((l) -> {
                    roomGuestHashtable.put(l.getRoom(), l.getGuest());
                });
                model.addAttribute("guestRoomTable", roomGuestHashtable);
            }
            return "Frontend-Dorm/dorm-manage";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteDorm(@PathVariable int id) {
        Dorm dorm = dormRepository.findById(id);
        List<Room> rooms = roomService.getAll(dorm);
        rooms.forEach((r) -> {
            List<Lease> leaseList = leaseService.findByRoom(r);
            leaseList.forEach((l) -> {
                Guest g = l.getGuest();
                leaseRepository.delete(l);
                guestRepository.delete(g);
            });
        });
        rooms.forEach((r) -> {
            roomRepository.delete(r);
        });
        dormRepository.deleteById(id);
        return "redirect:/admin/manage";
    }
}

