package de.xai.handwriting_labeling_app_backend.utils

import java.io.File

class Constants {
    companion object {
        /**
         * path to the root directory where sample images are stored.
         * Under this root dir, there are sub dirs for different kinds of samples.
         */
        private const val SAMPLES_DIR_PATH = "./src/main/resources/public/files/images/samples"
        val samplesDirectory = File(SAMPLES_DIR_PATH)

        /**
         * name of the sub dir within the samples root dir, that contains samples of the reference sentences grouped
         * into further sub dirs ("1" for samples of ref sentence 1, ...)
         */
        const val XAI_SENTENCE_DIRECTORY_NAME = "xai_sentences"
        val xaiSentencesDirectory = File("${samplesDirectory.path}/$XAI_SENTENCE_DIRECTORY_NAME")

        /**
         * name of the sub dir within the samples root dir, that contains samples of greenline random sample recordings
         */
        const val OTHERS_DIRECTORY_NAME = "others"
        val othersDirectory = File("${samplesDirectory.path}/$OTHERS_DIRECTORY_NAME")

        /**
         * path to the root directory where example images are stored.
         * Under this root dir all example images are found.
         */
        private const val EXAMPLE_DIR_PATH = "./src/main/resources/public/files/images/examples"
        val examplesDirectory = File(EXAMPLE_DIR_PATH)

        /**
         * path to the config json withing the project structure
         */
        private const val BATCH_SERVICE_CONFIG_PATH = "./src/main/resources/batch_service_config.json"
        val batchServiceConfigFile = File(BATCH_SERVICE_CONFIG_PATH)


        /**
         * base url of backend. Defined in .env as APP_URL_ROOT and exposed to Spring in application.properties
         * */
        const val SAMPLES_PATH = "/files/images/samples"
        const val EXAMPLES_PATH = "/files/images/examples"

        /**
         * Constant string used to communicate the state of the get batch response.
         * "success" means, that a batch was successfully assembled for the user who requested the batch and the main
         * body of the response contains the samples.
         * */
        const val GET_BATCH_RESPONSE_STATE_SUCCESS = "success"

        /**
         * Constant string used to communicate the state of the get batch response.
         * "finished" means, that there are no tasks left, that the user can give an answer to.
         * The user has answered every task that the BatchServiceConfig specifies.
         * The main body of the response is empty.
         * */
        const val GET_BATCH_RESPONSE_STATE_FINISHED = "finished"

        /**
         * In the DB the role names are prefixed with this.
         * */
        const val ROLE_PREFIX = "ROLE_"

        /**
         * The role names for admin, expert and user. Used in roleNames field of the UserCreateBody.
         * */
        private const val ROLE_NAME_ADMIN = "ADMIN"
        private const val ROLE_NAME_EXPERT = "EXPERT"
        private const val ROLE_NAME_USER = "USER"

        /**
         * The role names for admin, expert and user. Used in DB role table.
         * */
        const val ROLE_ADMIN = "${ROLE_PREFIX}$ROLE_NAME_ADMIN"
        const val ROLE_EXPERT = "${ROLE_PREFIX}$ROLE_NAME_EXPERT"
        const val ROLE_USER = "${ROLE_PREFIX}$ROLE_NAME_USER"
    }
}