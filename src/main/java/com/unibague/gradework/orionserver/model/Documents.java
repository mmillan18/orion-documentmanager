package com.unibague.gradework.orionserver.model;

import com.unibague.gradework.orionserver.enumerator.TypeStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Document(collection = "documents")
public class Documents {
    @Id
    private String idDocument;
    private String document;
    private LocalDate dateRelease;
    private TypeStatus statusDocument;
    private LocalDate dateExposition;
    private Map<String, String> statusDocumentMap;

    @DBRef
    private TypeDocument type;
}
