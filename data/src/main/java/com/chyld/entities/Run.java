package com.chyld.entities;

import com.chyld.enums.DeviceTypeEnum;
import com.chyld.enums.ExerciseEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.geometry.Pos;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "runs")
@Data
public class Run {
    private int id;
    private int version;
    private Date start;
    private Date stop;
    private Device device;
    private List<Position> positions;
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
    @JoinColumn(name="device_id")
    @JsonIgnore
    public Device getDevice() {return device;}
    public void setDevice(Device device) {this.device = device;}

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "run")
    public List<Position> getPositions() {return positions;}
    public void setPositions(List<Position> positions) {this.positions = positions;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}
}
