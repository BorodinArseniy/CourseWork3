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
@RequestMapping("/socks")
public class SocksController {
    private final SockService sockService;

    public SocksController(SockService sockService) {
        this.sockService = sockService;
    }

    @GetMapping("/{num}")
    public ResponseEntity<Sock> getSocks(@PathVariable Integer num) {
        if (sockService.getSocks(num) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sockService.getSocks(num));
    }

    @GetMapping("/allSocks")
    public ResponseEntity<Map<Integer, Sock>> getIAllSocks() {
        if (sockService.getAllSocks() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sockService.getAllSocks());
    }

    @PostMapping("/putNewSocks")
    public ResponseEntity<Sock> addNewSocks(@Valid @RequestBody Sock sock){
        sockService.addSocks(sock);
        return ResponseEntity.ok(sock);
    }

    @PutMapping("/{num}")
    public ResponseEntity<Sock> editSocks(@PathVariable Integer num, @Valid @RequestBody Sock sock){
        if (sockService.getSocks(num) == null) {
            return ResponseEntity.notFound().build();
        }
        sockService.changeSock(num, sock);
        return ResponseEntity.ok(sockService.getSocks(num));
    }

    @DeleteMapping("/{num}")
    public ResponseEntity deleteIngredient(@PathVariable Integer num) {
        if (sockService.getSocks(num) == null) {
            return ResponseEntity.notFound().build();
        }
        sockService.deleteSock(num);
        return ResponseEntity.ok().build();
    }
}
