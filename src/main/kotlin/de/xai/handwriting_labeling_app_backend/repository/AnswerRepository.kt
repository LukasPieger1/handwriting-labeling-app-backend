package de.xai.handwriting_labeling_app_backend.repository

import de.xai.handwriting_labeling_app_backend.model.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository: JpaRepository<Answer, Long> {
    fun findAllByUserId(userId: Long): List<Answer>
}