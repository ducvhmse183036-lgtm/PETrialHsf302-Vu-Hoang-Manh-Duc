package sum25.se183036.pehsf302trialexamse183036.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "sony_products")
@AllArgsConstructor
@NoArgsConstructor
public class SonyProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productID;

    @NotBlank(message = "Product name is required")
    @Size(min = 5, max = 50, message = "Product name must be between 5 and 50 characters")
    @Column(name = "product_name", length = 50)
    private String productName;

    @Min(value = 100, message = "Price must be >= 100")
    @Column(name = "price")
    private int price;

    @Min(value = 0, message = "Stock must be >= 0")
    @Max(value = 1000, message = "Stock must be <= 1000")
    @Column(name = "stock")
    private int stock;

    @CreationTimestamp
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "cate_id")
    // BỎ @NotNull vì sẽ validate thủ công trong controller
    private SonyCategories category;



}
