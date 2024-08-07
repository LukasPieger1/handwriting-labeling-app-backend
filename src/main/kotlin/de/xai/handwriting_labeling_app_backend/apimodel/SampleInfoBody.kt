package de.xai.handwriting_labeling_app_backend.apimodel

import de.xai.handwriting_labeling_app_backend.model.Sample
import de.xai.handwriting_labeling_app_backend.repository.SampleRepository


data class SampleInfoBody(
    val id: Long,
    val resourceUrl: String
) {
    companion object {
        fun fromSample(sample: Sample): SampleInfoBody {
            return SampleInfoBody(
                id = sample.id,
                resourceUrl = SampleRepository.getResourceUrl(sample)
            )
        }
    }
}