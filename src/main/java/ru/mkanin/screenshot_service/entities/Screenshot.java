package ru.mkanin.screenshot_service.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "screenshots")
@Entity
@Data
public class Screenshot {

    @Id
    @Column(name = "screenshot_id")
    private String id;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "update_date")
    private String updateDate;

    private boolean updated;
}
