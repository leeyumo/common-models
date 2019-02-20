package com.leeyumo.common.models;

import com.leeyumo.common.converter.InstantLongConverter;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@Data
public abstract class BaseEntity extends AbstractAggregateRoot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Convert(converter = InstantLongConverter.class)
    @Setter(AccessLevel.PRIVATE)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    @Convert(converter = InstantLongConverter.class)
    @Setter(AccessLevel.PRIVATE)
    private Instant updatedAt;

    @Version
    @Column(name = "version")
    @Setter(AccessLevel.PRIVATE)
    private Integer version;

    @PrePersist
    public void prePersist(){
        this.setCreatedAt(Instant.now());
        this.setUpdatedAt(Instant.now());
    }

    @PreUpdate
    public void preUpdate(){
        this.setUpdatedAt(Instant.now());
    }

    public String toString() {
        return this.getClass().getSimpleName() + "-" + getId();
    }
}
