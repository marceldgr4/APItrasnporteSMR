package com.iOS.TranporteApp.Impl;

import com.iOS.TranporteApp.Dto.PQRDto;
import com.iOS.TranporteApp.Entity.PQR;
import com.iOS.TranporteApp.Repository.PQR_Repository;
import com.iOS.TranporteApp.Service.PQRService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PQRServiceImpl implements PQRService {
    @Autowired
    private PQR_Repository pqrRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PQRDto createPQR(PQRDto pqrDto) {
        PQR pqr = modelMapper.map(pqrDto, PQR.class);
        pqr = pqrRepository.save(pqr);
        return modelMapper.map(pqr, PQRDto.class);
    }
    @Override
    public PQRDto getPQRById(Long id_PQR) {
        PQR pqr = pqrRepository.findById(id_PQR).orElseThrow(()-> new RuntimeException("PQR not found"));
        return modelMapper.map(pqr, PQRDto.class);
    }
    @Override
    public List<PQRDto> getAllPQR() {
        List<PQR> pqrs = pqrRepository.findAll();
        return pqrs.stream().map(pqr -> modelMapper.map(pqr,PQRDto.class))
                .collect(Collectors.toList());
    }

}
