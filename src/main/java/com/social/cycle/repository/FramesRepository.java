package com.social.cycle.repository;

import com.social.cycle.model.Frames;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FramesRepository extends MongoRepository<Frames, String> {
    @Query("{'material.endDate':{$gte:?0},'material.startDate':{$lte: ?0 },'type.endDate':{$gte:?0},'type.startDate':{$lte:?0}},{_id:0,'total':{$sum:'material.price','type.price'}}")
    Double getFrameInRange(long epochTime);

}
