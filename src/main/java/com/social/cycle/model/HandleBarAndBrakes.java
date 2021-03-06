package com.social.cycle.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
public class HandleBarAndBrakes {
    @Id
    String id;
    Dates[] handle;
    Dates[] brakes;
}
