package com.yanvelasco.infra.security;

import com.yanvelasco.domain.userapi.entities.UserEntity;
import com.yanvelasco.domain.userapi.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // Repositório para acessar dados de usuário no banco de dados

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Implementação do método para carregar detalhes do usuário pelo e-mail
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Busca o usuário no banco de dados pelo e-mail
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Cria e retorna um objeto UserDetails com base no usuário encontrado
        return User
                .withUsername(userEntity.getEmail()) // Define o nome de usuário como o e-mail
                .password(userEntity.getPassword()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
