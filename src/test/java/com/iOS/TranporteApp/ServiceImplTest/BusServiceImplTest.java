package com.iOS.TranporteApp.ServiceImplTest;

import com.iOS.TranporteApp.Dto.BusDto;
import com.iOS.TranporteApp.Entity.Bus;
import com.iOS.TranporteApp.Impl.BusServiceImpl;
import com.iOS.TranporteApp.Repository.BusRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BusServiceImplTest {
    @InjectMocks
    private BusServiceImpl busServiceImpl;
    @Mock
    private BusRepository busRepository;
    @Mock
    private ModelMapper modelMapper;
    @Test
    public void testGetBusById(){
        Long id_bus = 1L;
        Bus bus = new Bus();
        bus.setId_Bus(id_bus);

        Mockito.when(busRepository.findById(id_bus)).thenReturn(Optional.of(bus));
        BusDto busDto = new BusDto();
        Mockito.when(modelMapper.map(bus, BusDto.class)).thenReturn(busDto);

        BusDto result = busServiceImpl.getBusById(id_bus);
        Assertions.assertNotNull(result);
        Mockito.verify(busRepository).findById(id_bus);



    }
}
