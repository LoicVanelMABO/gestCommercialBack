package com.example.start.services;

import com.example.start.entities.Ticket;
import com.example.start.repositories.TicketRepository;
import com.example.start.user.UserEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    private HttpSession session;

    public void creer (Ticket ticket ){
        Object user = session.getAttribute("user");
        UserEntity userSession = (UserEntity) user;
        ticket.setOpenDate( new Date());
        ticket.setInitUser(userSession.getId().toString());
        this.ticketRepository.save(ticket);
    }
}
