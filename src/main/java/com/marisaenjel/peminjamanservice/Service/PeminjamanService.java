/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marisaenjel.peminjamanservice.Service;

import com.marisaenjel.peminjamanservice.Entity.Peminjaman;
import com.marisaenjel.peminjamanservice.Repository.PeminjamanRepository;
import com.marisaenjel.peminjamanservice.Vo.Anggota;
import com.marisaenjel.peminjamanservice.Vo.Buku;
import com.marisaenjel.peminjamanservice.Vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author acer
 */
@Service
public class PeminjamanService {
   @Autowired
    private PeminjamanRepository peminjamanRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
   
    public Peminjaman savePeminjaman(Peminjaman peminjaman) {
       return peminjamanRepository.save(peminjaman); 
    }

     public ResponseTemplateVO getPeminjaman(Long peminjamanId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Peminjaman peminjaman = peminjamanRepository.findByPeminjamanId(peminjamanId);
        Anggota anggota = restTemplate.getForObject("http://localhost:8080/anggota/" 
              + peminjaman.getAnggotaId(), Anggota.class);
        Buku buku = restTemplate.getForObject("http://localhost:8004/buku/" 
                + peminjaman.getBukuId(), Buku.class);
        vo.setPeminjaman(peminjaman);
        vo.setAnggota(anggota);
        vo.setBuku(buku);
        return vo;
    } 
}
