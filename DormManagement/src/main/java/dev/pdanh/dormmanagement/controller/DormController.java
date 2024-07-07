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
import dev.pdanh.dormmanagement.model.Dorm;
import dev.pdanh.dormmanagement.model.Room;
import dev.pdanh.dormmanagement.model.User;
import dev.pdanh.dormmanagement.repository.DormRepository;
import dev.pdanh.dormmanagement.service.DormService;
import dev.pdanh.dormmanagement.service.RoomService;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    private final RoomMapper roomMapper;

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

        return "redirect:/admin/dashboard";
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
            model.addAttribute("leaseCreate",leaseCreateRequest);
            model.addAttribute("guestCreateRequest", request);
            model.addAttribute("dormfound", findDorm);
            List<Room> rooms = roomService.getAll(findDorm);
            model.addAttribute("listroom", rooms);
            return "Frontend-Dorm/dorm-manage";
        }
    }
}

