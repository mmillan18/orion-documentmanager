package com.unibague.gradework.orionserver.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Document(collection = "sustentations")
public class DocumentSustentation extends Documents {
    private String idWorkSustentation;
}
