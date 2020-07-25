package com.social.cycle.repository;

import com.social.cycle.model.ChainAssembly;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ChainAssemblyRepository extends MongoRepository<ChainAssembly, String> {

    @Query("{'chain.endDate':{$gte:?0},'chain.startDate':{$lte: ?0 },'socketWheels.endDate':{$gte:?0},'socketWheels.startDate':{$lte:?0}},{_id:0,'total':{$sum:'chain.price','socketWheels.price'}}")
    Double getInRange(long epochTime);
}
