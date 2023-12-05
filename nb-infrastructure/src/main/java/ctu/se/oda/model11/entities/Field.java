package ctu.se.oda.model11.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "fields")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "field_type_id")
    private FieldType fieldType;

    @ManyToOne
    @JoinColumn(name = "notebook_id")
    private Notebook notebook;

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<Value> values = new ArrayList<>();

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<FieldTask> fieldTasks = new ArrayList<>();
}
