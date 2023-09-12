package com.nur.command.reserve.create;

import an.awesome.pipelinr.Command;
import com.nur.dtos.ReserveDTO;
import com.nur.factories.persons.IPersonaFactory;
import com.nur.factories.persons.PersonaFactory;
import com.nur.factories.reserve.IReserveFactory;
import com.nur.factories.reserve.ReserveFactory;
import com.nur.model.Personas;
import com.nur.model.Reserve;
import com.nur.repositories.IPersonRepository;
import com.nur.repositories.IReserveRepository;
import com.nur.util.PersonMapper;
import com.nur.util.ReserveMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateReserveHandler implements Command.Handler<CreateReserveCommand, ReserveDTO>{
    private final IReserveRepository reserveRepository;

    private final IReserveFactory reserveFactory;

    public CreateReserveHandler(IReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
        this.reserveFactory = new ReserveFactory();
    }
    @Override
    public ReserveDTO handle(CreateReserveCommand request) {
        Reserve reserve = null;
        try {
            reserve = reserveFactory.createReserve(request.reserveDTO.getDateIn(), request.reserveDTO.getDateOut(), request.reserveDTO.getDetails());
            UUID id = reserveRepository.create(reserve);
            reserve.id = id;
            return ReserveMapper.from(reserve);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
