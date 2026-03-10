package br.edu.utfpr.pb.pw45s.projetofinal.validator;

import br.edu.utfpr.pb.pw45s.projetofinal.dto.UserDTO;
import br.edu.utfpr.pb.pw45s.projetofinal.model.User;
import br.edu.utfpr.pb.pw45s.projetofinal.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Objects;
import java.util.Optional;

public class UserValidator implements ConstraintValidator<ValidUser, UserDTO> {

    @Autowired
    private UserRepository repository;

    @Override
    public boolean isValid(UserDTO entity, ConstraintValidatorContext context) {
        return validateUniqueUsername(entity, context);
    }

    private boolean validateUniqueUsername(UserDTO entity, ConstraintValidatorContext context) {
        Optional<User> optionalUser = repository.findByUsername(entity.getUsername());

        boolean isValid = optionalUser
                .map(user -> Objects.equals(user.getId(), entity.getId()))
                .orElse(true);

        if (!isValid) {
            handleMessage(context, "O nome de usuário informado já está em uso", "username");
        }

        return isValid;
    }

    private void handleMessage(ConstraintValidatorContext context, String message, String node) {
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(node)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }
}