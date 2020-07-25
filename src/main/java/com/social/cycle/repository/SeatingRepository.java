package com.social.cycle.repository;

import com.social.cycle.model.Seating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface SeatingRepository extends MongoRepository<Seating,String> {
    @Query("{'color.endDate':{$gte:?0},'color.startDate':{$lte: ?0 },'type.endDate':{$gte:?0},'type.startDate':{$lte:?0}},{_id:0,'total':{$sum:'color.price','type.price'}}")
    Double getInRange(long epochTime);
}
