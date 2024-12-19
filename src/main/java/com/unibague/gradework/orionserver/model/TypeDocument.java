package com.unibague.gradework.orionserver.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a type of proposal.
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Document(collection = "types")
public class TypeDocument {
    @Id
    private String idTypeDocument;
    private String name;
}
