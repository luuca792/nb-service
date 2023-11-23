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
@Builder
@Table(name = "notebooks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String  description;

    @Column(name = "project_id", nullable = false, unique = true)
    private UUID projectId;

    @OneToMany(mappedBy = "notebook", cascade = CascadeType.ALL)
    private List<Field> fields = new ArrayList<>();
}
