package com.nttdata.hotelapp.service;

import com.nttdata.hotelapp.model.Room;
import com.nttdata.hotelapp.repository.db.RoomRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Flux<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Mono<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Mono<Room> createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Mono<Room> updateRoom(Long id, Room room) {
        room.setId(id);
        return roomRepository.save(room);
    }

    public Mono<Void> deleteRoom(Long id) {
        return roomRepository.deleteById(id);
    }
}