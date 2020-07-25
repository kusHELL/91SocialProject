package com.social.cycle.repository;

import com.social.cycle.model.Wheels;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WheelsRepository extends MongoRepository<Wheels, String> {
    @Query("{'spokes.endDate':{$gte:?0},'spokes.startDate':{$lte: ?0 },'tyre.endDate':{$gte:?0},'tyre.startDate':{$lte:?0}},{_id:0,'total':{$sum:'spokes.price','tyre.price'}}")
    Double getInRange(long epochTime);
}
