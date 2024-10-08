package de.xai.handwriting_labeling_app_backend.service

import de.xai.handwriting_labeling_app_backend.apimodel.UserCreateBody
import de.xai.handwriting_labeling_app_backend.model.User
import de.xai.handwriting_labeling_app_backend.repository.RoleRepository
import de.xai.handwriting_labeling_app_backend.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, val roleRepository: RoleRepository): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        return userRepository.findByUsername(username!!)!!
    }

    fun createUserIfNotExist(userCreateBody: UserCreateBody): User? {
        val userWithNameFromDB = userRepository.findByUsername(userCreateBody.username)

        return if (userWithNameFromDB == null) {
            userRepository.save(User(
                username = userCreateBody.username,
                password = BCryptPasswordEncoder(12).encode(userCreateBody.password),
                roles = userCreateBody.roleNames.map { roleName ->
                    roleRepository.findByName("ROLE_${roleName}")
                }.toSet()
            ))
        } else {
            null
        }
    }
}