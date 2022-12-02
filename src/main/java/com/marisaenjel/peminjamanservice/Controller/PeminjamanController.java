/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.marisaenjel.peminjamanservice.Controller;



import com.marisaenjel.peminjamanservice.Entity.Peminjaman;
import com.marisaenjel.peminjamanservice.Service.PeminjamanService;
import com.marisaenjel.peminjamanservice.Vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
   @Autowired
    private PeminjamanService peminjamanService;
    
    @PostMapping("/")
    public Peminjaman savePeminjaman(@RequestBody Peminjaman peminjaman){
        return peminjamanService.savePeminjaman(peminjaman);
    }
    
    @GetMapping("/{id}")
    public ResponseTemplateVO getPeminjaman(@PathVariable("id") Long peminjamanId){
        return peminjamanService.getPeminjaman(peminjamanId);
    } 
}
