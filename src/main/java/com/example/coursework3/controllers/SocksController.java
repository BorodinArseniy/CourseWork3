package com.example.coursework3.controllers;

import com.example.coursework3.modules.Sock;
import com.example.coursework3.services.SockService;
import jdk.jfr.Percentage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/socks")
public class SocksController {
    private final SockService sockService;

    public SocksController(SockService sockService) {
        this.sockService = sockService;
    }

    @GetMapping("/{sock}")
    public ResponseEntity<Sock> getSocks(@PathVariable Sock sock) {
        if (sockService.getNumberOfSocks(sock) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sock);
    }
    @PostMapping("/putNewSocks")
    public ResponseEntity<Sock> addNewSocks(@Valid @RequestBody Sock sock){
        sockService.addSocks(sock);
        return ResponseEntity.ok(sock);
    }

    @PostMapping("/sellSocks")
    public ResponseEntity<Sock> sellSocks(@Valid @RequestBody Sock sock){
        sockService.sellSocks(sock);
        return ResponseEntity.ok(sock);
    }

    @DeleteMapping("/{sock}")
    public ResponseEntity deleteSocks(@PathVariable Sock sock) {
        if (sockService.getNumberOfSocks(sock) == null) {
            return ResponseEntity.notFound().build();
        }
        sockService.deleteSock(sock);
        return ResponseEntity.ok().build();
    }
}
