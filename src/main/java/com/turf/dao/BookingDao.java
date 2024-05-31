package com.turf.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turf.entity.BookedSlots;

@Repository
public interface BookingDao extends JpaRepository<BookedSlots, Long> {
	
	@Query(value="SELECT * FROM booked_slots WHERE user_id =:userId",nativeQuery = true)
	List<BookedSlots> findBookingByUserId(long userId);



}
