package org.yoganala.lunch.repository;

import org.springframework.data.repository.CrudRepository;
import org.yoganala.lunch.entity.Reservation;

public interface ReservationRepo extends CrudRepository<Reservation,Integer> {
}
