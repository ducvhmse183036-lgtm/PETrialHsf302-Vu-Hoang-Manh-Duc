package sum25.se183036.pehsf302trialexamse183036.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "sony_categories")
@AllArgsConstructor
@NoArgsConstructor
public class SonyCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private int cateId;
    @Column(name = "cate_name", length = 50)
    private String cateName;
    @Column(name = "status", length = 10)
    private String status;
    @OneToMany(mappedBy = "category")
    private List<SonyProducts> products = new ArrayList<>();
}
