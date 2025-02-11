package com.nttdata.hotelapp.repository.db;


import com.nttdata.hotelapp.model.Room;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends ReactiveCrudRepository<Room, Long> {

}
