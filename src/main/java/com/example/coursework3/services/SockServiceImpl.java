package com.example.coursework3.services;

import com.example.coursework3.modules.Sock;

import java.util.HashMap;
import java.util.Map;

public class SockServiceImpl implements SockService{

    private static Map<Integer, Sock> sockMap = new HashMap<>();

    private static Integer counter = 0;

    @Override
    public void addSocks(Sock sock) {
        counter++;
        sockMap.put(counter, sock);
    }

    @Override
    public Sock getSocks(Integer num) {
        return sockMap.get(num);
    }

    @Override
    public Map<Integer, Sock> getAllSocks() {
        return sockMap;
    }

    @Override
    public void changeSock(Integer num, Sock sock) {
        sockMap.put(num, sock);
    }

    @Override
    public void deleteSock(Integer num){
        sockMap.remove(num);
    }
}
