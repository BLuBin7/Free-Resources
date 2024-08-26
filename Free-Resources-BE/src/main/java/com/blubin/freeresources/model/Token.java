package com.blubin.freeresources.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.ColumnDefault;

//@Entity(name = "Token")
//@Table(name = "token")
@Entity(name = "Token")
@Table(name = "token")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    @SequenceGenerator(name = "token_sequence", sequenceName = "token_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_sequence")
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "token", nullable = false, unique = true, columnDefinition = "TEXT")
    private String token;

    @Enumerated(EnumType.STRING)
    @Column(name = "token_type", nullable = false)
    private TokenType tokenType = TokenType.BEARER;

    @Column(name = "revoked")
    @ColumnDefault("false")
    private boolean revoked;

    @Column(name = "expired")
    @ColumnDefault("false")
    private boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("tokens")
    private User user;
}
