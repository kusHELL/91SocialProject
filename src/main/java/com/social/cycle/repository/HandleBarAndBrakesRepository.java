package com.social.cycle.repository;

import com.social.cycle.model.HandleBarAndBrakes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface HandleBarAndBrakesRepository extends MongoRepository<HandleBarAndBrakes,String> {

    @Query("{'handle.endDate':{$gte:?0},'handle.startDate':{$lte: ?0 },'brakes.endDate':{$gte:?0},'brakes.startDate':{$lte:?0}},{_id:0,'total':{$sum:'handle.price','brakes.price'}}")
    Double getInRange(long epochTime);

}
