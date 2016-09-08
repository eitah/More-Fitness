package com.chyld.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "positions")
@Data
public class Position {
    private int id;
    private int version;
    private float latitude;
    private float longitude;
    private float altitude;
    private Date current;
    private Run run;
    private Date created;
    private Date modified;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @ManyToOne
    @JoinColumn(name="run_id")
    @JsonIgnore
    public Run getRun() {return run;}
    public void setRun(Run run) {this.run = run;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}
}
