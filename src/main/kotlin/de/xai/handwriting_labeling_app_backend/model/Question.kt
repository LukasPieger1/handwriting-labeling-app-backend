package de.xai.handwriting_labeling_app_backend.model

import jakarta.persistence.*

@Entity
class Question(

    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var instructionText: String? = null
)