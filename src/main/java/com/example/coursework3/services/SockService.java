package com.example.coursework3.services;

import com.example.coursework3.modules.Sock;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface SockService {
    void addSocks(Sock sock);

    void sellSocks(Sock sock);

    Integer getNumberOfSocks(Sock sock);

    void deleteSock(Sock sock);
}
