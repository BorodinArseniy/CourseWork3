package com.example.coursework3.services;

import com.example.coursework3.modules.Sock;

import java.util.Map;

public interface SockService {
    void addSocks(Sock sock);
    Sock getSocks(Integer num);

    Map<Integer, Sock> getAllSocks();

    void changeSock(Integer num, Sock sock);

    void deleteSock(Integer num);
}
