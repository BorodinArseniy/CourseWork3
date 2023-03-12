package com.example.coursework3.services;

import com.example.coursework3.modules.Sock;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class SockServiceImpl implements SockService

{

    private static Map<Sock, Integer> sockMap = new HashMap<>();
    @Override
    public void addSocks(Sock sock) {
        if (sockMap.containsKey(sock)) {
            sockMap.put(sock, sockMap.get(sock)+1);
        } else {
            sockMap.put(sock, 1);
        }
    }

    @Override
    public void sellSocks(Sock sock) {
        if (sockMap.containsKey(sock)) {
            sockMap.put(sock, sockMap.get(sock)-1);
        } else {
            throw new RuntimeException("таких носков нет на складе");
        }
    }


    @Override
    public Integer getNumberOfSocks(Sock sock) {
        return sockMap.get(sock);
    }



    @Override
    public void deleteSock(Sock sock) {
        sockMap.remove(sock);
    }
}
